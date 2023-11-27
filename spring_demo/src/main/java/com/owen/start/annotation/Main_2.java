package com.owen.start.annotation;

import com.owen.config.MyConfig;
import com.owen.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wenqiang
 * @date 2023/07/18 13:31
 **/
public class Main_2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);

        User user = (User) applicationContext.getBean("user_1");
        System.out.println(user);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("=====================================================");
        User user4_1 = (User) applicationContext.getBean("user_4");
        User user4_2 = (User) applicationContext.getBean("user_4");
        System.out.println(user4_1 == user4_2);

        System.out.println("=======================================================");
        User user5 = (User) applicationContext.getBean("user_5");
        System.out.println(user5);

        System.out.println("=======================================================");
        Object colorDTOFactoryBean = applicationContext.getBean("colorDTOFactoryBean");
        System.out.println(colorDTOFactoryBean);

        // 使用下面这种方式就可以得到工厂对象
        System.out.println("====================================================");
        Object bean = applicationContext.getBean("&colorDTOFactoryBean");
        System.out.println(bean);
        applicationContext.close();

    }
}