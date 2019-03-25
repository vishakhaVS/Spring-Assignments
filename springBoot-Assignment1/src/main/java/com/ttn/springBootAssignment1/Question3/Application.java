package com.ttn.springBootAssignment1.Question3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-config.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println("The username is: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
    }
}
