package top.wby.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wby.mall.entity.User;
import top.wby.mall.service.UserService;

import java.util.List;


@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String test() {
        return "hello world";
    }
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }
}
