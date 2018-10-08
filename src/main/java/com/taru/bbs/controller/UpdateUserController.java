package com.taru.bbs.controller;

import com.taru.bbs.pojo.User;
import com.taru.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UpdateUserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/control/update/user")
    public String updateUser(User user1, Model model ,HttpServletRequest request){
       int row= userService.updateUser(user1);
        User user=new User();
       user=userService.selectUser(user1.getId());
        HttpSession session =request.getSession(false);
//        ÖØÐÂ´æsession
        session.setAttribute("userPhoto",user.getPhoto());
       model.addAttribute("user",user);
       return "forward:/userdetail.jsp";
    }
}
