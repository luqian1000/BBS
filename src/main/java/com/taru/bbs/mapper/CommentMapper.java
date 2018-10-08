package com.taru.bbs.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper{
    public int commentInsert(@Param("fatherid") String fatherid, @Param("userid") String userid, @Param("text") String text, @Param("essayid") String essayid);
}