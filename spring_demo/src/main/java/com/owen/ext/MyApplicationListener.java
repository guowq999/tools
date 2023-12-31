package com.owen.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author wenqiang
 * @date 2023/07/24 10:50
 **/
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    // 当容器中发布此事件以后，方法触达
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件，" + event);
    }
}