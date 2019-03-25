package com.windmill.checkwork.service;

import com.windmill.checkwork.pojo.CheckWork;

import java.util.List;

/**
 * @接口名称：ChekWorkService
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:38
 * @说明: 考勤相关逻辑层
 */
public interface CheckWorkService {
    int createCheckWork(CheckWork checkWork);

    List<CheckWork> findCheckWorkByWhere(CheckWork checkWork);

    List findCheckWorkByNow(CheckWork checkWork);

    int updateCheckWork(CheckWork checkWork);

    int updateCheckWorks(CheckWork checkWork);
}
