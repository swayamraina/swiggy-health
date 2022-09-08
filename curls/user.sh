#!/usr/bin/env bash

# create user
curl -X POST localhost:8080/api/user/create -H 'Content-Type: application/json' -d '{"score": 100}'

# get user score
curl -X GET localhost:8080/api/user/1