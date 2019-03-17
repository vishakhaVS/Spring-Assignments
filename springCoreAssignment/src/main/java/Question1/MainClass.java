package Question1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-config1.xml");


        /*Question2*/
        System.out.println(ctx.getBean("db1"));
        System.out.println(ctx.getBean("db2"));


    }
}


