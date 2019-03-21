package com.windmill.newspapers.controller;

import com.windmill.newspapers.service.NewspapersService;
import com.windmill.utils.Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @类名称：NewspapersController
 * @作者: 段大神经
 * @创建时间: 2019/3/21 13:03
 * @说明: 报刊相关控制器
 */
@RestController
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
}
