package com.taru.bbs.dao;

public interface CommentDao {
    public int commentInsert(String fatherid, String userid, String text, String essayid);
}
