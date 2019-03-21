package com.windmill.checkwork.controller;

import com.windmill.checkwork.service.CheckWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @类名称：CheckWorkController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:36
 * @说明: 考勤相关控制器
 */
@RestController
public class CheckWorkController {
    @Autowired
    private CheckWorkService checkWorkService;
}
