package com.taru.bbs.dao.impl;

import com.taru.bbs.dao.UserDao;
import com.taru.bbs.pojo.User;
import com.taru.bbs.util.SqlHelper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User loginselect(String username, String password) {
        User user=null;
        String sql="select *from user where user_name=? and user_password=?";
        List<HashMap<String ,Object>> list= SqlHelper.select(sql,username,password);
        System.out.println("登录");
        if(list.size()>0) {
//			HashMap<String,Object> map=list.get(0);
//			user =new User();
//			user.setId(map.get("USER_ID")==null?null:map.get("USER_ID").toString());
//			user.setUsername(map.get("USER_USER_NAME")==null?null:map.get("USER_USER_NAME").toString());
//			user.setPassword(map.get("USER_PASSWORD")==null?null:map.get("USER_PASSWORD").toString());
//			user.setTelphone(map.get("USER_TELPHONE")==null?null:map.get("USER_TELPHONE").toString());
//			user.setAddress(map.get("USER_ADDRESS")==null?null:map.get("USER_ADDRESS").toString());
//			user.setShopname(map.get("USER_SHOP_NAME")==null?null:map.get("USER_SHOP_NAME").toString());
            HashMap<String ,Object> map=list.get(0);
            user =new User();
            //这个地方get的数据库参数名不是USER_ID这种是因为SQLHelper里面转了 把参数转成了驼峰命名的方式
            //这个地方get的数据库参数名不是USER_ID这种是因为SQLHelper里面转了 把参数转成了驼峰命名的方式
            //这个地方get的数据库参数名不是USER_ID这种是因为SQLHelper里面转了 把参数转成了驼峰命名的方式
            user.setId(map.get("userId")==null?null:map.get("userId").toString());
            user.setUsername(map.get("userName")==null?null:map.get("userName").toString());
            user.setPassword(map.get("userPassword")==null?null:map.get("userPassword").toString());
            user.setTelphone(map.get("userTelphone")==null?null:map.get("userTelphone").toString());
        }
        return user;

    }
    /*
     * 用户注册
     */
    public List<HashMap<String ,Object>> registerSql(User user) {
        String sql="insert into user (USER_ID,USER_NAME,USER_PASSWORD,USER_PHOTO,USER_TELPHONE) values (uuid(),?,?,?,?)";
        int row=SqlHelper.update(sql, user.getUsername(),user.getPassword(),user.getPhoto(),user.getTelphone());
        String sql1="select *from user where USER_NAME=?";
        List<HashMap<String ,Object>> list =SqlHelper.select(sql1,user.getUsername());
        return list;
    }

    @Override
    public User login() {
        return null;
    }

}
