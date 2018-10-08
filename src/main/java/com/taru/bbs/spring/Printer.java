package com.taru.bbs.spring;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("Printer")//相当于xml配置里bean的id
public class Printer {
    @Resource(name="A3")//相当于ref指定哪个paper启动
    Paper paper;
   @Resource(name="Color")//相当于ref指向目标bean的id名字
    Link link;
    @Value("诺基亚打印机")
    String logo;
    public void setLogo(String logo) {
        this.logo = logo;
    }
    public void setPaper(Paper paper) {
        this.paper = paper;
    }
    public void setLink(Link link) {
        this.link = link;
    }
    public Printer(){
    }
    public Printer(Paper paper,Link link){
        this.paper=paper;
        this.link=link;
    }
    //打印
    public void run(){
        System.out.println(logo);
        paper.writer();
        link.print();
    }

    public static void main (String[]args){
        /**
         * 原始不用Spring方式
         */
//        Printer printer=new Printer(new A3(),new ColorLink());
//        printer.run();
        /**
         * 用Spring方式
         */
         ApplicationContext context=new ClassPathXmlApplicationContext( "applicationContext.xml");
         Printer printer=context.getBean("printer",Printer.class);
         printer.run();

//
    }


}
