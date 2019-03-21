package com.windmill.login.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windmill.login.pojo.User;
import com.windmill.login.service.LoginService;
import com.windmill.utils.Page;
import com.windmill.utils.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    /**
     * @作者: 段大神经
     * @功能描述: 登陆
     * @时间: 2019/3/21 16:11
     * @参数:  * @param user
     * @param session
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("login")
    public ResultUtil login(User user, HttpSession session){
        if (StringUtils.isBlank(user.getUserName())){
            return ResultUtil.builder().code("2").msg("用户名为空").build();
        }
        if (StringUtils.isBlank(user.getUserPassword())){
            return ResultUtil.builder().code("2").msg("密码为空").build();
        }
        return loginService.login(user,session);
    }
    /**
     * @作者: 段大神经
     * @功能描述: 创建用户
     * @时间: 2019/3/21 16:43
     * @参数:  * @param user
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("createUser")
    public ResultUtil createUser(User user){
        return loginService.createUser(user);
    }
    /**
     * @作者: 段大神经
     * @功能描述: 修改用户
     * @时间: 2019/3/21 16:44
     * @参数:  * @param user
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("updateUser")
    public ResultUtil updateUser(User user){
        return loginService.updateUser(user);
    }
    /**
     * @作者: 段大神经
     * @功能描述: 根据id删除用户
     * @时间: 2019/3/21 17:00
     * @参数:  * @param userId
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("delUserByUserId")
    public ResultUtil delUserByUserId(@RequestParam Integer userId){
        return loginService.delUserByUserId(userId);
    }
    /**
     * @作者: 段大神经
     * @功能描述: 分页查询所有用户
     * @时间: 2019/3/21 17:00
     * @参数:  * @param page
     * @param user
     * @返回值: java.util.Map
     **/
    @RequestMapping("findUser")
    public Map findUser(Page page,User user){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<User> list = loginService.getUserByWhere(user);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return ResultUtil.multidata(list,pageInfo.getTotal());
    }
    /**
     * @作者: 段大神经
     * @功能描述: 根据id查询用户，用于修改回显
     * @时间: 2019/3/21 19:10
     * @参数:  * @param user
     * @返回值: com.windmill.login.pojo.User
     **/
    @RequestMapping("getUserByUserId")
    public User getUserByUserId(User user){
        List<User> list = loginService.getUserByWhere(user);
        User user1 = null;
        if (!CollectionUtils.isEmpty(list)){
            user1 = list.get(0);
        }
        return user1;
    }
}
