package com.windmill.login.mapper;

import com.windmill.login.pojo.User;

import java.util.List;

/**
 * @接口名称：LoginMapper
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:47
 * @说明:
 */
public interface LoginMapper {
    List getUserByWhere(User user);

    int updateUser(User user);

    int createUser(User user);

    int delUserByUserId(Integer userId);
}
