package com.owen.my_import;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 *
 * @author wenqiang
 * @date 2023/07/18 15:09
 **/
public class MyImportSelector implements ImportSelector {

    // 返回值就是将导入容器种的组件全类名
    // AnnotationMetadata: 当前标注@Import注解类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 方法不要返回null值
        return new String[]{"com.owen.dto.BlueDTO", "com.owen.dto.YellowDTO"};
    }
}