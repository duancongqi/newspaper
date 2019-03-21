package com.windmill.department.controller;

import com.windmill.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称：DepartmentController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:40
 * @说明: 部门相关控制器
 */
@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
}
