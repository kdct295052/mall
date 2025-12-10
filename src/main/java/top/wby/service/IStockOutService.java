package top.wby.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.wby.entity.StockOut;
import com.baomidou.mybatisplus.extension.service.IService;
import top.wby.entity.StockOutDetail;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
public interface IStockOutService extends IService<StockOut> {
    IPage<StockOut> pageCC(IPage<StockOut> page, Wrapper<StockOut> wrapper);
    boolean addStockOut(StockOut stockOut, List<StockOutDetail> details);
    boolean approveStockOut(Integer id);
}
