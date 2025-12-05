package top.wby.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import top.wby.entity.Category;
import top.wby.entity.User;
import top.wby.mapper.CategoryMapper;
import top.wby.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 货品分类表 服务实现类
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
@Resource
private CategoryMapper categoryMapper;
    @Override
    public IPage<Category> pageCC(Page<Category> userPage, LambdaQueryWrapper<Category> userLambdaQueryWrapper) {
        return categoryMapper.pageCC(userPage,userLambdaQueryWrapper);
    }
}
