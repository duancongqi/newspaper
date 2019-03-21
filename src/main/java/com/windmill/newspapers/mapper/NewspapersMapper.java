package com.windmill.newspapers.mapper;

import com.windmill.newspapers.pojo.Newspaper;

import java.util.List;

/**
 * @接口名称：NewspapersMapper
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:50
 * @说明:
 */
public interface NewspapersMapper {
    List<Newspaper> findNewspaper(Newspaper newspaper);

    int createNewspaper(Newspaper newspaper);

    int updateNewspaper(Newspaper newspaper);

    int delNewspaper(Newspaper newspaper);
}
