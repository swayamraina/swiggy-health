#!/usr/bin/env bash

echo "user checks his current Swiggy Activity score"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user sees a nudge that he can improve his score by placing a guiltfree order"
new_order="$(curl -X POST localhost:8080/api/user/1/order/guiltfree -H 'Content-Type: application/json' -d '{"items": [{"display_name": "Kinley Water", "variations": [{"display_name": "Kinley Water", "unit_of_measure": "ml", "quantity": "1000", "price": {"mrp": "20", "store_price": "20", "offer_price": "20"}}]}]}' 2>/dev/null)"

echo ""
echo ""

echo "new order with id = $new_order is created"

sleep 5

echo ""
echo ""

echo "user instantly checks his Swiggy Activity score aand sees the positive change"
curl -X GET localhost:8080/api/user/1 2>/dev/null | python3 -m json.tool