package com.taru.bbs.spring;

import com.taru.bbs.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class TestInsert {
    public static void main(String[] args) throws IOException {
        String resource="mybatis.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
//SqlSessionFactory 专门生产SQLSession 一次连接数据库的过程
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();//建立连接
        User user1=new User();
        user1.setUsername("测试");
        user1.setPassword("56");
        user1.setId(UUID.randomUUID().toString());
        user1.setPhoto("ind.jpg");
        int row =sqlSession.insert("com.taru.bbs.dao.UserDao.insert",user1);//UserMapper里的select
        //System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

}
