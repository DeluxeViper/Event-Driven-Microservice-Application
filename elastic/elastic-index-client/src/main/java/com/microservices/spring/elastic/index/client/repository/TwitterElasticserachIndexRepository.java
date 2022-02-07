package com.microservices.spring.elastic.index.client.repository;

import com.microservices.spring.elastic.model.index.impl.TwitterIndexModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterElasticserachIndexRepository extends ElasticsearchRepository<TwitterIndexModel, String> {
}
