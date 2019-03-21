package com.windmill.department.mapper;

import com.windmill.department.pojo.Department;

import java.util.List;

/**
 * @接口名称：DepartmentMapper
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:44
 * @说明:
 */
public interface DepartmentMapper {
    List findDepartment();

    int createDepartment(Department department);

    int updateDepartment(Department department);

    int delDepartment(Department department);

    Department getDepartmentById(Integer depId);
}
