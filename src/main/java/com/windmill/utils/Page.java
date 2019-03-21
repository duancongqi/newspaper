package com.windmill.utils;

import lombok.Data;

/**
 * @类名称：Page
 * @作者: YuBoYaKe
 * @创建时间: 2019/2/25 17:19
 * @说明:
 */
@Data
public class Page {
    /**
     * 当前页数
     */
    private Integer page = 1;
    /**
     * 每页显示条数
     */
    private Integer limit = 5;
}
