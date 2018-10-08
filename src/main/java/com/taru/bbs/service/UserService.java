package com.taru.bbs.service;

import com.taru.bbs.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);
    /**
     * 注册
     * @param user
     * @return
     */
    public int insertregiter(User user);
    // 根据用户给的id查询用户
    public User selectUser(String userid);
    //<!--更新用户通过user_id-->
    public int updateUser (User user);
//测试
    public List<User> select();
    //测试 根据用户的姓名进行模糊查询，用Mybatis bind
    public List<User> selectFuzzyUser(String username);


//    //测试 根据用户给的id查询（数组参数）用户集合
    public List<User> selectUser1(List<String> ids);
    //测试 查询用户输入排序方式or（asc desc）
    public List<User> selectOrder(String order);

}
