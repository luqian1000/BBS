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
��¼
 */
    @Autowired//  ==  @Resource(name="userServiceImpl")
    UserService service;
    @RequestMapping(value = "/control/login/in")
    public String login(@RequestParam(value = "username",required = true,defaultValue = "") String username,
                        //��Control֮���ȡҪ�õ�����RedirectAttributes
                        @RequestParam(value="password",required = true,defaultValue = "") String password,HttpServletRequest request, Model model) {
        //��ӡ��־
        Logger logger= LoggerFactory.getLogger(LoginConcol.class);
        //ȡsessionû�о�Ϊ��
        HttpSession session=request.getSession(false);
        User user =new User();
        user=service.login(username, password);
        if(user!=null){
            //System.out.println("���Ե�¼");
            logger.info("���Ե�¼");
            //��session���һ��userId
            session.setAttribute("userId",user.getId());
            session.setAttribute("userName",user.getUsername());
            session.setAttribute("userPhoto",user.getPhoto());
            //��userid���¸�Control���Ե��ã����¸�Control�������β���ֱ����������
            model.addAttribute("userId",user.getId());
            //�ض�����¸�controller
            return "redirect:/control/select/cd";
        }else{
            model.addAttribute("LoginError","�û������������");
            //����ת����jspҳ��
            return "forward:/login.jsp";
        }
    }
    @RequestMapping(value = "/control/login/out")
    public String loginout(HttpSession session){
        session.invalidate();//����session
        return "forward:/login.jsp";
    }
    @RequestMapping(value = "/test/select",method = RequestMethod.GET)
    @ResponseBody
    public Object select (){
        JsonResult result;
        try{
            List<User> users=service.select();
            result =new JsonResult("��ѯ�ɹ�","200",users);
        }catch(Exception e){
            result =new JsonResult("��ѯʧ��","500");
        }
        return result;
    }
}
