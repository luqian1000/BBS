package com.taru.bbs.aspectj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAspectj {
    private  static Logger logger= LoggerFactory.getLogger(LogAspectj.class);
    public void beforeMethod(){
        logger.info("开始的方法");
    }
    public void afterMethod(){
        logger.info("结束的方法");
    }
}
