package com.kafka.customer;

import com.elasticsearch.ElasticSearchTest;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author:WangHongHao
 * @date:19-10-21创建
 * @date：修改
 * @description：
 */

public class KafkaCustomerDemo {

    public static void main(String[] args) {
        System.out.println("开始获取数据");
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.179.131:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "g1");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties); // 获取指定Topic中的record
        // kafkaConsumer.subscribe(Arrays.asList("zpark"));
        // 获取指定的Topic partition中的record
        kafkaConsumer.assign(Arrays.asList(new TopicPartition("mytopic", 0))); // 获取指定的Topic partition offset中的record
        // kafkaConsumer.seek(new TopicPartition("zpark",0),10);
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1000));
            if (records != null && !records.isEmpty()) {
                for (ConsumerRecord<String, String> record : records) {
                    TransportClient client = null;
                    IndexResponse response = null;
                    String key = record.key();
                    String value = record.value();
                    int partition = record.partition();
                    long offset = record.offset();
                    long timestamp = record.timestamp();
                    try {
                        client = ElasticSearchTest.getClient();
                        response = client.prepareIndex("twitter", "nginxLog")
                                .setSource(jsonBuilder()
                                        .startObject()
                                        .field("key", key)
                                        .field("value", value)
                                        .field("partition", partition)
                                        .field("offset",offset)
                                        .field("timestamp",timestamp)
                                        .endObject()
                                )
                                .get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(key + " | " + value + " | " + partition + " | " + offset + " | " + timestamp);
                }
            }
        }
    }
}
