package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;
import top.wby.entity.Item;
import top.wby.entity.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
@Mapper
public interface ItemMapper extends BaseMapper<Item> {
    IPage<Item> pageC(IPage<Item> page);
    IPage<Item> pageCC(IPage<Item> itemPage,@Param("ew") Wrapper wapper);
}

