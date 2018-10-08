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
        System.out.println("����");
        System.out.println("����"+userid);
        JsonResult result=null;
        //�����ж��Ƿ������ݲ���
        if (coller.selectOneCol(essayid,userid).size()>0){
            //�������2˵���Ѳ���
            result=new JsonResult("�Ѵ�������","300",2);
        }else {
            try{
                int row= coller.insertCol(essayid,userid);
                if(row ==1){
                    result=new JsonResult("����ɹ�","200",row);
                }else{
                    result=new JsonResult("����ʧ��","404");
                }
            }catch (Exception e){
                result=new JsonResult("�����쳣","500");
            }
        }
        return result;

    }
}
