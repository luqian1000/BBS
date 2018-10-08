package com.taru.bbs.controller;

import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class SelectOneContorl {
    @Autowired
    EssayService essayservice;
    @RequestMapping(value = "/control/SelectOne")
   public String selectOne(String essayId, String userId, Model model){
        List<HashMap<String ,Object>> list=essayservice.selectOneEssay(essayId);
        System.out.println(list.get(0).get("user_name"));
        System.out.println("œÍœ∏“≥userid"+userId);
        model.addAttribute("userId",userId);
        model.addAttribute("essayId",essayId);
        model.addAttribute("list",list);
        return "forward:/essaydetail.jsp";
    }
//    @RequestMapping(value = "/test/selectessay")
//    @ResponseBody
//    public Object selectByIdEssay(String userid){
//        User user=new User();
//        JsonResult result=null;
//        try{
//            user=essayservice.selectEssayById(userid);
//            result=new JsonResult("≤È—Ø≥…π¶","200",user);
//        }catch (Exception e){
//            result=new JsonResult("≤È—Ø ß∞‹","500",user);
//        }
//        return result;
//    }
}
