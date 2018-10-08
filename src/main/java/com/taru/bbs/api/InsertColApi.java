package com.taru.bbs.api;

import com.taru.bbs.common.JsonResult;
import com.taru.bbs.service.ColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class InsertColApi {
    @Autowired
    ColService coller;
    @ResponseBody
    @RequestMapping(value = "/api/insert/col")
    public Object insertCol(String essayid, String userid, Model model){
        int test=2;
        System.out.println("阿飞");
        System.out.println("哈哈"+userid);
        JsonResult result=null;
        //首先判断是否有数据插入
        if (coller.selectOneCol(essayid,userid).size()>0){
            //如果返回2说明已插入
            result=new JsonResult("已存在数据","300",2);
        }else {
            try{
                int row= coller.insertCol(essayid,userid);
                if(row ==1){
                    result=new JsonResult("插入成功","200",row);
                }else{
                    result=new JsonResult("插入失败","404");
                }
            }catch (Exception e){
                result=new JsonResult("插入异常","500");
            }
        }
        return result;

    }
}
