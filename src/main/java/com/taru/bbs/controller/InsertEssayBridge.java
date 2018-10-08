package com.taru.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InsertEssayBridge {
    @RequestMapping(value = "/control/api/insertbridge")
        public String  insertEsssayBridge(){
        return "insertessay";
    }
}
