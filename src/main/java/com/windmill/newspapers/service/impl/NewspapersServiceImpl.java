package com.windmill.newspapers.service.impl;

import com.windmill.newspapers.mapper.NewspapersMapper;
import com.windmill.newspapers.service.NewspapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类名称：NewspapersServiceImpl
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:52
 * @说明:
 */
@Service
public class NewspapersServiceImpl implements NewspapersService {
    @Autowired
    private NewspapersMapper newspapersMapper;
}
