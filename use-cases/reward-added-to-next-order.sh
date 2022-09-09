#!/usr/bin/env bash

# redeem reward
order="$(curl -X POST localhost:8080/api/user/1/order/next -H 'Content-Type: application/json' -d '{"display_name": "Swiggy Special", "variations": [{"display_name": "Swiggy Special", "unit_of_measure": "gm", "quantity": "100", "price": {"mrp": "100", "store_price": "100", "offer_price": "100"}}]}' 2>/dev/null)"

echo "$order created"

# confirm order is not in system
curl -X GET localhost:8080/api/user/1/order/$order

# create new order
# new order has reward item
new_order="$(curl -X POST localhost:8080/api/user/1/order -H 'Content-Type: application/json' -d '{"items": [{"display_name": "Kinley Water", "variations": [{"display_name": "Kinley Water", "unit_of_measure": "ml", "quantity": "1000", "price": {"mrp": "20", "store_price": "20", "offer_price": "20"}}]}]}' 2>/dev/null)"

echo "$new_order created"

# new order has reward item
curl -X GET localhost:8080/api/user/1/order/$new_order
