package com.taru.bbs.dao;

import com.taru.bbs.pojo.Essay;

import java.util.HashMap;
import java.util.List;

public interface EssayDao  {
    public List<HashMap<String, Object>> selectessay();
    public List<HashMap<String,Object>> selectOneEssay(String essayId);
    public int insertEassy(Essay essay);
    public String selectEssayId(String userid, String essayname);
}
