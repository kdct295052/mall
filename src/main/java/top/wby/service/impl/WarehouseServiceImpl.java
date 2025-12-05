package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.annotation.Resource;
import top.wby.entity.Warehouse;
import top.wby.mapper.UserMapper;
import top.wby.mapper.WarehouseMapper;
import top.wby.service.IWarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库主表 服务实现类
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements IWarehouseService {
    @Resource
    private WarehouseMapper warehouse;
    @Override
    public IPage<Warehouse> pageCC(IPage<Warehouse> userPage, Wrapper wrapper) {
       return warehouse.pageCC(userPage,wrapper);
    }
}
