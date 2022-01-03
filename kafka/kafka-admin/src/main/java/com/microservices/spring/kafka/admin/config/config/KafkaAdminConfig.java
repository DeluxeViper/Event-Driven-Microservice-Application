package com.microservices.spring.kafka.admin.config.config;

import com.microservices.spring.config.KafkaConfigData;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

import java.util.Map;

@EnableRetry
@Configuration
public class KafkaAdminConfig {
    public KafkaAdminConfig(KafkaConfigData kafkaConfigData) {
        this.kafkaConfigData = kafkaConfigData;
    }

    private final KafkaConfigData kafkaConfigData;

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(Map.of(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigData.getBootstrapServers()));
    }
}
