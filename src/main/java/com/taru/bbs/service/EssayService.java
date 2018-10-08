package com.taru.bbs.service;

import com.taru.bbs.pojo.Essay;
import com.taru.bbs.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface EssayService {
    /**
     * 查询全部贴子
     */
    public List<Essay> selectEssay();
    /**
     * 发帖后查询
     */
    public List<HashMap<String,Object>> insertEssay(Essay essay);
    /**
     * 通过essayid查询贴子详情
     */
    public List<HashMap<String,Object>> selectOneEssay(String essayId);
    //  <!--查询贴子按照点赞量-->
    public List<Essay> selectEssayClick();
    // <!--查询贴子按照发布时间-->
    public List<Essay> selectEssayData();
    //<!--查询贴子按照类别-->
    public List<HashMap<String,Object>> selectCate (String eid);
    //     <!--更新点击量-->
    public int updateClick(String essayid);
    //模糊搜索贴子
    public List<HashMap<String,Object>> selectFuzzy(String essayname);
}
