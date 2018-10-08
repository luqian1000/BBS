package com.taru.bbs.mapper;

import com.taru.bbs.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserMapper {
    //��¼
    //uname,pword�൱��UserMapper.xml���sql���...where user_name=#��uname����ռλ���ı�������
    // ����������ȡ��Ҫ�� UserMapper.xml��#��uname����ͬ������String Ҳ�����ȡ������Ҫ���Param��ԭ���ǵײ�mybatisҪ����sql��ѯ���ʵ�ֲ�ѯ���ݿ⣬
    // ��ǰSQLHelper�����ܴ�sql������ռλ������ֵ�ı����� ��SqlHelper.select(sql,username,password)���Դ����ֵ�����Ǽ���֮��ײ��SQLHelper
    // ֻ�ܴ�����ֵ��sqlSession.selectOne("com.taru.bbs.dao.UserDao.select3",user1)һ������ �Ƕ�Ӧ��sql��䣬һ���Ǹ�ռλ������ֵ
    // ����ռλ��ֻ����һ����Ҫô������Ҫôһ�����������Ե����Ǵ�����ʱҪôʵ�����Ҫô��@Param;
    public User login(@Param("uname") String username, @Param("pword") String password) ;
    //ע��
    public int register(User user);
    // �����û�����id��ѯ�û�
    public User selectUser(String userid);
//<!--�����û�ͨ��user_id-->
    public int updateUser (User user);

    //����
    public List<User> select();
    public User selectByIdWithessay(String Id);
    //���� �����û�����������ģ����ѯ����Mybatis bind
    public List<User> selectFuzzyUser(@Param("username") String uname);
    //���� �����û�����id��ѯ������������û�����
    public List<User> selectUser1(List<String> ids);
    //���� ��ѯ�û���������ʽor��asc desc��
    public List<User> selectOrder(@Param("ordere") String ordere);


}
