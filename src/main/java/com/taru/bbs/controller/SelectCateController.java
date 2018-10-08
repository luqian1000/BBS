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
public class SelectCateController {
    @Autowired
    EssayService essayService;
    @RequestMapping(value = "/control/select/cate")
    public String selectCategory(@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum, String eid, Model model){
        PageHelper.startPage(pagenum,10);
        List<HashMap<String,Object>> list= essayService.selectCate(eid);
        PageInfo<HashMap<String,Object>> pageInfo=new PageInfo<>(list,10);
        Integer flag=0;
        //用于判断是分类搜索还是模糊搜索
        model.addAttribute("flag",flag);
       model.addAttribute("list",pageInfo);
      return "forward:/article_list.jsp";
    }
}
