package com.windmill.login.service.impl;

import com.windmill.login.mapper.LoginMapper;
import com.windmill.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类名称：LoginServiceImpl
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:49
 * @说明:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
}
