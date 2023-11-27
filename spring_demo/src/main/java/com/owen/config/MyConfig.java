package com.owen.config;

import com.owen.condition.LinuxCondition;
import com.owen.condition.WindowsCondition;
import com.owen.controller.MyController;
import com.owen.domain.User;
import com.owen.dto.*;
import com.owen.factory.ColorDTOFactoryBean;
import com.owen.my_import.MyImportBeanDefinitionRegistrar;
import com.owen.my_import.MyImportSelector;
import com.owen.type_filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 配置类 == 配置文件
 * @author wenqiang
 * @date 2023/07/18 13:29
 **/
//@ComponentScan(value = "com.owen", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})

//@ComponentScan(value = "com.owen", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//})

//@ComponentScan(value = "com.owen", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})
//}, useDefaultFilters = false)

//@ComponentScan(value = "com.owen", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)
//}, useDefaultFilters = false)

//@ComponentScans(value = {
//        @ComponentScan(value = "com.owen.dao"),
//        @ComponentScan(value = "com.owen.service")
//})

//@ComponentScans({
//        @ComponentScan(value = "com.owen", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
//        }, useDefaultFilters = false),
//        @ComponentScan(value = "com.owen", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class)
//        }, useDefaultFilters = false)
//})

//@ComponentScan(value = "com.owen", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {MyDTO.class, MyController.class})
//}, useDefaultFilters = false)

//@ComponentScan(value = "com.owen", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
//}, useDefaultFilters = false)
@Configuration // 告诉Spring这是一个配置文件
@ComponentScan("com.owen")
//@Import(ColorDTO.class)
//@Import({RedDTO.class, ColorDTO.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MyConfig {

    // 给容器注册一个Bean，类型为返回值的类型，id默认用方法名作为id
    @Bean
    public User user_1() {

        return new User();
    }

    @Bean(name = "user_200")
    public User user_2() {

        return new User();
    }

    // 低版本的Spring不能这样写，要用上面name=的形式
    @Bean("user_300")
    public User user_3() {

        return new User();
    }

    @Scope("prototype")
    @Bean
    public User user_4() {

        return new User();
    }

    @Lazy
    @Bean
    public User user_5() {
        System.out.println("启动时执行了嘛");
        return new User();
    }

    @Conditional(LinuxCondition.class)
    @Bean
    public User user_linux() {
        System.out.println("创建了user_linux");
        return new User();
    }

    @Conditional(WindowsCondition.class)
    @Bean
    public User user_windows() {
        System.out.println("创建了user_windows");
        return new User();
    }

    // 使用Spring提供的FactoryBean工厂创建bean
    // 虽然名称是colorFactoryBean，但是创建出来的对象是ColorDTO对象
    @Bean
    public ColorDTOFactoryBean colorDTOFactoryBean() {
        return new ColorDTOFactoryBean();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public CarDTO carDTO() {

        return new CarDTO();
    }

    @Bean
    public CarOneDTO carOneDTO() {
        return new CarOneDTO();
    }

    @Bean
    public CarTwoDTO carTwoDTO() {
        return new CarTwoDTO();
    }
}