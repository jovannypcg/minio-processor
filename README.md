# Requestor Data API

Listens for incoming Message Queue messages that are uploaded data to minio.

## Setup

The necessary stack was dockerized, so that it is easier to start up the API. The stack includes: *RabbitMQ*, *Minio*, *Cassandra* and the *Spring Boot* application.

###  Docker Compose

The whole stack is integrated with Docker Compose, it has the following services and volumes defined:

* **requestor-data-api**: Spring Boot application for the API, it will listen to messages from RabbitMQ
* **rabbitmq-service**: RabbitMQ instance that is going to be listeting to events in Minio
* **minio-server**: Minio server, it is configured to have a bucket called *f8-requestor-data* and an event for *.csv* files
* **minio-initializer**: Runs an image of *mc*, the Minio Client that creates the bucket and event
* **cassandra-service**: Cassandra instance as a reactive datasource

The *requestor-data-api*, *minio-server* and *minio-initializer* services depends on *rabbitmq-service*. For this reason, the `wait-for-it.sh` script was included, this way the dependent services will not be able to start up until *rabbitmq-service* has started.

## Start the Service

1. Build the *.jar* file of the API

   ```shell
   $ ./gradlew clean build
   ```

2. Build docker images

   ```shell
   $ docker-compose build
   ```

3. Start up the containers

   ```shell
   $ docker-compose up
   ```

## Playing around

1. Visit Minio Browser at http://localhost:9000
2. Access the already created *f8-requestor-data* bucket at http://localhost:9000/minio/f8-requestor-data/
3. Click on the *+* button, which is located in the bottom right corner and choose *Upload File*
4. Pick up any file with the *.csv* extension
5. Look at the logs of the *requestor-data-api*

