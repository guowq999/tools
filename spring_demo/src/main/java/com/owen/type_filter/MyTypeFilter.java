package com.owen.type_filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author wenqiang
 * @date 2023/07/18 14:25
 **/
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader the metadata reader for the target class 读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory a factory for obtaining metadata readers 工厂元数据，其他任何类的信息
     * for other classes (such as superclasses and interfaces)
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类资源（类的路径）
        Resource resource = metadataReader.getResource();

        String className = classMetadata.getClassName();
        if (className.contains("vice")) {
            return true;
        }
        return false;
    }
}