package com.windmill.login.service.impl;

import com.windmill.login.mapper.LoginMapper;
import com.windmill.login.pojo.User;
import com.windmill.login.service.LoginService;
import com.windmill.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Override
    public ResultUtil login(User user, HttpSession session) {
        List list= loginMapper.getUserByWhere(user);
        if (!CollectionUtils.isEmpty(list)){
            user = (User) list.get(0);
            session.setAttribute("user",user);
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("账号密码不匹配").build();
    }

    @Override
    public ResultUtil createUser(User user) {
        int i = loginMapper.createUser(user);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("添加用户失败").build();
    }

    @Override
    public ResultUtil updateUser(User user) {
        int i = loginMapper.updateUser(user);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("修改用户失败").build();
    }

    @Override
    public ResultUtil delUserByUserId(Integer userId) {
        int i = loginMapper.delUserByUserId(userId);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("删除用户失败").build();
    }

    @Override
    public List getUserByWhere(User user) {
        return loginMapper.getUserByWhere(user);
    }
}
