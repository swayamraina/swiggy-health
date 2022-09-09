#!/usr/bin/env bash

echo "user opens the Swiuggy Active widget and checks his Activity Score"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "currently he sees all rewards are locked because of low health score"
curl -X GET localhost:8080/api/rewards/1 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user is determined now (after seeing the low score) and walks daily"
curl -X POST localhost:8080/api/1/timeseries -H 'Content-Type: application/json' -d '{ "date": "2022-09-09", "steps": 20000}' 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user comes back to the SSwiggy Active screen to check the Activity Score and finds a good progress"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user has now unlocked some rewards"
curl -X GET localhost:8080/api/rewards/1 2>/dev/null | python3 -m json.tool