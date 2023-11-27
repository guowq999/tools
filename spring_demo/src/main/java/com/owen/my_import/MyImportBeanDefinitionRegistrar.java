package com.owen.my_import;

import com.owen.dto.RainBowDTO;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * 把需要添加到容器种的bean，调用BeanDefinitionRegistry.registerBeanDefinition手工注册进来
 *
 * @author wenqiang
 * @date 2023/07/18 15:16
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata annotation metadata of the importing class 当前类的注解信息
     * @param registry current bean definition registry BeanDefinition注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("这里执行了嘛");
        Boolean beanDefinition = registry.containsBeanDefinition("com.owen.dto.RedDTO");
        Boolean beanDefinition1 = registry.containsBeanDefinition("com.owen.dto.BlueDTO");
        if (beanDefinition && beanDefinition1) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBowDTO.class);
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}