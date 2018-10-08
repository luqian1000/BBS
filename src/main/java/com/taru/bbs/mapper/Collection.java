package com.taru.bbs.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface Collection {
    public int insertCol(@Param("essayid") String essayid,@Param("userid") String userid );
//        <!--�����û�ID���ղ�-->
    public List<HashMap<String,Object>> selectCol(@Param("userid")String userid);
    //        <!--�����û�ID,����id���ղ�-->
    public List<HashMap<String, Object>> selectOneCol(@Param("essayid")String essayid,@Param("userid") String userid );
}
