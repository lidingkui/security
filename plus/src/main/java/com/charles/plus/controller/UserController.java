package com.charles.plus.controller;

import com.charles.plus.entity.User;
import com.charles.plus.mapper.UserMapper;
import com.charles.plus.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.inject.internal.cglib.core.$Customizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/find-all-user")
    public PageInfo<User> findAll(@RequestParam(value = "pageNum", required = false)int pageNum,
                                  @RequestParam(value = "pageSize", required = false)int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.findll(pageNum, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
