package com.microservices.spring.twitter.to.kafka.service.exception;

import com.microservices.spring.twitter.to.kafka.service.TwitterToKafkaServiceApplication;

public class TwitterToKafkaServiceException extends RuntimeException {

    public TwitterToKafkaServiceException() {
        super();
    }

    public TwitterToKafkaServiceException(String message) {
        super(message);
    }

    public TwitterToKafkaServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
