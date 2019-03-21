package com.windmill.newspapers.service.impl;

import com.windmill.newspapers.mapper.NewspapersMapper;
import com.windmill.newspapers.pojo.Newspaper;
import com.windmill.newspapers.service.NewspapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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

    @Override
    public Newspaper getNewspaperById(Newspaper newspaper) {
        List<Newspaper> list = newspapersMapper.findNewspaper(newspaper);
        Newspaper newspaper1 = null;
        if (!CollectionUtils.isEmpty(list)){
            newspaper1 = list.get(0);
        }
        return newspaper1;
    }

    @Override
    public int createNewspaper(Newspaper newspaper) {
        return newspapersMapper.createNewspaper(newspaper);
    }

    @Override
    public int updateNewspaper(Newspaper newspaper) {
        return newspapersMapper.updateNewspaper(newspaper);
    }

    @Override
    public int delNewspaper(Newspaper newspaper) {
        return newspapersMapper.delNewspaper(newspaper);
    }
}
