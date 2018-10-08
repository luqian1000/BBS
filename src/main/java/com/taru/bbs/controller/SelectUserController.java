package com.taru.bbs.controller;

import com.taru.bbs.pojo.User;
import com.taru.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SelectUserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/control/select/user")
    public String selectUser(@RequestParam(value = "userid",required = true,defaultValue = "") String userid, HttpServletRequest request, Model model ){
        User user=new User();
        user= userService.selectUser(userid);
        model.addAttribute("user",user);
        return  "forward:/userdetail.jsp";
    }
}
