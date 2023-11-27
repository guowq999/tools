package com.owen.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author wenqiang
 * @date 2023/07/04 19:14
 **/
public class SynProducer {
    public static void main(String[] args) {
        // 设置属性
        Properties properties = new Properties();
        // 指定连接的kafka服务器的地址
        properties.put("bootstrap.servers","127.0.0.1:9092");
        // 设置String的序列化
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        // 构建kafka生产者对象
        KafkaProducer<String,String> producer  = new KafkaProducer<String, String>(properties);

        try {
            ProducerRecord<String, String> record;
            try {
                record = new ProducerRecord<>("owen", "teacher333", "owen");
                Future<RecordMetadata> future = producer.send(record);
                RecordMetadata recordMetadata = future.get();
                if (null != recordMetadata) {
                    System.out.println("offset:" + recordMetadata.offset() + "," + "partition:" + recordMetadata.partition());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            // 释放连接
            producer.close();
        }
    }
}