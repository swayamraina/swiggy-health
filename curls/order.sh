#!/usr/bin/env bash

# adds freebie to next order
curl -X POST localhost:8080/api/user/1/next -H 'Content-Type: application/json' -d '{"display_name": "Swiggy Special", "variations": [{"display_name": "Swiggy Special", "unit_of_measure": "gm", "quantity": "100", "price": {"mrp": "100", "store_price": "100", "offer_price": "100"}}]}'

# get order for user
curl -X GET localhost:8080/api/user/1/order/1662671371316
