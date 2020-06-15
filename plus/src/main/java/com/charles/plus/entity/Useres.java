package com.charles.plus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

@Data
// @TableName("你自己的表名")   该注解主要用于实体类跟表名不一致的情况下区分
public class Useres {

//    @TableId
    //加上此注解表示标明该字段为主键
    private Long id;

    // @TableField("name")
    // 加上该注解表示如果你实体类的字段跟表中的字段不一致就要标明一下字段名称
    private String name;

    private int age;

    private String email;

    private Long managerId;

//    @TableField(fill = FieldFill.INSERT)  //该注解表示开启自动填充功能
    private LocalDateTime createTime;

//    @TableField(fill = FieldFill.UPDATE)  //该注解表示开启自动填充功能
    private LocalDateTime updateTime;

    //该字段数据表中不存在，但是又是程序中必须的，那么此时可以加入 transient关键字来忽略
    //可以加上static关键字  这样可以参加序列化  但是表中自动忽略
    // @TableField(exist = false)  加上此注解表示该字段不是数据库中的字段
    private transient String remark;
//
//    @TableLogic   //此注解表示逻辑删除开启不带参数的表示开启全局
//    //逻辑删除标识（0 未删除，   1已删除）
//    @TableField(select = false)
//    private Integer deleted;

}
