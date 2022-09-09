#!/usr/bin/env bash

# current user score
curl -X GET localhost:8080/api/user/1

# no rewards
curl -X GET localhost:8080/api/rewards/1

# walks some distance
curl -X POST localhost:8080/api/1/timeseries -H 'Content-Type: application/json' -d '{ "date": "2022-09-09", "steps": 20000}'

# updated user score
curl -X GET localhost:8080/api/user/1

# some rewards
curl -X GET localhost:8080/api/rewards/1