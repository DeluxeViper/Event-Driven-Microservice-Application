package com.microservices.spring.elastic.index.client.service.impl;

import com.microservices.spring.elastic.index.client.repository.TwitterElasticserachIndexRepository;
import com.microservices.spring.elastic.index.client.service.ElasticIndexClient;
import com.microservices.spring.elastic.model.index.impl.TwitterIndexModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConditionalOnProperty(name = "elastic-config.is-repository", havingValue = "true", matchIfMissing = true)
public class TwitterElasticRepositoryIndexClient implements ElasticIndexClient<TwitterIndexModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticRepositoryIndexClient.class);

    private final TwitterElasticserachIndexRepository twitterElasticserachIndexRepository;

    public TwitterElasticRepositoryIndexClient(TwitterElasticserachIndexRepository twitterElasticserachIndexRepository) {
        this.twitterElasticserachIndexRepository = twitterElasticserachIndexRepository;
    }

    @Override
    public List<String> save(List<TwitterIndexModel> documents) {
        List<TwitterIndexModel> repositoryResponse = (List<TwitterIndexModel>) twitterElasticserachIndexRepository.saveAll(documents);
        List<String> ids = repositoryResponse.stream().map(TwitterIndexModel::getId).collect(Collectors.toList());
        LOG.info("Documents indexed successfully with type: {} and ids: {}", TwitterIndexModel.class.getName(), ids);
        return ids;
    }
}
