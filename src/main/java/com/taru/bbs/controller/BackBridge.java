package com.taru.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BackBridge {
    @RequestMapping(value = "/control/back")
    //����ȫ�����ӵ�����ҳ��
    public String back(String userId, Model model){
        //��userId����SelectAllControl��
        model.addAttribute("userId",userId);
        return "redirect:/contorl/select/essay";

    }
}
