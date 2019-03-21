package com.windmill.jump;

import org.springframework.stereotype.Controller;
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
}
