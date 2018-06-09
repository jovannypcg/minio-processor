#
# NOTE: This file is meant to be used by docker-compose (development purposes) exclusively.
# In order to build the Docker image to be deployed, take a look at the Dockerfile in the same directory.
#

FROM openjdk:10-jre-slim

ARG version
ARG artifact

ENV APP_HOME /app

RUN mkdir $APP_HOME

WORKDIR $APP_HOME

ADD src/main/bash/wait-for-it.sh $APP_HOME/wait-for.sh
ADD build/libs/${artifact}-${version}.jar $APP_HOME/${artifact}.jar

EXPOSE 3000
