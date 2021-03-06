FROM golang:1.10.1-alpine3.7

ENV GOPATH /go
ENV PATH $PATH:$GOPATH/bin
ENV CGO_ENABLED 0
ENV MINIO_UPDATE off
ENV MINIO_ACCESS_KEY_FILE=access_key \
    MINIO_SECRET_KEY_FILE=secret_key

WORKDIR /go/src/github.com/minio/

RUN  apk add --no-cache bash gawk sed grep bc coreutils

RUN  \
     apk add --no-cache ca-certificates curl && \
     apk add --no-cache --virtual .build-deps git && \
     echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
     go get -v -d github.com/minio/minio && \
     cd /go/src/github.com/minio/minio && \
     go install -v -ldflags "$(go run buildscripts/gen-ldflags.go)" && \
     rm -rf /go/pkg /go/src /usr/local/go && apk del .build-deps

RUN mkdir /mbin
RUN mkdir -p /minio/certs/CAs

COPY src/main/docker/minio/config.json /minio/
COPY src/main/bash/minio-entrypoint.sh /mbin/
COPY src/main/bash/wait-for-it.sh /mbin/
