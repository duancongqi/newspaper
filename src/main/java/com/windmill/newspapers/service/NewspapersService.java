package com.windmill.newspapers.service;

import com.windmill.newspapers.pojo.Newspaper;

import java.util.List;

/**
 * @接口名称：NewspapersService
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:50
 * @说明: 报刊相关逻辑层接口
 */
public interface NewspapersService {
    Newspaper getNewspaperById(Newspaper newspaper);

    int createNewspaper(Newspaper newspaper);

    int updateNewspaper(Newspaper newspaper);

    int delNewspaper(Newspaper newspaper);

    List<Newspaper> getNewspaper();
}
