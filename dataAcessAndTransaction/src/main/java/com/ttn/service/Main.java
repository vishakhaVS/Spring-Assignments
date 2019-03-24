package com.ttn.service;

import com.ttn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-Config.xml");
        UserService userService = ctx.getBean(UserService.class);
        UserDao userdao = ctx.getBean(UserDao.class);
        //UserMapper usermapper = ctx.getBean(UserMapper.class);

        System.out.println("=======By DATASOURCE=======");
        userService.printUserNamesDataSource();

        System.out.println("=======By DBCP2 DATASOURCE=======");
        userService.printUserNamesdbcp2datasource();

        System.out.println("=======By SINGLETON DATASOURCE=======");
        userService.printUserNamesdataSourceSingleton();

        System.out.println("=====COUNT OF USERS====");
        userdao.userCount();

        System.out.println("=======PARAMETRIZED QUERY=======");
        userdao.getUserName();
        System.out.println("=======RECORD INSERTION USING JDBC TEMPELATE=======");
        /*userdao.insertUser(new User("Vishakha", "123", "kaku", "2012-10-12", 24));
        userService.printUserNamesdbcp2datasource();*/

        System.out.println("=======QUERY FOR MAP =======");
        userdao.queryForMapDemo();

        System.out.println("=======QUERY FOR LIST =======");
        userdao.queryForListDemo();

        System.out.println("=======ROW MAPPER =======");
        userdao.getUserRow();


        System.out.println("=====HQL QUERY========");
        System.out.println("Count of users:");
        userdao.sessionFactoryDemo();


    }


}
