package com.taru.bbs.service;

import java.util.HashMap;
import java.util.List;

public interface ColService {
    public int insertCol(String essayid,String userid );
    //        <!--根据用户ID查收藏-->
    public List<HashMap<String,Object>> selectCol(String userid);
    //        <!--根据用户ID,贴子id查收藏-->
    public List<HashMap<String,Object>> selectOneCol(String essayid,String userid );
}
