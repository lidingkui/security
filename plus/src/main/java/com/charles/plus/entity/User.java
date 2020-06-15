package com.charles.plus.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;
    private String name;
    private int age;
    private String email;
    private String managerId;
    private Date createTime;
    private Date updateTime;
    private int version;
}
