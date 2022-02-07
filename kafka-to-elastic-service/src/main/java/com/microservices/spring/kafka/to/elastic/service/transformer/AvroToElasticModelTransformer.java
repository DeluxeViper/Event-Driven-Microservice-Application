package com.microservices.spring.kafka.to.elastic.service.transformer;

import com.microservices.spring.elastic.model.index.impl.TwitterIndexModel;
import com.microservices.spring.kafka.avro.model.TwitterAvroModel;
import org.apache.avro.generic.GenericData;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvroToElasticModelTransformer {

    public List<TwitterIndexModel> getElasticModels(List<TwitterAvroModel> avroModels) {

//        System.out.println(avroModels.stream()
//                .map(avroModel -> TwitterIndexModel
//                        .builder()
//                        .userId(avroModel.getUserId())
//                        .id(String.valueOf(avroModel.getId()))
//                        .text(avroModel.getText())
//                        .createdAt(ZonedDateTime.ofInstant(Instant.ofEpochMilli(avroModel.getCreatedAt()), ZoneId.systemDefault()))
//                        .build()
//                ).collect(Collectors.toList()));
        List<TwitterIndexModel> twitterIndexModels = new ArrayList<>();
        for (TwitterAvroModel avroModel : avroModels) {
//            TwitterIndexModel twitterIndexModel = new TwitterIndexModel(avroModel.getUserId(), String.valueOf(avroModel.getId()), avroModel.getText(), ZonedDateTime.ofInstant(Instant.ofEpochMilli(avroModel.getCreatedAt()), ZoneId.systemDefault()));
            TwitterIndexModel twitterIndexModel = TwitterIndexModel
                    .builder()
                    .userId(avroModel.getUserId())
                    .id(String.valueOf(avroModel.getId()))
                    .text(avroModel.getText())
                    .createdAt(ZonedDateTime.ofInstant(Instant.ofEpochMilli(avroModel.getCreatedAt()), ZoneId.systemDefault()))
                    .build();
            twitterIndexModels.add(twitterIndexModel);
        }
        return twitterIndexModels;
    }
}
