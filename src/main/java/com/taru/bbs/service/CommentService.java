package com.taru.bbs.service;

public interface CommentService {
    /**
     * ��������
     * @param text
     * @param userid
     * @param essayid
     * @return
     */
    public int insertComment(String fatherid, String userid, String text, String essayid);
}
