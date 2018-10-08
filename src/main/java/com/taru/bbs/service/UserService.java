package com.taru.bbs.service;

import com.taru.bbs.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    /**
     * ��¼
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);
    /**
     * ע��
     * @param user
     * @return
     */
    public int insertregiter(User user);
    // �����û�����id��ѯ�û�
    public User selectUser(String userid);
    //<!--�����û�ͨ��user_id-->
    public int updateUser (User user);
//����
    public List<User> select();
    //���� �����û�����������ģ����ѯ����Mybatis bind
    public List<User> selectFuzzyUser(String username);


//    //���� �����û�����id��ѯ������������û�����
    public List<User> selectUser1(List<String> ids);
    //���� ��ѯ�û���������ʽor��asc desc��
    public List<User> selectOrder(String order);

}
