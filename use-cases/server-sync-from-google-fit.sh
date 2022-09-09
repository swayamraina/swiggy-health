#!/usr/bin/env bash

echo "its evening time and user decides to go for a walk"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user comes back home and opens the Swiggy app to let Swiggy Active sync all the data"
curl -X POST localhost:8080/api/1/timeseries -H 'Content-Type: application/json' -d '{ "date": "2022-09-09", "steps": 20000}' 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user checks his updated score on Swiggy Active screen"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool