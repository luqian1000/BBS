package com.taru.bbs.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAspectj {
    private  static Logger logger= LoggerFactory.getLogger(LogAspectj.class);
    public void beforeMethod(){
        logger.info("��ʼ�ķ���");
    }
    public void afterMethod(){
        logger.info("�����ķ���");
    }
}
