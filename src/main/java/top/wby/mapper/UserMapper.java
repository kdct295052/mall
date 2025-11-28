package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-11-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    IPage<User> pageC(IPage<User> page);

    IPage<User> pageCC(IPage<User> page, @Param("ew") Wrapper wapper);
}
