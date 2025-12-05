package top.wby.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.wby.common.QueryPageParam;
import top.wby.common.Result;
import top.wby.entity.LoginResponse;
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
    public Result save(@Valid @RequestBody User user) {
        return userService.save(user) ? Result.success(true) : Result.fail( false);

    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
    return userService.removeById(id) ? Result.success("删除成功") : Result.fail("删除失败");
}
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        // 只根据账号查询用户
        queryWrapper.eq(User::getNo, user.getNo());

        // 执行查询
        User loginUser = userService.getOne(queryWrapper);

        // 判断用户是否存在且密码正确
        if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
            // 隐藏敏感信息
            loginUser.setPassword(null);

            // 创建登录响应对象
            LoginResponse loginResponse = new LoginResponse(loginUser);

            return Result.success(loginResponse, "登录成功");
        } else {
            // 登录失败
            return Result.fail("用户名或密码错误");
        }
    }

    @PostMapping("/Mod")
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }
    @PostMapping("/saveOrMod")
    public boolean saveOrMod(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @PostMapping("/listP")
    public Result listP(@RequestBody User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        userLambdaQueryWrapper.like(User::getName, user.getName());
        if (user.getName() != null && !user.getName().isEmpty()) {
            userLambdaQueryWrapper.like(User::getName, user.getName());
        }
        return Result.success(userService.list(userLambdaQueryWrapper));
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
        if (query.getParams().containsKey("name") && query.getParams().get("name") != null){
            userLambdaQueryWrapper.like(User::getName, query.getParams().get("name"));
        }
        if (query.getParams().containsKey("sex") && query.getParams().get("sex") != null){
            userLambdaQueryWrapper.eq(User::getSex, query.getParams().get("sex"));
        }
        IPage<User> page = userService.pageCC(userPage,userLambdaQueryWrapper);
        System.out.println("total"+page.getTotal());
        return Result.success(page.getRecords(),page.getTotal());
    }


}
