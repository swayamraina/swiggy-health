#!/usr/bin/env bash

# current user score
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

# create new order
# new order has reward item
new_order="$(curl -X POST localhost:8080/api/user/1/order/guiltfree -H 'Content-Type: application/json' -d '{"items": [{"display_name": "Kinley Water", "variations": [{"display_name": "Kinley Water", "unit_of_measure": "ml", "quantity": "1000", "price": {"mrp": "20", "store_price": "20", "offer_price": "20"}}]}]}' 2>/dev/null)"

echo "$new_order created"

# new score
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool