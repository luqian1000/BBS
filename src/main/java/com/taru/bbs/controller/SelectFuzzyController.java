package com.taru.bbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
public class SelectFuzzyController {
    @Autowired
    EssayService essayService;
    @RequestMapping(value = "/control/select/fuzzy")
    public String selectFuzzy(String essayname,@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum,  Model model){
//       ȥ��ģ�������������ֶ��д��ڵĿո�
       String str= essayname.replaceAll(" ", "");
//        ��ҳ
        PageHelper.startPage(pagenum,10);
        List<HashMap<String,Object>> list=essayService.selectFuzzy(str);
//        ԭ���Ѿ���list����ֻ��Ҫ����list�е�һ�� ����������;�����
        PageInfo<HashMap<String,Object>> pageInfo=new PageInfo<>(list);
        Integer flag=1;
        //�����ж��Ƿ�����������ģ������
        model.addAttribute("flag",flag);
//        ����ģ�������ֶη�ҳʱ�ٴ������ٴ�����
        model.addAttribute("essayname",essayname);
        model.addAttribute("list",pageInfo);
        return "forward:/article_list.jsp";
    }
}
