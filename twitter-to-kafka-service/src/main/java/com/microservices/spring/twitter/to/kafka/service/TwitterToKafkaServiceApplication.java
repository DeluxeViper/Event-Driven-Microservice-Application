package com.microservices.spring.twitter.to.kafka.service;

import com.microservices.spring.config.TwitterToKafkaServiceConfigData;
import com.microservices.spring.twitter.to.kafka.service.init.StreamInitializer;
import com.microservices.spring.twitter.to.kafka.service.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ConfigurationPropertiesScan
@ComponentScan(basePackages = "com.microservices.spring")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

    private final StreamInitializer streamInitializer;

    private final StreamRunner streamRunner;

    public TwitterToKafkaServiceApplication(StreamInitializer streamInitializer, StreamRunner streamRunner) {
        this.streamInitializer = streamInitializer;
        this.streamRunner = streamRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("App starts...");
        streamInitializer.init();
        streamRunner.start();
    }
}
