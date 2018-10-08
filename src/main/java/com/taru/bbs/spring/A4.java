package com.taru.bbs.spring;

import org.springframework.stereotype.Component;

@Component(value = "A4")
public class A4 extends Paper {
    public void writer() {
        System.out.println("正在使用A4纸张");
    }
}
