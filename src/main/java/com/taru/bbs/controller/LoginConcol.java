package com.taru.bbs.controller;

import com.taru.bbs.common.JsonResult;
import com.taru.bbs.exception.CustomException;
import com.taru.bbs.pojo.User;
import com.taru.bbs.service.UserService;
import com.taru.bbs.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginConcol {
/**
登录
 */
    @Autowired//  ==  @Resource(name="userServiceImpl")
    UserService service;
    @RequestMapping(value = "/control/login/in")
    public String login(@RequestParam(value = "username",required = true,defaultValue = "") String username,
                        //在Control之间存取要用到的类RedirectAttributes
                        @RequestParam(value="password",required = true,defaultValue = "") String password,HttpServletRequest request, Model model) {
        //打印日志
        Logger logger= LoggerFactory.getLogger(LoginConcol.class);
        //取session没有就为空
        HttpSession session=request.getSession(false);
        User user =new User();
        user=service.login(username, password);
        if(user!=null){
            //System.out.println("测试登录");
            logger.info("测试登录");
            //往session域存一份userId
            session.setAttribute("userId",user.getId());
            session.setAttribute("userName",user.getUsername());
            session.setAttribute("userPhoto",user.getPhoto());
            //存userid，下个Control可以调用，在下个Control方法的形参里直接声明调用
            model.addAttribute("userId",user.getId());
            //重定向的下个controller
            return "redirect:/control/select/cd";
        }else{
            model.addAttribute("LoginError","用户名或密码错误");
            //请求转发到jsp页面
            return "forward:/login.jsp";
        }
    }
    @RequestMapping(value = "/control/login/out")
    public String loginout(HttpSession session){
        session.invalidate();//销毁session
        return "forward:/login.jsp";
    }
    @RequestMapping(value = "/test/select",method = RequestMethod.GET)
    @ResponseBody
    public Object select (){
        JsonResult result;
        try{
            List<User> users=service.select();
            result =new JsonResult("查询成功","200",users);
        }catch(Exception e){
            result =new JsonResult("查询失败","500");
        }
        return result;
    }
}
