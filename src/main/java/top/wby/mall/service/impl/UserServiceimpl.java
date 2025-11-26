package top.wby.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wby.mall.entity.User;
import top.wby.mall.mapper.UserMapper;
import top.wby.mall.service.UserService;

@Service
public class UserServiceimpl extends ServiceImpl<UserMapper, User> implements UserService {
}
