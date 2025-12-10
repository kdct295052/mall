package top.wby.service.impl;

import top.wby.entity.Inventory;
import top.wby.mapper.InventoryMapper;
import top.wby.service.IInventoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存总表 - 实时库存数量追踪 服务实现类
 * </p>
 *
 * @author wby
 * @since 2025-12-09
 */
@Service
public class InventoryServiceImpl extends ServiceImpl<InventoryMapper, Inventory> implements IInventoryService {

}
