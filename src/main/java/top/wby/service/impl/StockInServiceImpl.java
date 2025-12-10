package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import top.wby.entity.StockIn;
import top.wby.entity.StockInDetail;
import top.wby.mapper.StockInDetailMapper;
import top.wby.mapper.StockInMapper;
import top.wby.service.IStockInService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Service
public class StockInServiceImpl extends ServiceImpl<StockInMapper, StockIn> implements IStockInService {
    @Resource
    private StockInMapper stockInMapper;

    @Resource
    private StockInDetailMapper stockInDetailMapper;

    @Override
    public IPage<StockIn> pageCC(IPage<StockIn> page, Wrapper<StockIn> wrapper) {
        return stockInMapper.pageCC(page, wrapper);
    }

    @Override
    @Transactional
    public boolean addStockIn(StockIn stockIn, List<StockInDetail> details) {
        stockIn.setOrderNo(generateOrderNo());
        stockIn.setCreateTime(LocalDateTime.now());
        stockIn.setUpdateTime(LocalDateTime.now());
        // 确保状态有默认值
        if (stockIn.getStatus() == null) {
            stockIn.setStatus(1);
        }
        save(stockIn);

        // 保存明细
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (StockInDetail detail : details) {
            detail.setOrderId(stockIn.getId());
            BigDecimal amount = detail.getPrice().multiply(new BigDecimal(detail.getQuantity()));
            detail.setAmount(amount);
            stockInDetailMapper.insert(detail);
            totalAmount = totalAmount.add(amount);
        }

        // 更新主表总金额
        stockIn.setTotalAmount(totalAmount);
        updateById(stockIn);

        return true;
    }

    @Override
    @Transactional
    public boolean approveStockIn(Integer id) {
        StockIn stockIn = getById(id);
        if (stockIn == null || stockIn.getStatus() != 1) {
            return false;
        }

        // 更新状态为已完成
        stockIn.setStatus(2);
        stockIn.setUpdateTime(LocalDateTime.now());
        updateById(stockIn);

        // TODO: 更新库存数量

        return true;
    }

    private String generateOrderNo() {
        return "IN" + System.currentTimeMillis();
    }
}
