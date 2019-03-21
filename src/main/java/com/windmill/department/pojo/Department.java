package com.windmill.department.pojo;

import com.windmill.newspapers.pojo.Newspaper;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @类名称：Department
 * @作者: 段大神经
 * @创建时间: 2019/3/21 12:22
 * @说明: 部门相关类
 */
@Data
public class Department {
    /**
     * 部门id
     */
    private Integer depId;
    /**
     * 部门名称
     */
    private String depName;
    /**
     * 职能
     */
    private String depFunction;
    /**
     * 部门图片地址
     */
    private String depPhoto;
    /**
     * 部门图片流
     */
    private MultipartFile depImg;
    /**
     * 新闻集合
     */
    private List<Newspaper> newspapers;
}
