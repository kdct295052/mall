package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.wby.entity.Item;
import top.wby.mapper.ItemMapper;
import top.wby.mapper.UserMapper;
import top.wby.service.IItemService;
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
    @Resource
    private ItemMapper ItemMapper;
    @Override
    public IPage<Item> pageC(IPage<Item> itemPage) {
        return ItemMapper.pageC(itemPage);
    }

    @Override
    public IPage<Item> pageCC(IPage<Item> itemPage, Wrapper wapper) {
        return ItemMapper.pageCC(itemPage,wapper);
    }
}
