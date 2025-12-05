package top.wby.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.wby.entity.Warehouse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 仓库主表 服务类
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
public interface IWarehouseService extends IService<Warehouse> {

    IPage<Warehouse> pageCC(IPage<Warehouse> userPage, Wrapper wrapper);
}
