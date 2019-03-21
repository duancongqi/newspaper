package com.windmill.login.service;

import com.windmill.login.pojo.User;
import com.windmill.utils.ResultUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @接口名称：LoginService
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:47
 * @说明: 登陆以及用户相关逻辑层接口
 */
public interface LoginService {
    ResultUtil login(User user, HttpSession session);

    ResultUtil createUser(User user);

    ResultUtil updateUser(User user);

    ResultUtil delUserByUserId(Integer userId);
    //条件查询用户集合
    List getUserByWhere(User user);
}
