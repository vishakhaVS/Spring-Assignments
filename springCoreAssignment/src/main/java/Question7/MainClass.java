package Question7;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext ctx7 = new ClassPathXmlApplicationContext("Spring-config-Q7.xml");

        System.out.println(ctx7.isSingleton("teaRestaurant"));
    }
}
