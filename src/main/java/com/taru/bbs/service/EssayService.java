package com.taru.bbs.service;

import com.taru.bbs.pojo.Essay;
import com.taru.bbs.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface EssayService {
    /**
     * ��ѯȫ������
     */
    public List<Essay> selectEssay();
    /**
     * �������ѯ
     */
    public List<HashMap<String,Object>> insertEssay(Essay essay);
    /**
     * ͨ��essayid��ѯ��������
     */
    public List<HashMap<String,Object>> selectOneEssay(String essayId);
    //  <!--��ѯ���Ӱ��յ�����-->
    public List<Essay> selectEssayClick();
    // <!--��ѯ���Ӱ��շ���ʱ��-->
    public List<Essay> selectEssayData();
    //<!--��ѯ���Ӱ������-->
    public List<HashMap<String,Object>> selectCate (String eid);
    //     <!--���µ����-->
    public int updateClick(String essayid);
    //ģ����������
    public List<HashMap<String,Object>> selectFuzzy(String essayname);
}
