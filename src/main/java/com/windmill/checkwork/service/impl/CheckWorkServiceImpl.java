package com.windmill.checkwork.service.impl;

import com.windmill.checkwork.mapper.CheckWorkMapper;
import com.windmill.checkwork.pojo.CheckWork;
import com.windmill.checkwork.service.CheckWorkService;
import com.windmill.login.mapper.LoginMapper;
import com.windmill.login.pojo.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @类名称：ChekWorkServiceImpl
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:38
 * @说明:
 */
@Service
public class CheckWorkServiceImpl implements CheckWorkService {
    @Autowired
    private CheckWorkMapper checkWorkMapper;
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public int createCheckWork(CheckWork checkWork) {
        List<String> list = checkWork.getUserIds();
        User user = new User();
        list.forEach(l->{
            user.setUserId(Integer.valueOf(l));
            List list1 = loginMapper.getUserByWhere(user);
            if (!CollectionUtils.isEmpty(list1)){
                User user1 = (User) list1.get(0);
                checkWork.setUserName(user1.getUserName());
                checkWork.setDepName(user1.getDepName());
            }
            if (StringUtils.isNotBlank(checkWork.getUserName()) && StringUtils.isNotBlank(checkWork.getDepName()) ){
                checkWorkMapper.createCheckWork(checkWork);
            }
        });
        return checkWorkMapper.createCheckWork(checkWork);
    }

    @Override
    public List<CheckWork> findCheckWorkByWhere(CheckWork checkWork) {
        return checkWorkMapper.findCheckWorkByWhere(checkWork);
    }

    @Override
    public List findCheckWorkByNow(CheckWork checkWork) {
        return checkWorkMapper.findCheckWorkByNow(checkWork);
    }

    @Override
    public int updateCheckWork(CheckWork checkWork) {
        return checkWorkMapper.updateCheckWork(checkWork);
    }

    @Override
    public int updateCheckWorks(CheckWork checkWork) {
        User user = new User();
        user.setUserId(checkWork.getUserId());
        List<User> userByWhere = loginMapper.getUserByWhere(user);
        if (!CollectionUtils.isEmpty(userByWhere)){
            checkWork.setUserName(userByWhere.get(0).getUserName());
        }else{
            return 0;
        }
        List<CheckWork> checkWorkByWhere = checkWorkMapper.findCheckWorkByNow(checkWork);
        if (CollectionUtils.isEmpty(checkWorkByWhere)){
            checkWork.setDepName(userByWhere.get(0).getDepName());
            checkWork.setIsArrive("1");
            return checkWorkMapper.createCheckWork(checkWork);
        }
        return checkWorkMapper.updateCheckWorks(checkWork);
    }
}
