package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.entity.Category;
import top.wby.entity.User;
import top.wby.service.ICategoryService;
import top.wby.service.IUserService;

/**
 * <p>
 * 货品分类表 前端控制器
 * </p>
 *
 * @author wby
 * @since 2025-12-04
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService ICategoryService;
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        Page<Category> CategoryPage = new Page<>();
        CategoryPage.setCurrent(query.getPageNum());
        CategoryPage.setSize(query.getPageSize());
        LambdaQueryWrapper<Category> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (query.getParams().containsKey("categoryName") && query.getParams().get("categoryName") != null){
            userLambdaQueryWrapper.like(Category::getCategoryName, query.getParams().get("categoryName"));
        }
//        IPage<User> page = userService.pageC(userPage);

        IPage<Category> page = ICategoryService.pageCC(CategoryPage,userLambdaQueryWrapper);
        System.out.println("total"+page.getTotal());
        return Result.success(page.getRecords(),page.getTotal());
    }
    @GetMapping("/list")
    public Result list() {
        return Result.success(ICategoryService.list());
    }
    @PostMapping("/save")
    public Result save(@RequestBody Category category) {
        return ICategoryService.save(category) ? Result.success("保存成功") : Result.fail("保存失败");
    }
    @PostMapping ("/update")
        public Result update(@RequestBody Category category) {
        return ICategoryService.updateById(category) ? Result.success("修改成功") : Result.fail("修改失败");
    }
}
