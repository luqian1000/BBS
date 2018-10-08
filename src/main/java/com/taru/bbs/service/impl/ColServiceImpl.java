package com.taru.bbs.service.impl;

import com.taru.bbs.mapper.Collection;
import com.taru.bbs.service.ColService;
import com.taru.bbs.spring.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ColServiceImpl implements ColService {
    @Autowired
    Collection col;
    @Override
    public int insertCol(String essayid, String userid) {
        return col.insertCol(essayid,userid) ;
    }

    @Override
    public List<HashMap<String, Object>> selectCol(String userid) {
        return col.selectCol(userid);
    }

    @Override
    public List<HashMap<String,Object>> selectOneCol(String essayid, String userid) {
        return col.selectOneCol(essayid,userid);
    }
}
