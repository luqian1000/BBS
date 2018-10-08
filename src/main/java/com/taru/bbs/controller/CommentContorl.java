package com.taru.bbs.controller;

import com.taru.bbs.service.CommentService;
import com.taru.bbs.service.EssayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Controller
public class CommentContorl {
    @Resource
    CommentService comment;
    @Resource
    EssayService essayServiceImpl;
    @RequestMapping(value = "/control/comment")
    public String commentInsert( String fatherid,String userid,String text,String essayid, Model model){
        //插入评论
        int row=comment.insertComment( fatherid,userid,text,essayid);
        System.out.println(fatherid);
        //查询一遍该贴子，相当于刷新
        List<HashMap<String,Object>> list=essayServiceImpl.selectOneEssay(essayid);
        System.out.println("评论");
        model.addAttribute("list",list);
        model.addAttribute("userId",userid);
        return "forward:/essaydetail.jsp";
    }
}
