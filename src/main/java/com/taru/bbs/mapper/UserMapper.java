package com.taru.bbs.mapper;

import com.taru.bbs.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserMapper {
    //登录
    //uname,pword相当于UserMapper.xml里的sql语句...where user_name=#｛uname｝中占位符的变量名，
    // 这个名字随便取但要和 UserMapper.xml中#｛uname｝相同，后面String 也是随便取的这里要添加Param的原因是底层mybatis要调用sql查询语句实现查询数据库，
    // 以前SQLHelper我们能传sql语句与给占位符赋的值的变量名 即SqlHelper.select(sql,username,password)可以传多个值，但是集成之后底层的SQLHelper
    // 只能传两个值，sqlSession.selectOne("com.taru.bbs.dao.UserDao.select3",user1)一个参数 是对应的sql语句，一个是给占位符赋的值
    // 这里占位符只允许赋一个，要么传对象要么一个变量，所以当我们传两个时要么实体对象要么用@Param;
    public User login(@Param("uname") String username, @Param("pword") String password) ;
    //注册
    public int register(User user);
    // 根据用户给的id查询用户
    public User selectUser(String userid);
//<!--更新用户通过user_id-->
    public int updateUser (User user);

    //测试
    public List<User> select();
    public User selectByIdWithessay(String Id);
    //测试 根据用户的姓名进行模糊查询，用Mybatis bind
    public List<User> selectFuzzyUser(@Param("username") String uname);
    //测试 根据用户给的id查询（数组参数）用户集合
    public List<User> selectUser1(List<String> ids);
    //测试 查询用户输入排序方式or（asc desc）
    public List<User> selectOrder(@Param("ordere") String ordere);


}
