package com.windmill.department.service;

import com.windmill.department.pojo.Department;

import java.util.List;

/**
 * @接口名称：DepartmentService
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:44
 * @说明: 部门相关逻辑层接口
 */
public interface DepartmentService {
    List findDepartment();

    int createDepartment(Department department);

    int updateDepartment(Department department);

    int delDepartment(Department department);

    Department getDepartmentById(Integer depId);

    Integer getDepartmentIdByName(String depName);
}
