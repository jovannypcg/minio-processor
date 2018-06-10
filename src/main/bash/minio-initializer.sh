#!/bin/sh

mc config host add minio http://minio-server:9000 ${MINIO_ACCESS_KEY} ${MINIO_SECRET_KEY}
mc mb minio/f8-requestor-data

# TODO: Fix ARN
mc events add minio/f8-requestor-data arn:minio:sqs:us-east-1:1:uploadEvents --suffix .rb
