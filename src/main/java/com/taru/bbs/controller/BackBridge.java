package com.taru.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BackBridge {
    @RequestMapping(value = "/control/back")
    //返回全部贴子的桥梁页面
    public String back(String userId, Model model){
        //存userId传给SelectAllControl类
        model.addAttribute("userId",userId);
        return "redirect:/contorl/select/essay";

    }
}
