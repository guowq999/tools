package com.owen.concurrent;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程下正确的使用消费者，需要记住，一个线程一个消费者
 *
 * @author wenqiang
 * @date 2023/07/12 09:55
 **/
public class KafkaConConsumer {

    public static final int CONCURRENT_PARTITIONS_COUNT = 2;

    private static ExecutorService executorService = Executors.newFixedThreadPool(CONCURRENT_PARTITIONS_COUNT);

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group_concurrent_1");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        for (int i = 0; i < CONCURRENT_PARTITIONS_COUNT; i++) {
            //一个线程一个消费者
            executorService.submit(new ConsumerWorker(properties, "topic_concurrent_1"));
        }
    }



    private static class ConsumerWorker implements Runnable {

        private KafkaConsumer<String, String> consumer;

        public ConsumerWorker(Properties properties, String topic) {
            this.consumer = new KafkaConsumer<>(properties);
            this.consumer.subscribe(Collections.singleton(topic));
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            try {
                while (true) {
                    ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
                    for (ConsumerRecord<String, String> record : records) {
                        System.out.println(threadName+"|"+String.format(
                                "主题：%s，分区：%d，偏移量：%d，" +
                                        "key：%s，value：%s",
                                record.topic(),record.partition(),
                                record.offset(),record.key(),record.value()));
                    }
                }
            } finally {
                consumer.close();
            }
        }
    }
}