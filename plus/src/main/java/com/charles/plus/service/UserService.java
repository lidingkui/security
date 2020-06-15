package com.charles.plus.service;

import com.charles.plus.entity.User;
import com.charles.plus.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findll(int pageNum, int pageSize) {
        return userMapper.findll();
    }
}
