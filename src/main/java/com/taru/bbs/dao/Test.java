package com.taru.bbs.dao;

import com.taru.bbs.dao.impl.EssayDaoImpl;

public class Test {

    public static void main(String []as){
        EssayDaoImpl essayDao=new EssayDaoImpl();
        System.out.println(essayDao.selectessay());
    }

}
