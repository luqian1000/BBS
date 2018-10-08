package com.taru.bbs.controller;

import com.taru.bbs.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;

@Controller
public class Fileupload {
    //用IOC配置上传路径
    @Resource(name="upload")
    String uploadpath;
    @RequestMapping("/api/common/uploadtest")
    public void test() {
        System.out.print(uploadpath);
    }
    @RequestMapping("/api/common/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file){
        JsonResult result=null;
        try{
            if (!file.isEmpty()){
                System.out.print("访问了");
                String oldFileName=file.getOriginalFilename();
                String newFilename=String.valueOf(System.currentTimeMillis()+oldFileName.substring(oldFileName.lastIndexOf(".")));
                InputStream is=file.getInputStream();
                //Ioc配置上传路径
//                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("E:\\image"+ File.separator + newFilename));
                BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(uploadpath+ File.separator + newFilename));
                byte[] bs=new byte[1024];
                int len;
                while ((len=is.read(bs))!=-1){
                    bos.write(bs,0,len);
                }
                bos.flush();
                bos.close();
                result=new JsonResult("上传成功","200",newFilename);
            }else {

                result=new JsonResult("没有文件","404","");
            }
        }catch (IOException ex){
            result=new JsonResult("上传失败","500","");
        }
        return result;
    }
}
