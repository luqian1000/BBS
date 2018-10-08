package com.taru.bbs.service.impl;

import java.util.HashMap;
import java.util.List;

import com.taru.bbs.dao.EssayDao;
import com.taru.bbs.dao.impl.EssayDaoImpl;
import com.taru.bbs.mapper.EssayMapper;
import com.taru.bbs.mapper.UserMapper;
import com.taru.bbs.pojo.Essay;
import com.taru.bbs.pojo.User;
import com.taru.bbs.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EssayServiceImpl implements EssayService {
//	@Resource(name = "essayDaoImpl")
//	EssayDao essayimp;
	@Autowired
    EssayMapper essayMapper;
	/**
	 * 查询全部贴子
	 */
	public List<Essay> selectEssay(){
		List<Essay> list=essayMapper.selectessay();
		return list;
	}
	/**
	 * 发帖后查询
	 */
	public List<HashMap<String,Object>> insertEssay(Essay essay){
		//发帖
		int row=essayMapper.insertEassy(essay);
		//查刚发的贴子的ID
		String essayid=essayMapper.selectEssayId(essay.getEssayuserid(),essay.getEssayname());
		//查出刚发的贴子显示在网页上
		List<HashMap<String,Object>> list=essayMapper.selectOneEssay(essayid);
		return list;
	}
	/**
	 * 通过essayid查询贴子详情
	 */

	public List<HashMap<String,Object>> selectOneEssay(String essayId){
		List<HashMap<String,Object>> list=essayMapper.selectOneEssay(essayId);
		return list;
	}
	//  <!--查询贴子按照点赞量-->
	@Override
	public List<Essay> selectEssayClick() {
		return essayMapper.selectEssayClick();
	}
	// <!--查询贴子按照发布时间-->
	public List<Essay> selectEssayData() {
		return essayMapper.selectEssayData();
	}

	@Override
	public List<HashMap<String, Object>> selectCate(String eid) {
		return essayMapper.selectCate(eid);
	}
	//     <!--更新点击量-->
	@Override
	public int updateClick(String essayid) {
		return essayMapper.updateClick(essayid);
	}
	//模糊搜索贴子
	@Override
	public List<HashMap<String, Object>> selectFuzzy(String essayname) {
		return essayMapper.selectFuzzy(essayname);
	}
}
