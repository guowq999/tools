package com.owen.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author wenqiang
 * @date 2023/07/24 09:41
 **/
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        System.out.println("是否执行了BeanFactoryPostProcessor的postProcessBeanFactoryf方法");
//        int beanDefinitionNames = beanFactory.getBeanDefinitionCount();
//        System.out.println("BFPP:" + beanDefinitionNames);
    }
}