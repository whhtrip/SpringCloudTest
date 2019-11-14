package com.elasticsearch;

import com.kafka.customer.KafkaCustomerDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.elasticsearch","com.kafka"})
public class ElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
        KafkaCustomerDemo.main(args);
    }

}
