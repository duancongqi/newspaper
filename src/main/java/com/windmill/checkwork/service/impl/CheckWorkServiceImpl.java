package com.windmill.checkwork.service.impl;

import com.windmill.checkwork.mapper.CheckWorkMapper;
import com.windmill.checkwork.service.CheckWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
