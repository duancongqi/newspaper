package com.windmill.utils;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类名称: ResultUtil
 * @作者: 段大神经
 * @创建时间: 2018/11/13 10:50
 * @说明: 返回工具类
 */
@Data
@Builder
public class ResultUtil {
    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回状态信息
     */
    private String msg;
    /**
     * 返回值集合
     */
    private Object date;

    /**
     * 返回数据集合
     */
    public static Map<String,Object> multidata(List rows, Long total){
        Map<String,Object> map = new HashMap<>();
        map.put("rows",rows);
        map.put("total",total);
        return map;
    }
}
