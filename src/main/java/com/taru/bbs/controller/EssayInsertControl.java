package com.taru.bbs.controller;

import java.util.HashMap;
import java.util.List;

import com.taru.bbs.pojo.Essay;
import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class EssayInsertServlet
 */
@Controller
public class EssayInsertControl {
    @Autowired
    EssayService service;
    @RequestMapping(value = "/control/insert/essay")
    public String insertEssay(String essayname,String essaytext,String cateid,String userId, Model model){
        Essay essay=new Essay();
        essay.setEssaycategoryid(cateid);
        essay.setEssayname(essayname);
        essay.setEssaytext(essaytext);
        essay.setEssayuserid(userId);
        //插入贴子
        System.out.print(userId+"撒非常");
        List<HashMap<String ,Object>> list =service.insertEssay(essay);
        System.out.println("详细页");
        model.addAttribute("userId",userId);
        model.addAttribute("list",list);
        return "forward:/essaydetail.jsp";

    }


}
