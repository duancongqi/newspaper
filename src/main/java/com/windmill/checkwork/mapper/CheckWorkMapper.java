package com.windmill.checkwork.mapper;

import com.windmill.checkwork.pojo.CheckWork;

import java.util.List;

/**
 * @接口名称：ChekEorkMapper
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:37
 * @说明:
 */
public interface CheckWorkMapper {
    int createCheckWork(CheckWork checkWork);

    List<CheckWork> findCheckWorkByWhere(CheckWork checkWork);

    List findCheckWorkByNow(CheckWork checkWork);

    int updateCheckWork(CheckWork checkWork);

    int updateCheckWorks(CheckWork checkWork);
}
