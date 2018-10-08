package com.taru.bbs.dao.impl;

import com.taru.bbs.dao.CommentDao;
import com.taru.bbs.util.SqlHelper;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao {
	/**
	 * ∑¢±Ì∆¿¬€
	 */
	public int commentInsert(String fatherid,String userid,String text,String essayid) {
		String sql="insert INTO comment values(UUID(),?,?,?,?,1,now())";
		int row =SqlHelper.update(sql,fatherid,userid,text,essayid);
		return row;
	}
	
}
