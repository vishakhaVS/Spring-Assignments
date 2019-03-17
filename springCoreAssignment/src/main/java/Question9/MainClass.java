package Question9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext ctx9= new ClassPathXmlApplicationContext("Spring-config-Q9.xml");
        System.out.println(ctx9.getBean(Restaurant.class).getHotDrink().prepareHotDrink());
    }
}
