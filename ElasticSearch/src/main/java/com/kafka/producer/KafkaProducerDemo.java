package com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author:WangHongHao
 * @date:19-10-21创建
 * @date：修改
 * @description：
 */
public class KafkaProducerDemo {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.179.131:9092");//集群使用逗号分隔
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 200; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>("whh", i + "", "Hello Kafka:" + i);
            kafkaProducer.send(record);
        }
        kafkaProducer.flush();
        kafkaProducer.close();
    }

}
