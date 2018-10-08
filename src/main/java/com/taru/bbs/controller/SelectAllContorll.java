package com.taru.bbs.controller;

import com.taru.bbs.pojo.Essay;
import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Controller
public class SelectAllContorll {
//    @Resource(name = "essayServiceImpl")
    @Autowired
    EssayService service;
    @RequestMapping(value="/control/select/essay",method = RequestMethod.GET)
    public String select(Model model,String userId){
        List<Essay> list= service.selectEssay();
        //存下来查询结果，在下一个pjsp页面调用
        //System.out.println(list.get(1).getUser().getUsername().toString());
        model.addAttribute("list", list);
        model.addAttribute("userId", userId);
        //把结果在index页面显示
       System.out.println("登上"+userId);
      return "/index.jsp";
    }
}
