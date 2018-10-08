package com.taru.bbs.service.impl;

import com.taru.bbs.dao.UserDao;
import com.taru.bbs.dao.impl.UserDaoImpl;
import com.taru.bbs.mapper.UserMapper;
import com.taru.bbs.pojo.User;
import com.taru.bbs.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    /*@Resource(name = "userDaoImpl")*/
//    @Autowired
//    UserDao userDao;
    @Autowired
    UserMapper userMapper;
    /**
     * ��¼
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login( String username, String password) {
        User user=new User();
        user= userMapper.login(username,password);
        return user;
    }
    /**
     * ע��
     * @param user
     * @return
     */
    @Override
    public int insertregiter(User user) {
        int list=userMapper.register(user);
        return list;
    }
//��ѯ�����û�
    @Override
    public User selectUser(String userid) {
        return userMapper.selectUser(userid);
    }
    //<!--�����û�ͨ��user_id-->
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> select() {
        return userMapper.select();
    }
    //���� �����û�����������ģ����ѯ����Mybatis bind
    @Override
    public List<User> selectFuzzyUser(String username) {
        return userMapper.selectFuzzyUser(username);
    }

    @Override
    public List<User> selectUser1(List<String> ids) {
        return userMapper.selectUser1(ids);
    }

    @Override
    public List<User> selectOrder(String or) {
        return userMapper.selectOrder(or);
    }


}
