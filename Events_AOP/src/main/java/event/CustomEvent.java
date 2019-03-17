package event;

import org.springframework.context.ApplicationEvent;

//Exercise3
public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source) {
        super(source);
    }
}
