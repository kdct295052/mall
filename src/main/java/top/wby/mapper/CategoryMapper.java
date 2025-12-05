package top.wby.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.wby.entity.Category;
import top.wby.entity.User;

/**
 * <p>
 * 货品分类表 Mapper 接口
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    IPage<Category> pageCC(Page<Category> categoryPage, @Param("ew") Wrapper wapper);
}
