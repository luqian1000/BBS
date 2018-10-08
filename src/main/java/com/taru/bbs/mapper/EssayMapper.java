package com.taru.bbs.mapper;

import com.taru.bbs.pojo.Essay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface EssayMapper {
    /**
     * ��ѯȫ������
     * ����ӿ���Essaymapper.xml���sql����Ӧ��id��ͬ���൱����essaymapper.xmlʵ��sql���
     */
    public List<Essay> selectessay();
    /**
     * 	 ͨ��EssayID��ѯ��������
     * ����ӿ���Essaymapper.xml���sql����Ӧ��id��ͬ���൱����essaymapper.xmlʵ��sql���
     */
    public List<HashMap<String,Object>> selectOneEssay(String essayId);
    /**
     * ����
     *
     * ����ӿ���Essaymapper.xml���sql����Ӧ��id��ͬ���൱����essaymapper.xmlʵ��sql���
     */
    public int insertEassy(Essay essay);
    //    ͨ���û�Id��ѯ���û����������
    public String selectEssayId(@Param("esaayuserid") String userid, @Param("essayname") String essayname);
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
