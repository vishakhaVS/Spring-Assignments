package Question3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-config2.xml");

        //System.out.println(ctx.getBean());
        //System.out.println(ctx.getBean("teaRestaurant"));
        //System.out.println(ctx.getBean("expressTeaRestaurant"));
        System.out.println(ctx.getBean("tea"));
        System.out.println(ctx.getBean("tea2"));



    }
}
