#!/usr/bin/env bash

echo "user now decides to redeem the unlocked reward"
order="$(curl -X POST localhost:8080/api/user/1/order/next -H 'Content-Type: application/json' -d '{"display_name": "Swiggy Special", "variations": [{"display_name": "Swiggy Special", "unit_of_measure": "gm", "quantity": "100", "price": {"mrp": "100", "store_price": "100", "offer_price": "100"}}]}' 2>/dev/null)"

echo ""
echo ""

echo "cart with id = $order is created in backend and he sees he'll get it delivered with next order"

sleep 5
echo ""
echo ""

echo "users gets a bit anxious and checks his order history and he gets a confirmation that order is not in system and he needs to place an order"
curl -X GET localhost:8080/api/user/1/order/$order 2>/dev/null | python3 -m json.tool

sleep 5

echo ""
echo ""

echo "user create new order and sees reward item is automatically added to the cart/order"
new_order="$(curl -X POST localhost:8080/api/user/1/order/food -H 'Content-Type: application/json' -d '{"items": [{"display_name": "Kinley Water", "variations": [{"display_name": "Kinley Water", "unit_of_measure": "ml", "quantity": "1000", "price": {"mrp": "20", "store_price": "20", "offer_price": "20"}}]}]}' 2>/dev/null)"

echo ""
echo ""

echo "new order with id = $new_order is created"

sleep 5

echo ""
echo ""

echo "user reconfirms that the reward is indeed getting delivered with this order"
curl -X GET localhost:8080/api/user/1/order/$new_order 2>/dev/null | python3 -m json.tool
