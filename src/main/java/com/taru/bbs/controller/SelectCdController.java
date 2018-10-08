package com.taru.bbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taru.bbs.pojo.Essay;
import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SelectCdController {
    @Autowired
    EssayService service;

    @RequestMapping(value = "/control/select/cd",method = RequestMethod.GET)
    public String selectCD( Model model){
        //��ʼ��ҳ����ҳ����ÿҳ��ʾ����
        PageHelper.startPage(1,5);
        //����������
        List<Essay> list= service.selectEssayClick();
        PageInfo<Essay> pageInfo=new PageInfo<>(list,5);

        PageHelper.startPage(1,5);
        //��ʱ��˳����
        List<Essay> list1= service.selectEssayData();
        PageInfo<Essay> pageInfo1=new PageInfo<>(list1,5);
        //����������list
        model.addAttribute("list1",pageInfo);
        //��ʱ��˳����list1
        model.addAttribute("list2",pageInfo1);
        return "forward:/index.jsp";
    }

}
