#!/usr/bin/env bash

echo "user redeems reward"
order="$(curl -X POST localhost:8080/api/user/1/order/next -H 'Content-Type: application/json' -d '{"display_name": "Swiggy Special", "variations": [{"display_name": "Swiggy Special", "unit_of_measure": "gm", "quantity": "100", "price": {"mrp": "100", "store_price": "100", "offer_price": "100"}}]}' 2>/dev/null)"

echo ""
echo ""

echo "order (in dark-cart) = $order created"

sleep 5
echo ""
echo ""

echo "confirming that order is not in system"
curl -X GET localhost:8080/api/user/1/order/$order 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "create new order - new order has reward item"
new_order="$(curl -X POST localhost:8080/api/user/1/order/food -H 'Content-Type: application/json' -d '{"items": [{"display_name": "Kinley Water", "variations": [{"display_name": "Kinley Water", "unit_of_measure": "ml", "quantity": "1000", "price": {"mrp": "20", "store_price": "20", "offer_price": "20"}}]}]}' 2>/dev/null)"

echo ""
echo ""

echo "new order = $new_order created"

sleep 5

echo ""
echo ""

echo "new order has reward item"
curl -X GET localhost:8080/api/user/1/order/$new_order 2>/dev/null | python3 -m json.tool
