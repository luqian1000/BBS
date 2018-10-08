package com.taru.bbs.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taru.bbs.common.JsonResult;
import com.taru.bbs.service.ColService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class SelectColApi {
    @Autowired
    ColService cole;
    @RequestMapping(value = "/control/select/col")
    public String selectCol(String userid, Model model,@RequestParam(value = "pagenum",defaultValue = "1") Integer pagenum){
        PageHelper.startPage(pagenum,10);
        List<HashMap<String,Object>> list=cole.selectCol(userid);
        PageInfo<HashMap<String,Object>> pageInfo=new PageInfo<>(list,10);
        Integer flag=3;
        model.addAttribute("flag",flag);
        model.addAttribute("list",pageInfo);
        return "forward:/article_list.jsp";
    }
}
