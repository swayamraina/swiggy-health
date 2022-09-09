#!/usr/bin/env bash

echo "current user score"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "create new guiltfree order"
new_order="$(curl -X POST localhost:8080/api/user/1/order/guiltfree -H 'Content-Type: application/json' -d '{"items": [{"display_name": "Kinley Water", "variations": [{"display_name": "Kinley Water", "unit_of_measure": "ml", "quantity": "1000", "price": {"mrp": "20", "store_price": "20", "offer_price": "20"}}]}]}' 2>/dev/null)"

echo ""
echo ""

echo "new order = $new_order created"

sleep 5

echo ""
echo ""

echo "new score after order creation"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool