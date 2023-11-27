package com.owen.factory;

import com.owen.dto.ColorDTO;
import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个Spring定义的FactoryBean
 * @author wenqiang
 * @date 2023/07/18 15:28
 **/
public class ColorDTOFactoryBean implements FactoryBean<ColorDTO> {

    // 返回一个ColorDTO对象，这个对象会添加到容器中
    @Override
    public ColorDTO getObject() throws Exception {
        return new ColorDTO();
    }

    // 返回实例类型
    @Override
    public Class<?> getObjectType() {
        return ColorDTO.class;
    }

    // 是否是单例？
    // true，这个bean是单例，在容器中保存一份
    // false，多实例，每次获取都会创建一个新的bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}