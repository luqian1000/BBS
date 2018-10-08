package com.taru.bbs.controller;

import com.taru.bbs.mapper.EssayMapper;
import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class UpdateClickContorller {
    @Autowired
    EssayService essayService;
    @RequestMapping(value = "/control/update/click")
    //查询某个贴子，查询之前先更新浏览量
    public String updateClick(String essayId, String userId,Model model){
        int row=essayService.updateClick(essayId);
        model.addAttribute("essayId",essayId);
        model.addAttribute("userId",userId);
        return "forward:/control/SelectOne";
    }
}
