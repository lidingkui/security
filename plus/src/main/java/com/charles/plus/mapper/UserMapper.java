package com.charles.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charles.plus.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

    @Select(" select * from user")
    List<User> findll();

}
