package com.windmill.checkwork.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.windmill.checkwork.pojo.CheckWork;
import com.windmill.checkwork.service.CheckWorkService;
import com.windmill.utils.Page;
import com.windmill.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @类名称：CheckWorkController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:36
 * @说明: 考勤相关控制器
 */
@RestController
public class CheckWorkController {
    @Autowired
    private CheckWorkService checkWorkService;
    /**
     * @作者: 段大神经
     * @功能描述: 一键考勤
     * @时间: 2019/3/21 15:48
     * @参数:  * @param checkWork
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("createCheckWork")
    public ResultUtil createCheckWork(CheckWork checkWork){
        List list = checkWorkService.findCheckWorkByNow(checkWork);
        if (!CollectionUtils.isEmpty(list)){
            return ResultUtil.builder().code("2").msg("今天签完到，请确认").build();
        }
        if (CollectionUtils.isEmpty(checkWork.getUserIds())){
            return ResultUtil.builder().code("2").msg("请选择要考勤人员").build();
        }
        checkWorkService.createCheckWork(checkWork);
        return ResultUtil.builder().code("1").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 分页查询所有考勤
     * @时间: 2019/3/21 17:20
     * @参数:  * @param page
     * @param checkWork
     * @返回值: java.util.Map
     **/
    @RequestMapping("findCheckWork")
    public Map findCheckWork(Page page,CheckWork checkWork){
        PageHelper.startPage(page.getPage(),page.getLimit());
        List<CheckWork> list = checkWorkService.findCheckWorkByWhere(checkWork);
        PageInfo<CheckWork> pageInfo = new PageInfo<>(list);
        return ResultUtil.multidata(list,pageInfo.getTotal());
    }
    /**
     * @作者: 段大神经
     * @功能描述: 修改考勤
     * @时间: 2019/3/21 17:47
     * @参数:  * @param checkWork
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("updateCheckWork")
    public ResultUtil updateCheckWork(CheckWork checkWork){
        int i = checkWorkService.updateCheckWork(checkWork);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("修改失败").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 修改考勤
     * @时间: 2019/3/21 17:47
     * @参数:  * @param checkWork
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("updateCheckWorks")
    public ResultUtil updateCheckWorks(CheckWork checkWork){
        int i = checkWorkService.updateCheckWorks(checkWork);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("修改失败").build();
    }
}
