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
//       去掉模糊搜索传来的字段中存在的空格
       String str= essayname.replaceAll(" ", "");
//        分页
        PageHelper.startPage(pagenum,10);
        List<HashMap<String,Object>> list=essayService.selectFuzzy(str);
//        原本已经是list这里只需要填上list中的一组 对象里的类型就行了
        PageInfo<HashMap<String,Object>> pageInfo=new PageInfo<>(list);
        Integer flag=1;
        //用于判断是分类搜索还是模糊搜索
        model.addAttribute("flag",flag);
//        存下模糊搜索字段分页时再次请求再传回来
        model.addAttribute("essayname",essayname);
        model.addAttribute("list",pageInfo);
        return "forward:/article_list.jsp";
    }
}
