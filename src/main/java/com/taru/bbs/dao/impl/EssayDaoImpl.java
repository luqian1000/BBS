package com.taru.bbs.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.taru.bbs.dao.EssayDao;
import com.taru.bbs.pojo.Essay;
import com.taru.bbs.util.SqlHelper;
import org.springframework.stereotype.Repository;


@Repository
public class EssayDaoImpl implements EssayDao {
	/**
	 * �鿴����ȫ������
	 */
	public List<HashMap<String, Object>> selectessay() {
		String sql="select *from essay left join user on essay_user_id=user_id where essay_status=1";
		List<HashMap<String,Object>> list=SqlHelper.select(sql);
		return list;
	}
	/**
	 * ͨ��EssayID��ѯ��������
	 * ��ҳ
	 */
	public List<HashMap<String,Object>> selectOneEssay(String essayId ) {
		String sql="select e.*,u.*,c.*,s.user_name comment_user_name,s.user_id comment_user_id,s.user_photo comment_user_photo from essay e left join user u on e.essay_user_id=u.user_id left join comment c on e.essay_id=c.comment_essay_id left join user s on s.user_id=c.comment_user_id where essay_id=?";
		List<HashMap<String,Object>> list=SqlHelper.select(sql,essayId);
		return list;
	}
	/**
	 * ����
	 */
	public int insertEassy(Essay essay) {
		String sql="insert into essay values (uuid(),?,?,?,NOW(),1)";
		int row=SqlHelper.update(sql, essay.getEssayname(),essay.getEssayuserid(),essay.getEssaytext());
		return row;
	}
	/**
	 * ������������ �û�ID������շ������ӵ�id
	 */
	public String selectEssayId(String userid,String essayname ) {
		String sql="select essay_id from essay where essay_user_id=? and essay_data_time in (select max(essay_data_time) from essay  where essay_user_id=? and essay_name =?) ";
		List<HashMap<String,Object>> list=SqlHelper.select(sql,userid,userid,essayname);
		//ȡ��ID
		String essayid=list.get(0).get("essayId").toString();
		return essayid;
	}
}
