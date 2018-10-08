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
	 * ��ѯȫ������
	 */
	public List<Essay> selectEssay(){
		List<Essay> list=essayMapper.selectessay();
		return list;
	}
	/**
	 * �������ѯ
	 */
	public List<HashMap<String,Object>> insertEssay(Essay essay){
		//����
		int row=essayMapper.insertEassy(essay);
		//��շ������ӵ�ID
		String essayid=essayMapper.selectEssayId(essay.getEssayuserid(),essay.getEssayname());
		//����շ���������ʾ����ҳ��
		List<HashMap<String,Object>> list=essayMapper.selectOneEssay(essayid);
		return list;
	}
	/**
	 * ͨ��essayid��ѯ��������
	 */

	public List<HashMap<String,Object>> selectOneEssay(String essayId){
		List<HashMap<String,Object>> list=essayMapper.selectOneEssay(essayId);
		return list;
	}
	//  <!--��ѯ���Ӱ��յ�����-->
	@Override
	public List<Essay> selectEssayClick() {
		return essayMapper.selectEssayClick();
	}
	// <!--��ѯ���Ӱ��շ���ʱ��-->
	public List<Essay> selectEssayData() {
		return essayMapper.selectEssayData();
	}

	@Override
	public List<HashMap<String, Object>> selectCate(String eid) {
		return essayMapper.selectCate(eid);
	}
	//     <!--���µ����-->
	@Override
	public int updateClick(String essayid) {
		return essayMapper.updateClick(essayid);
	}
	//ģ����������
	@Override
	public List<HashMap<String, Object>> selectFuzzy(String essayname) {
		return essayMapper.selectFuzzy(essayname);
	}
}
