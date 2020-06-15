package com.mybatis.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mybatis.mybatisplus.entity.User;
import com.mybatis.mybatisplus.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class MybatisPlusApplicationTests {

    @Resource
    private UserMapper userMapper;

    //增加一个测试方法
    void selectIds() {
        List<Long> list = Arrays.asList(1088248166370832385L, 1088250446457389058L, 1094590409767661570L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
        Assert.assertNotNull(users);
    }


    //map 方法去查询数据
    void selectMap() {
        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("name", "小雅");
        columnMap.put("age", 25);
        List<User> users = userMapper.selectByMap(columnMap);
        users.forEach(System.out::println);
    }


    //条件查询   查询数据库中名字中包含雨并且年龄小于40  name like %雨%  and age <40
    void selectWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.like("name", "雨").lt("age", 40);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    // 名字中包含雨   年龄大于等于20且小于等于40  并且email不为空
    void selectWrapper2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> notNull = queryWrapper.like("name", "雨").between("age", 20, 40).isNotNull("email");
        List<User> users = userMapper.selectList(notNull);
        users.forEach(System.out::println);
    }


    //名字为王姓   或者年龄大于等于25，按照年龄降序排列，年龄相同按照Id升序排列
    //name like '王%' or age>=40  order by age desc ,id asc
    // ge 表示 >=
    void selectWrapper02() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = queryWrapper.likeRight("name", "王%").or().ge("age", 25).orderByDesc("age").orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


    void deleteById() {
        int id = userMapper.deleteById(1267097046255521793L);
        System.out.println(id);
    }


    void insert() {
        User user = new User();
        user.setName("霍建华");
        user.setAge(20);
        user.setEmail("hjh@baomidou.com");
        user.setManagerId(1088250446457389058L);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }


    @Test
    void selectAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    void updatebyId() {
        User user = new User();
        user.setId(1267097046255521793L);
        user.setAge(22);
        int update = userMapper.updateById(user);
        System.out.println(update);
    }

}
