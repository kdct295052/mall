package top.wby.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wby.entity.Item;
import top.wby.mapper.ItemMapper;
import top.wby.service.IItemService;
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
}
