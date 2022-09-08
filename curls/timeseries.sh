#!/usr/bin/env bash


# get week steps
curl -X GET localhost:8080/api/1/timeseries/1

# add steps for a day
curl -X POST localhost:8080/api/1/timeseries -H 'Content-Type: application/json' -d '{ "date": "2022-09-09", "steps": 100}'