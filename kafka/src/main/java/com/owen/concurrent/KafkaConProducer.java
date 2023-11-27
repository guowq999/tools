package com.owen.concurrent;

import com.owen.selfserial.User;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程下使用生产者
 *
 * @author wenqiang
 * @date 2023/07/12 09:35
 **/
public class KafkaConProducer {

    //发送消息的个数
    private static final int MSG_SIZE = 1000;
    //负责发送消息的线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors());

    private static CountDownLatch countDownLatch  = new CountDownLatch(MSG_SIZE);

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092");
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);

        try {
            for (int i = 0; i < MSG_SIZE; i++) {
                User user = makeUser(i);
                ProducerRecord<String, String> producerRecord =
                        new ProducerRecord<>("topic_concurrent_1", null,
                                System.currentTimeMillis(), user.getId() + "", user.toString());
                executorService.submit(new ProducerWroker(producerRecord, kafkaProducer));
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            kafkaProducer.close();
        }
    }

    private static User makeUser(int id){
        User user = new User(id);
        String userName = "msb_"+id;
        user.setName(userName);
        return user;
    }



    public static class ProducerWroker implements Runnable {

        private ProducerRecord<String, String> record;

        private KafkaProducer<String, String> producer;

        public ProducerWroker(ProducerRecord<String, String> record, KafkaProducer<String, String> producer) {
            this.record = record;
            this.producer = producer;
        }

        @Override
        public void run() {
            final String threadName = Thread.currentThread().getName();
            try {
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if (null != exception) {
                            exception.printStackTrace();
                        }
                        if (null != metadata) {
                            System.out.println(threadName+"|" +String.format("偏移量：%s,分区：%s", metadata.offset(),
                                    metadata.partition()));
                        }
                    }
                });
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}