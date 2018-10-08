package com.taru.bbs.mapper;

import com.taru.bbs.pojo.Essay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface EssayMapper {
    /**
     * 查询全部贴子
     * 这个接口与Essaymapper.xml里的sql语句对应的id相同，相当于在essaymapper.xml实现sql语句
     */
    public List<Essay> selectessay();
    /**
     * 	 通过EssayID查询贴子详情
     * 这个接口与Essaymapper.xml里的sql语句对应的id相同，相当于在essaymapper.xml实现sql语句
     */
    public List<HashMap<String,Object>> selectOneEssay(String essayId);
    /**
     * 发帖
     *
     * 这个接口与Essaymapper.xml里的sql语句对应的id相同，相当于在essaymapper.xml实现sql语句
     */
    public int insertEassy(Essay essay);
    //    通过用户Id查询该用户发表的贴子
    public String selectEssayId(@Param("esaayuserid") String userid, @Param("essayname") String essayname);
//  <!--查询贴子按照点赞量-->
    public List<Essay> selectEssayClick();
    // <!--查询贴子按照发布时间-->
    public List<Essay> selectEssayData();
    //<!--查询贴子按照类别-->
    public List<HashMap<String,Object>> selectCate (String eid);
  //     <!--更新点击量-->

    public int updateClick(String essayid);
    //模糊搜索贴子
    public List<HashMap<String,Object>> selectFuzzy(String essayname);
}
