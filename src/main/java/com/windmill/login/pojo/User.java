package com.windmill.login.pojo;

import lombok.Data;

/**
 * @类名称：User
 * @作者: 段大神经
 * @创建时间: 2019/3/21 12:13
 * @说明: 用户相关表
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 用户性别 0:男；1：女
     */
    private Integer userSex;
    /**
     * 学号
     */
    private String stuNumb;
    /**
     * 用户班级
     */
    private String userClass;
    /**
     * 用户电话
     */
    private String userPhone;
    /**
     * 所在部门
     */
    private String depName;
    /**
     * 所在部门编号
     */
   /* private Integer depId;*/
    /**
     * QQ
     */
    private String userQq;
    /**
     * 是否考勤  0未到，1已到
     */
    private String isArrive;
}
