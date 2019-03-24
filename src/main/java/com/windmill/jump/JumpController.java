package com.windmill.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @类名称：JumpController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 12:47
 * @说明:跳转相关控制器
 */
@Controller
public class JumpController {
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
}
