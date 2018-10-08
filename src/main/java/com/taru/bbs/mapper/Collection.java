package com.taru.bbs.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface Collection {
    public int insertCol(@Param("essayid") String essayid,@Param("userid") String userid );
//        <!--根据用户ID查收藏-->
    public List<HashMap<String,Object>> selectCol(@Param("userid")String userid);
    //        <!--根据用户ID,贴子id查收藏-->
    public List<HashMap<String, Object>> selectOneCol(@Param("essayid")String essayid,@Param("userid") String userid );
}
