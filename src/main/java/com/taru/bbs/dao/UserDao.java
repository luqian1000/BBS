package com.taru.bbs.dao;

import com.taru.bbs.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    //µÇÂ¼
    public User loginselect(String username, String password) ;
    //×¢²á
    public List<HashMap<String ,Object>> registerSql(User user);
    public User login();
}
