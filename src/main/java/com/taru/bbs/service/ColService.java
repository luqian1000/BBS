package com.taru.bbs.service;

import java.util.HashMap;
import java.util.List;

public interface ColService {
    public int insertCol(String essayid,String userid );
    //        <!--�����û�ID���ղ�-->
    public List<HashMap<String,Object>> selectCol(String userid);
    //        <!--�����û�ID,����id���ղ�-->
    public List<HashMap<String,Object>> selectOneCol(String essayid,String userid );
}
