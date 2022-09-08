package com.hackathon.swiggy.health;

public class Errors {

    public static class OrderNotFound extends RuntimeException {
        public OrderNotFound (String msg) {
            super(msg);
        }
    }

    public static class UserNotFound extends RuntimeException {
        public UserNotFound (String msg) {
            super(msg);
        }
    }

    public static class UserAlreadyExists extends RuntimeException {
        public UserAlreadyExists (String msg) {
            super(msg);
        }
    }

}
