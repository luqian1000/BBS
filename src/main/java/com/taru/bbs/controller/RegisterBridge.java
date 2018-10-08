package com.taru.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterBridge {
    //µÇÂ¼Ìø×ª
    @RequestMapping(value = "/control/register/bridge")
    public String registerBridge(){
        return "forward:/register.jsp";
    }
 }
