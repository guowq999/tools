package com.owen.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * 类说明：kafak生产者
 *
 * @author wenqiang
 * @date 2023/07/04 17:01
 **/
public class HelloKafkaProducer {

    public static void main(String[] args) {
        // 设置属性
        Properties properties = new Properties();
        // 指定连接的kafka服务器的地址
        properties.put("bootstrap.servers", "127.0.01:9092");
        //补充一下： 配置多台的服务  用,分割， 其中一个宕机，生产者 依然可以连上（集群）
        // 设置String的序列化 （对象-》二进制字节数组 ： 能够在网络上传输 ）
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        // 创建生成者对象
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // 发送消息
        try {
            ProducerRecord<String, String> producerRecord;
            try {
                // 构建消息
                producerRecord = new ProducerRecord<>("owen", "name", "owen");
                Future<RecordMetadata> send = producer.send(producerRecord);
                System.out.println("message is sent");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } finally {
            // 释放连接
            producer.close();
        }
    }

}