package com.windmill.newspapers.pojo;

import lombok.Data;

/**
 * @类名称：Newspaper
 * @作者: 段大神经
 * @创建时间: 2019/3/21 12:17
 * @说明: 报纸相关类
 */
@Data
public class Newspaper {
    /**
     * 新闻编号
     */
    private Integer newsId;
    /**
     * 内容
     */
    private String  newsNote;
}
