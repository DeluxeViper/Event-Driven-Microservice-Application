# Event-Driven-Microservice-Application
An Event Driven Microservices application.

## Docker Compose

Steps to run docker compose:
1. cd into docker-compose directory
2. run: `docker-compose up` OR `docker-compose -f common.yml -f kafka_cluster.yml -f services.yml`
3. note: to run specific yaml files (for instance the services.yml file) run `docker-compose -f common.yml -f services.yml`

###### To view list of brokers and topics:

1. make sure the containers are up and running
2. run: `kafkacat -L -b localhost:19092` OR run: `docker run -it --network=host confluentinc/cp-kafkacat kafkacat -L -b localhost:19092`
    - Note that on MacoS if you've installed `kafkacat` through brew, you'll be using `kcat` instead of `kafkacat` as the command
3. more info about the *confluentinc/cp-kafka* docker image: https://hub.docker.com/r/confluentinc/cp-kafka


###### Kafkacat commands

- `kcat -C -b brokers -t topic`: View messages sent to a particular topic by a specific broker
- `kcat -L -b brokers`: List metadata for all topics and brokers
- `kcat -L -b brokers -t topic`: List metadata for a specific topic 

## Maven Commands

Note: Before running any `mvn install` commands make sure to have a local kafka cluster running or else tests will fail (since the tests check whether any kafka instances are running). Alternatively you can use `mvn install -DskipTests` option.

## Credits

A very grateful thank you to Ali Gelenler who put a course together that went through the creation of the application I've used as a template for this code. Note that this application will not be the same as the application created in the "Master event-driven microservices architecture with patterns using Spring boot, Spring cloud, Kafka and Elasticsearch" course, I will add on to it.
