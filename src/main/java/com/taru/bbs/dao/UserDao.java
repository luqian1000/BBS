package com.taru.bbs.dao;

import com.taru.bbs.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    //��¼
    public User loginselect(String username, String password) ;
    //ע��
    public List<HashMap<String ,Object>> registerSql(User user);
    public User login();
}
