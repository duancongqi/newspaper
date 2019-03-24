package com.windmill.newspapers.controller;

import com.windmill.newspapers.pojo.Newspaper;
import com.windmill.newspapers.service.NewspapersService;
import com.windmill.utils.ResultUtil;
import com.windmill.utils.Uploader;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @类名称：NewspapersController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:03
 * @说明: 报刊相关控制器
 */
@Controller
public class NewspapersController {
    @Autowired
    private NewspapersService newspapersService;
    /**
     * @作者: 段大神经
     * @功能描述: umediter上传方法
     * @时间: 2019/3/21 16:57
     * @参数:  * @param upfile
     * @param request
     * @返回值: java.lang.String
     **/
    @RequestMapping("/uploadUEImage")
    public String uploadUEImage(MultipartFile upfile, HttpServletRequest request){
        Uploader up = new Uploader(request);
        up.setSavePath("upload");
        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
        up.setAllowFiles(fileType);
        up.setMaxSize(10000); //单位KB
        up.upload(upfile);
        String callback = request.getParameter("callback");
        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";
        result = result.replaceAll( "\\\\", "\\\\" );
        if(callback == null ){
            return result ;
        }else{
            return "<script>"+ callback +"(" + result + ")</script>";
        }
    }

    /**
     * @作者: 段大神经
     * @功能描述: 查询新闻内容
     * @时间: 2019/3/21 20:02
     * @参数:  * @param newspaper
     * @返回值: com.windmill.newspapers.pojo.Newspaper
     **/
    @RequestMapping("getNewspaper")
    @ResponseBody
    public List<Newspaper> getNewspaper(){
        return newspapersService.getNewspaper();
    }


    /**
     * @作者: 段大神经
     * @功能描述: 添加新闻
     * @时间: 2019/3/21 20:17
     * @参数:  * @param newspaper
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("createNewspaper")
    public ResultUtil createNewspaper(Newspaper newspaper){
        if (StringUtils.isBlank(newspaper.getNewsNote())){
            return ResultUtil.builder().code("2").msg("内容为空").build();
        }
        if (StringUtils.isBlank(newspaper.getNewsTitle())){
            return ResultUtil.builder().code("2").msg("标题为空").build();
        }
        int i = newspapersService.createNewspaper(newspaper);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("添加失败").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 修改新闻
     * @时间: 2019/3/21 20:20
     * @参数:  * @param newspaper
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("updateNewspaper")
    public ResultUtil updateNewspaper(Newspaper newspaper){
        if (StringUtils.isBlank(newspaper.getNewsNote())){
            return ResultUtil.builder().code("2").msg("内容为空").build();
        }
        if (StringUtils.isBlank(newspaper.getNewsTitle())){
            return ResultUtil.builder().code("2").msg("标题为空").build();
        }
        int i = newspapersService.updateNewspaper(newspaper);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("修改失败").build();
    }
    /**
     * @作者: 段大神经
     * @功能描述: 删除新闻
     * @时间: 2019/3/21 20:23
     * @参数:  * @param newspaper
     * @返回值: com.windmill.utils.ResultUtil
     **/
    @RequestMapping("delNewspaper")
    public ResultUtil delNewspaper(Newspaper newspaper){
        if (newspaper.getNewsId() == null && newspaper.getNewsId() == 0){
            return ResultUtil.builder().code("2").msg("新闻id为空").build();
        }
        int i = newspapersService.delNewspaper(newspaper);
        if (i > 0){
            return ResultUtil.builder().code("1").build();
        }
        return ResultUtil.builder().code("2").msg("删除失败").build();
    }
}
