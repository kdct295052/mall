package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.entity.User;
import top.wby.service.IUserService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wby
 * @since 2025-11-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }
    @PostMapping("/save")
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }
    @PostMapping("/Mod")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }
    @GetMapping("/del")
    public boolean delete(Integer id) {
        return userService.removeById(id);
    }
    @PostMapping("/listP")
    public List<User> listP(@RequestBody User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(User::getName, user.getName());
        return userService.list(userLambdaQueryWrapper);
    }
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query) {
        Page<User> userPage = new Page<>();
        userPage.setCurrent(query.getPageNum());
        userPage.setSize(query.getPageSize());
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(User::getName, query.getParams().get("name"));
        IPage<User> page = userService.page(userPage, userLambdaQueryWrapper);
        System.out.println("total"+page.getTotal());
        return page.getRecords() ;
    }
    @PostMapping("/listPageC")
    public Result listPageC(@RequestBody QueryPageParam query) {
        Page<User> userPage = new Page<>();
        userPage.setCurrent(query.getPageNum());
        userPage.setSize(query.getPageSize());
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(User::getName, query.getParams().get("name"));
//        IPage<User> page = userService.pageC(userPage);
        IPage<User> page = userService.pageCC(userPage,userLambdaQueryWrapper);
        System.out.println("total"+page.getTotal());
        return Result.success(page.getRecords(),page.getTotal());
    }


}
