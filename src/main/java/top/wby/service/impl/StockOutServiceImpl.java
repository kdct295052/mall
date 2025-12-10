package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import top.wby.entity.StockOut;
import top.wby.entity.StockOutDetail;
import top.wby.mapper.StockOutDetailMapper;
import top.wby.mapper.StockOutMapper;
import top.wby.service.IStockOutService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class StockOutServiceImpl extends ServiceImpl<StockOutMapper, StockOut> implements IStockOutService {

    @Resource
    private StockOutMapper stockOutMapper;

    @Resource
    private StockOutDetailMapper stockOutDetailMapper;

    @Override
    public IPage<StockOut> pageCC(IPage<StockOut> page, Wrapper<StockOut> wrapper) {
        return stockOutMapper.pageCC(page, wrapper);
    }

    @Override
    @Transactional
    public boolean addStockOut(StockOut stockOut, List<StockOutDetail> details) {
        // 设置出库单基本信息
        stockOut.setOrderNo(generateOrderNo());
        stockOut.setCreateTime(LocalDateTime.now());
        stockOut.setUpdateTime(LocalDateTime.now());

        // 确保状态有默认值
        if (stockOut.getStatus() == null) {
            stockOut.setStatus((byte) 1); // 1-待审核
        }

        // 保存主表
        save(stockOut);

        // 保存明细并计算总金额
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (StockOutDetail detail : details) {
            detail.setOrderId(stockOut.getId());
            BigDecimal amount = detail.getPrice().multiply(new BigDecimal(detail.getQuantity()));
            detail.setAmount(amount);
            stockOutDetailMapper.insert(detail);
            totalAmount = totalAmount.add(amount);
        }

        // 更新主表总金额
        stockOut.setTotalAmount(totalAmount);
        updateById(stockOut);

        return true;
    }

    @Override
    @Transactional
    public boolean approveStockOut(Integer id) {
        StockOut stockOut = getById(id);
        if (stockOut == null || stockOut.getStatus() != 1) {
            return false;
        }

        // 更新状态为已完成
        stockOut.setStatus((byte) 2); // 2-已完成
        stockOut.setUpdateTime(LocalDateTime.now());
        updateById(stockOut);

        // TODO: 更新库存数量（减库存）

        return true;
    }

    private String generateOrderNo() {
        return "OUT" + System.currentTimeMillis();
    }
}
