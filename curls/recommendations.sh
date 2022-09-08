#!/usr/bin/env bash

# create recommendation
curl -X GET localhost:8080/api/recommendation/create

# get user recommendation
curl -X GET localhost:8080/api/1/recommendation