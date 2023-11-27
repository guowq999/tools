package com.owen.ext;

import com.owen.ext.dto.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenqiang
 * @date 2023/07/24 09:34
 **/
@ComponentScan("com.owen.ext")
@Configuration
public class MyConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }
}