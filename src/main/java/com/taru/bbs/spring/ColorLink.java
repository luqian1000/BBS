package com.taru.bbs.spring;

import org.springframework.stereotype.Component;

@Component(value = "Color")
public class ColorLink extends Link {
    @Override
    public void print() {
        System.out.println("²ÊÉ«Ä«ºÐ´òÓ¡");
    }
}
