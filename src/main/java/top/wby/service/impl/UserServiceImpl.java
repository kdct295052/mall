package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.apache.coyote.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.tomcat.util.bcel.classfile.Constant;
import top.wby.entity.User;
import top.wby.mapper.UserMapper;
import top.wby.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wby
 * @since 2025-11-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public IPage<User> pageC(IPage<User> page) {
        return userMapper.pageC(page);
    }

    @Override
    public IPage<User> pageCC(IPage<User> page, Wrapper wrapper) {
        return userMapper.pageCC(page,wrapper);
    }
}
