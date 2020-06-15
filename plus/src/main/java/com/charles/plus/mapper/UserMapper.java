package com.charles.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charles.plus.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();

    @Insert(" insert into user ( name ) values (#{张三}) ")
    public int save(User user);


    @Delete(" delete from user where id= #{id} ")
    public void delete(int id);

    @Select("select * from user where id= #{id} ")
    public User get(int id);

    @Update("update user set name=#{name} where id=#{id} ")
    public int update(User user);

    @Select(" select * from user")
    List<User> findll();

}
