#!/usr/bin/env bash

# current user score
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

# no rewards
curl -X GET localhost:8080/api/rewards/1 2>/dev/null | python3 -m json.tool

# walks some distance
curl -X POST localhost:8080/api/1/timeseries -H 'Content-Type: application/json' -d '{ "date": "2022-09-09", "steps": 20000}' 2>/dev/null | python3 -m json.tool

# updated user score
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

# some rewards
curl -X GET localhost:8080/api/rewards/1 2>/dev/null | python3 -m json.tool