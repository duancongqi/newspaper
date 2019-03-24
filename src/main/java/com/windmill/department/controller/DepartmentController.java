package com.windmill.department.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windmill.department.pojo.Department;
import com.windmill.department.service.DepartmentService;
import com.windmill.utils.FileUtil;
import com.windmill.utils.Page;
import com.windmill.utils.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    /**
     * @作者: 段大神经
     * @功能描述: 查询所有部门
     * @时间: 2019/3/21 20:35
     * @参数:  * @param
     * @返回值: java.util.List
     **/
    @RequestMapping("findDepartment")
    public Map<String,Object> findDepartment(Page page){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List departmentList = departmentService.findDepartment();
        PageInfo<Department> departmentListPage = new PageInfo<>(departmentList);
        return ResultUtil.multidata(departmentList,departmentListPage.getTotal());
    }
    /**
     * @作者: 段大神经
     * @功能描述: 添加部门
     * @时间: 2019/3/21 20:45
     * @参数:  * @param department
     * @param request
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("createDepartment")
    public ResultUtil createDepartment(Department department, HttpServletRequest request){
        if (StringUtils.isBlank(department.getDepName())){
            return ResultUtil.builder().code("2").msg("部门名称为空").build();
        }
        if (StringUtils.isBlank(department.getDepFunction())){
            return ResultUtil.builder().code("2").msg("部门职能为空").build();
        }
        if (StringUtils.isNotBlank(department.getDepImg().toString())){
            department.setDepPhoto(FileUtil.fileUpload(department.getDepImg(), request));
        }else {
            return ResultUtil.builder().code("2").msg("部门图片为空").build();
        }
        int i = departmentService.createDepartment(department);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("添加部门失败").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 修改部门
     * @时间: 2019/3/21 20:49
     * @参数:  * @param department
     * @param request
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("updateDepartment")
    public ResultUtil updateDepartment(Department department, HttpServletRequest request){
        if (StringUtils.isBlank(department.getDepName())){
            return ResultUtil.builder().code("2").msg("部门名称为空").build();
        }
        if (StringUtils.isBlank(department.getDepFunction())){
            return ResultUtil.builder().code("2").msg("部门职能为空").build();
        }
        if (StringUtils.isNotBlank(department.getDepImg().toString())){
            department.setDepPhoto(FileUtil.fileUpload(department.getDepImg(), request));
        }else if (StringUtils.isBlank(department.getDepPhoto())){
            return ResultUtil.builder().code("2").msg("部门图片为空").build();
        }
        int i = departmentService.updateDepartment(department);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("修改部门失败").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 删除部门
     * @时间: 2019/3/21 20:50
     * @参数:  * @param department
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("delDepartment")
    public ResultUtil delDepartment(Department department){
        if (department.getDepId() == null && department.getDepId() == 0){
            return ResultUtil.builder().code("2").msg("部门id为空").build();
        }
        int i = departmentService.delDepartment(department);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("删除部门失败").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 根据部门id查询部门以及部门下得所有新闻
     * @时间: 2019/3/21 21:03
     * @参数:  * @param depId
     * @返回值: com.windmill.department.pojo.Department
     **/
    @RequestMapping("getDepartmentById")
    public Department getDepartmentById(@RequestParam Integer depId){
        return departmentService.getDepartmentById(depId);
    }
    /**
     * @作者: 老西儿
     * @功能描述: 查询所有部门
     * @时间: 2019/3/24 16:01
     * @参数:  * @param
     * @返回值: java.util.List
     **/
    @RequestMapping("selectDepartment")
    public List selectDepartment(){
        List departmentList = departmentService.findDepartment();
        return departmentList;
    }
}
