package com.taru.bbs.spring;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("Printer")//�൱��xml������bean��id
public class Printer {
    @Resource(name="A3")//�൱��refָ���ĸ�paper����
    Paper paper;
   @Resource(name="Color")//�൱��refָ��Ŀ��bean��id����
    Link link;
    @Value("ŵ���Ǵ�ӡ��")
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
    //��ӡ
    public void run(){
        System.out.println(logo);
        paper.writer();
        link.print();
    }

    public static void main (String[]args){
        /**
         * ԭʼ����Spring��ʽ
         */
//        Printer printer=new Printer(new A3(),new ColorLink());
//        printer.run();
        /**
         * ��Spring��ʽ
         */
         ApplicationContext context=new ClassPathXmlApplicationContext( "applicationContext.xml");
         Printer printer=context.getBean("printer",Printer.class);
         printer.run();

//
    }


}
