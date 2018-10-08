package com.taru.bbs.service.impl;

import com.taru.bbs.dao.CommentDao;
import com.taru.bbs.dao.impl.CommentDaoImpl;
import com.taru.bbs.mapper.CommentMapper;
import com.taru.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper comment;
	/**
	 * ≤Â»Î∆¿¬€
	 * @param text
	 * @param userid
	 * @param essayid
	 * @return
	 */
	public int insertComment(String fatherid,String userid,String text,String essayid) {
		int row=comment.commentInsert(fatherid, userid,text,essayid);
		return row;		
	}
}
