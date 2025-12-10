package top.wby.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.wby.entity.StockIn;
import com.baomidou.mybatisplus.extension.service.IService;
import top.wby.entity.StockInDetail;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
public interface IStockInService extends IService<StockIn> {
    IPage<StockIn> pageCC(IPage<StockIn> page, Wrapper<StockIn> wrapper);
    boolean addStockIn(StockIn stockIn, List<StockInDetail> details);
    boolean approveStockIn(Integer id);
}
