#!/usr/bin/env bash

keyspaceCreation="CREATE KEYSPACE IF NOT EXISTS sample WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3 };"
useKeyspace="USE sample;"
tableCreation="CREATE TABLE IF NOT EXISTS units(uid uuid, team_id uuid, workflow_id uuid, step_id int, unit_id int, column text, value text, PRIMARY KEY(uid, step_id));"

cqlsh cassandra-service -e "${keyspaceCreation} ${useKeyspace} ${tableCreation}"
