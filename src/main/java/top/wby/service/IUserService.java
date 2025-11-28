package top.wby.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import top.wby.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wby
 * @since 2025-11-26
 */

public interface IUserService extends IService<User> {
    IPage<User> pageC(IPage<User> page);


    IPage<User> pageCC(IPage<User> userPage, Wrapper wapper);
}
