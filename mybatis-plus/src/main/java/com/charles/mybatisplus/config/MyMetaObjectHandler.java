package com.charles.mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
 * 填充配置信息类
 * 加上该配置后就可以实现一些必要的字段的自动填充功能
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println();
        setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //updateTime  这个是实体类的字段  不是数据库的字段   要注意
        setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
