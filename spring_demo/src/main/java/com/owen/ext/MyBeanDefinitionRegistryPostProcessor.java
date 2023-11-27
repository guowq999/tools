package com.owen.ext;

import com.owen.ext.dto.Black;
import com.owen.ext.dto.Yellow;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wenqiang
 * @date 2023/07/24 10:02
 **/
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
//        int beanDefinitionNames = registry.getBeanDefinitionCount();
//        System.out.println("BDRPP:" + beanDefinitionNames);
//
//        System.out.println("执行了BDRPP中的postProcessBeanDefinitionRegistry方法");
//        registry.registerBeanDefinition("yellow", new RootBeanDefinition(Yellow.class));
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Black.class).getBeanDefinition();
//        registry.registerBeanDefinition("black", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println("执行了BDRPP中父接口BFPP的postProcessBeanFactory方法");
//        int beanDefinitionNames = beanFactory.getBeanDefinitionCount();
//        System.out.println("BDRPP:postProcessBeanFactory" + beanDefinitionNames);
    }
}