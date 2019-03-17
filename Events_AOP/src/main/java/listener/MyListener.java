package listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;

//Exercise2
public class MyListener implements ApplicationListener<ApplicationContextEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        System.out.println(event.getClass().getSimpleName());
    }
}
