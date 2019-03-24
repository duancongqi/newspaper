package com.windmill.jump;

import com.windmill.checkwork.pojo.CheckWork;
import com.windmill.checkwork.service.CheckWorkService;
import com.windmill.department.pojo.Department;
import com.windmill.department.service.DepartmentService;
import com.windmill.login.pojo.User;
import com.windmill.login.service.LoginService;
import com.windmill.newspapers.pojo.Newspaper;
import com.windmill.newspapers.service.NewspapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import javax.servlet.http.HttpSession;

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
    @Autowired
    private LoginService loginService;
    @Autowired
    private CheckWorkService checkWorkService;

    /**
     * @作者: 段大神经
     * @功能描述: 首页面
     * @时间: 2019/3/21 15:24
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @RequestMapping(value = {"index","/"})
    public String index(){
        return "index";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 去管理用中心页面
     * @时间: 2019/3/21 22:15
     * @参数:  * @param null
     * @返回值: java.lang.String
     **/
    @RequestMapping("toMindex")
    public String toList(){
        return "mindex";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转部门管理页面
     * @时间: 2019/3/21 23:07
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toDepartment")
    public String toDepartment(){
        return "department/departmentList";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转到添加部门页面
     * @时间: 2019/3/24 11:31
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toInsertDepartment")
    public String toInsertDepartment(){
        return "department/addDepartment";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转部门修改页面
     * @时间: 2019/3/24 15:26
     * @参数:  * @param request
     * @param modle
     * @返回值: java.lang.String
     **/
    @GetMapping("toUpdateDepartment")
    public String toUpdateaDepartment(HttpServletRequest request,Model modle){
        Department department = new Department();
        department.setDepId(Integer.valueOf(request.getParameter("depId")));
        Department departments = departmentService.getDepartmentById(department.getDepId());
        modle.addAttribute("dep",departments);
        return "department/updateDepartment";
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
        return "firstshow/newsShow";
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
        return "firstshow/deptShow";
    }
    /**
     * @作者: 段大神经
     * @功能描述: 去添加新闻页面
     * @时间: 2019/3/24 12:39
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @RequestMapping("toCreateNews")
    public String toCreateNews(){
        return "newspapers/addnews";
    }
    /**
     * @作者: 段大神经
     * @功能描述: 去新闻管理页面
     * @时间: 2019/3/24 13:44
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @RequestMapping("toNewsPapers")
    public String toNewsPapers(){
        return "newspapers/shownews";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转到成员管理页面
     * @时间: 2019/3/24 15:29
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toUser")
    public String toUser(){
        return "user/userList";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转添加成员页面
     * @时间: 2019/3/24 18:59
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toInsertUser")
    public String toInsertUser(){
        return "user/addUser";
    }
    /**
     * @作者: 跳转添加成员页面
     * @功能描述: //TODO
     * @时间: 2019/3/24 19:04
    * @参数:  * @param request
    * @param model
    * @返回值: java.lang.String
    **/
    @GetMapping("toUpdUser")
    public String toUpdUser(HttpServletRequest request,Model model){
        User user = new User();
        user.setUserId(Integer.valueOf(request.getParameter("userId")));
        List<User> users = loginService.getUserByWhere(user);
        model.addAttribute("userlist",users);
        return "user/updUser";
      }
    /**
     * @作者: 段大神经
     * @功能描述: 退出方法
     * @时间: 2019/3/12 21:53
     * @参数:  * @param session
     * @返回值: java.lang.String
     **/
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
        }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转到考勤管理页
     * @时间: 2019/3/24 19:48
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toCheckWorkList")
    public String toCheckWorkList(){
        return "checkwork/checkworkList";
    }
    /**
     * @作者: 老西儿
     * @功能描述: 跳转到新增考勤页面
     * @时间: 2019/3/24 19:29
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toInsertCheckWork")
    public String toInsertCheckWork(){
        return "checkwork/addCheckWork";
    }
    /**
     * @作者: 段大神经
     * @功能描述: 主展示区欢迎图片
     * @时间: 2019/3/11 16:22
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("toShowLogo")
    public String toShowLogo(){
        return "common/welcome";
    }

    /**
     * @作者: 段大神经
     * @功能描述: 新闻修改页面
     * @时间: 2019/3/11 16:22
     * @参数:  * @param
     * @返回值: java.lang.String
     **/
    @GetMapping("updateNews")
    public String updateNews(Model model,Newspaper newspaper){
        Newspaper newspaperById = newspapersService.getNewspaperById(newspaper);
        model.addAttribute("thisEntity",newspaperById);
        return "newspapers/updnwes";
    }
}

