package com.windmill.login.controller;

import com.windmill.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称：LoginController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:46
 * @说明: 登陆以及用户相关控制器
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
}
