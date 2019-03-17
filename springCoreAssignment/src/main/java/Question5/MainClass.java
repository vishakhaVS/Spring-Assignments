package Question5;

import Question3.Restaurant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {


        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-config-Q5.xml");
        ApplicationContext ctx_q6 = new ClassPathXmlApplicationContext("Spring-config-Q6.xml");
        System.out.println(ctx.getBean("complexBean"));

        Restaurant restaurant=ctx_q6.getBean(Restaurant.class);
        System.out.println(restaurant);
    }
}
