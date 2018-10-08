package com.taru.bbs.controller;

import com.taru.bbs.pojo.User;
import com.taru.bbs.service.UserService;
import com.taru.bbs.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegisterContorller {
    /**
     * ×¢²á
     */
    @Autowired
    UserService userService;
    @RequestMapping(value = "/control/user/register")
    public String register(User user){
        int list=userService.insertregiter(user);
       // model.addAttribute("list",list);
        return "forward:/login.jsp";
    }
    /**
     * AjaxÇëÇó°æ
     */

//    @ResponseBody
//    public JsonResult register(User user){
//        UserServiceImpl userService=new UserServiceImpl();
//        List<HashMap<String,Object>> list=userService.regiter(user);
//        JsonResult result=null;
//        try{
//            if (list.size()>0){
//                result=new JsonResult("×¢²á³É¹¦","200",list);
//            }else{
//                result=new JsonResult("×¢²áÊ§°Ü","404",list);
//            }
//        }catch( Exception e){
//            result=new JsonResult("×¢²áÒì³£","500",list);
//        }
//        return result;
//    }

}
