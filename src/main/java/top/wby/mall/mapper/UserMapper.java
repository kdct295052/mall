package top.wby.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;
import top.wby.mall.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
