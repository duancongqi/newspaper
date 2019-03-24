package com.windmill.checkwork.pojo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @类名称：CheckWork
 * @作者: 段大神经
 * @创建时间: 2019/3/21 12:27
 * @说明: 考勤相关类
 */
@Data
public class CheckWork {
    /**
     * 考勤id
     */
    private Integer cwId;
    /**
     * 部门名称
     */
    private String depName;
    /**
     * 部门成员姓名
     */
    private String userName;
    /**
     * 是否考勤  0未到，1已到
     */
    private String isArrive;
    /**
     * 用户id集合
     */
    private List userIds;
    /**
     * 创建时间
     */
    private LocalDateTime cwCreateTime;
    /**
     * 用户id
     */
    private Integer userId;

}
