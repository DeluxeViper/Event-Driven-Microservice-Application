# Event-Driven-Microservice-Application
An Event Driven Microservices application.

## Docker Compose

Steps to run docker compose:
1. cd into docker-compose directory
2. run: `docker-compose -f common.yml -f kafka_cluster.yml up`

###### To view list of brokers and topics:

1. make sure the containers are up and running
2. run: `kafkacat -L -b localhost:19092` OR run: `docker run -it --network=host confluentinc/cp-kafkacat kafkacat -L -b localhost:19092`
    - Note that on MacoS if you've installed `kafkacat` through brew, you'll be using `kcat` instead of `kafkacat` as the command
3. more info about the *confluentinc/cp-kafka* docker image: https://hub.docker.com/r/confluentinc/cp-kafka
