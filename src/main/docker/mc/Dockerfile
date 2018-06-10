FROM golang:1.10.1-alpine3.7

ENV PATH $PATH:$GOPATH/bin
ENV CGO_ENABLED 0

WORKDIR /go/src/github.com/minio/

RUN  apk add --no-cache bash gawk sed grep bc coreutils

RUN  \
     apk add --no-cache ca-certificates && \
     apk add --no-cache --virtual .build-deps git && \
     echo 'hosts: files mdns4_minimal [NOTFOUND=return] dns mdns4' >> /etc/nsswitch.conf && \
     go get -v -d github.com/minio/mc && \
     cd /go/src/github.com/minio/mc && \
     go install -v -ldflags "$(go run buildscripts/gen-ldflags.go)" && \
     rm -rf /go/pkg /go/src /usr/local/go && apk del .build-deps

RUN mkdir /mbin
COPY src/main/bash/minio-initializer.sh /mbin/
COPY src/main/bash/wait-for-it.sh /mbin/
