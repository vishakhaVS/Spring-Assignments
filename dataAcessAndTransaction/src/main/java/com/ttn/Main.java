package com.ttn;

import com.ttn.repository.UserRepo;
import com.ttn.service.UserDao;

import com.ttn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.sql.*;


public class Main {
    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-Config.xml");
        UserService userService = ctx.getBean(UserService.class);
        UserDao userdao = ctx.getBean(UserDao.class);
        //UserMapper usermapper = ctx.getBean(UserMapper.class);

        //Question3,4
        System.out.println("=======By DATASOURCE=======");
        userService.printUserNamesDataSource();

        System.out.println("=======By DBCP2 DATASOURCE=======");
        userService.printUserNamesdbcp2datasource();

        System.out.println("=======By SINGLETON DATASOURCE=======");
        userService.printUserNamesdataSourceSingleton();

        //Question5
        System.out.println("=====COUNT OF USERS====");
        userdao.userCount();

        //Question6
        System.out.println("=======PARAMETRIZED QUERY=======");
        userdao.getUserName();

        //Question7
        System.out.println("=======RECORD INSERTION USING JDBC TEMPELATE=======");
        /*userdao.insertUser(new User("Vishakha", "123", "kaku", "2012-10-12", 24));
        userService.printUserNamesdbcp2datasource();*/

        //Question8
        System.out.println("=======QUERY FOR MAP =======");
        userdao.queryForMapDemo();

        //Question9
        System.out.println("=======QUERY FOR LIST =======");
        userdao.queryForListDemo();

        //Question10
        System.out.println("=======ROW MAPPER =======");
        userdao.getUserRow();

        //Question11
        System.out.println("=====HQL QUERY========");
        System.out.println("Count of users:");
        userdao.sessionFactoryDemo();

    }}




