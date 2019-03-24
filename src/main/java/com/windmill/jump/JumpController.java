package com.windmill.jump;

import com.windmill.department.pojo.Department;
import com.windmill.department.service.DepartmentService;
import com.windmill.newspapers.pojo.Newspaper;
import com.windmill.newspapers.service.NewspapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @类名称：JumpController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 12:47
 * @说明:跳转相关控制器
 */
@Controller
public class JumpController {
    @Autowired
    private NewspapersService newspapersService;
    @Autowired
    private DepartmentService departmentService;
    /**
     * @作者: 段大神经
     * @功能描述: 首页面
     * @时间: 2019/3/21 15:24
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    /**
     * @作者: 老西儿
     * @功能描述: //TODO
     * @时间: 2019/3/21 22:15
     * @参数:  * @param null
     * @返回值: java.lang.String
     **/
    @RequestMapping("toMindex")
    public String toList(){
        return "toMindex";
    }
    /**
     * @作者: 老西儿
     * @功能描述: //TODO
     * @时间: 2019/3/21 23:07
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toDepartment")
    public String toDepartment(){
        return "department/departmentList";
    }
    @GetMapping("toInsertDepartment")
    public String toInsertDepartment(){
        return "department/addDepartment";
    }

    /**
     * @作者: 段大神经
     * @功能描述: 根据id查询新闻内容
     * @时间: 2019/3/21 20:02
     * @参数:  * @param newspaper
     * @返回值: com.windmill.newspapers.pojo.Newspaper
     **/
    @RequestMapping("getNewspaperById")
    public String getNewspaperById(Newspaper newspaper, Model model){
        Newspaper news = newspapersService.getNewspaperById(newspaper);
        model.addAttribute("thisEntity",news);
        return "show";
    }

    /**
     * @作者: 段大神经
     * @功能描述: 根据部门id查询部门以及部门下得所有新闻
     * @时间: 2019/3/21 21:03
     * @参数:  * @param depId
     * @返回值: com.windmill.department.pojo.Department
     **/
    @RequestMapping("getDepartmentByIds")
    public String getDepartmentById(@RequestParam Integer depId,Model model){
        Department department = departmentService.getDepartmentById(depId);
        model.addAttribute("thisEntity",department);
        return "deptShow";
    }
}
