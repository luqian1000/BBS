package com.taru.bbs.spring;

import org.springframework.stereotype.Component;

@Component(value = "A3")
public class A3 extends Paper {
    @Override
    public void writer() {
        System.out.println("����ʹ��A3ֽ��");
    }
}
