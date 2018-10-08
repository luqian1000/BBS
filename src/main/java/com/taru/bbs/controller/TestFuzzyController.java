package com.taru.bbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taru.bbs.common.JsonResult;
import com.taru.bbs.pojo.User;
import com.taru.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestFuzzyController {
    @Autowired
    UserService userService;
    //根据用户名进行模糊查询
    @ResponseBody
    @RequestMapping(value = "/test/fuzzy")
    public Object selectFuzzyUser(String username){
        List<User> users=userService.selectFuzzyUser(username);
        //System.out.println(users.get(0).getUsername());
        JsonResult result=null;
        try{
            result=new JsonResult("成功","200",users);
        }catch (Exception e){
            result=new JsonResult("失败","500");
        }
        return result;
    }
    //
    @ResponseBody
    @RequestMapping(value = "/test/selectuser")
    public Object selectUser1(List<String> ids){
        List<User> users=userService.selectUser1(ids);
        System.out.println("user");
        System.out.println(users.get(0).getUsername());
        JsonResult result=null;
        try{
            result=new JsonResult("成功","200",users);
        }catch (Exception e){
            result=new JsonResult("失败","500");
        }
        return result;
    }
    //查询用户输入desc 降序asc升序 并分页
    @ResponseBody
    @RequestMapping(value = "/test/selectorder")
    public Object selectUser1(String or,Integer pagenum,Integer pagesize){
        System.out.println("user");
        //分页
        PageHelper.startPage(pagenum,pagesize);
        List<User> users=userService.selectOrder(or);
        PageInfo<User> pageInfo=new PageInfo<>(users,pagesize);
        System.out.println(users.get(0).getUsername());
        JsonResult result=null;
        try{
            result=new JsonResult("成功","200",pageInfo);
        }catch (Exception e){
            result=new JsonResult("失败","500");
        }
        return result;
    }
}
