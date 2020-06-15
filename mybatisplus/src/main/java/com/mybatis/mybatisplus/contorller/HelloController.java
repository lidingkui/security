package com.mybatis.mybatisplus.contorller;

import com.mybatis.mybatisplus.entity.User;
import com.mybatis.mybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        List<User> users = userMapper.selectList(null);
        userList.add((User) users);
        return userList;
    }


}
