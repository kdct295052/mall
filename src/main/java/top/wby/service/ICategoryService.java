package top.wby.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.wby.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import top.wby.entity.User;

/**
 * <p>
 * 货品分类表 服务类
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
public interface ICategoryService extends IService<Category> {
    IPage<Category> pageCC(Page<Category> userPage, LambdaQueryWrapper<Category> userLambdaQueryWrapper);
}
