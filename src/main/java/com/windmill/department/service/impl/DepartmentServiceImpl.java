package com.windmill.department.service.impl;

import com.windmill.department.mapper.DepartmentMapper;
import com.windmill.department.pojo.Department;
import com.windmill.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @类名称：DepartmentServiceImpl
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:44
 * @说明: 部门相关逻辑层
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List findDepartment() {
        return departmentMapper.findDepartment();
    }

    @Override
    public int createDepartment(Department department) {
        return departmentMapper.createDepartment(department);
    }

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public int delDepartment(Department department) {
        return departmentMapper.delDepartment(department);
    }

    @Override
    public Department getDepartmentById(Integer depId) {
        return departmentMapper.getDepartmentById(depId);
    }
}
