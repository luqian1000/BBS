package com.taru.bbs.spring;

import com.taru.bbs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class TestSelect {
    public static void main(String[] args) throws IOException {
        String resource="mybatis.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
//SqlSessionFactory 专门生产SQLSession 一次连接数据库的过程
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();//建立连接
//        User user1=new User();
//        user1.setUsername("ea");
//        user1.setPassword("546");
//        User user =sqlSession.selectOne("com.taru.bbs.dao.UserDao.select3",user1);//UserMapper里的select
//        System.out.println(user.getId());
       List<HashMap> list =sqlSession.selectList("com.taru.bbs.dao.UserDao.select4");//UserMapper里的select

        System.out.println(list.size());
        for (HashMap map:list){
            System.out.println(map.get("username"));
        }
        sqlSession.close();
    }
}
