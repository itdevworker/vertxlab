package com.training.lab1;

//Functional Programming : Lab Assignment 1
@FunctionalInterface
interface Resolve {
    void resolve(Object response);
}

@FunctionalInterface
interface Reject {
    void reject(Object response);
}

class UserLogin {
    public void validate(Resolve resolve, Reject reject) {
        String userName = "user";
        String password = "pwd";
        if (userName.equals("user") && password.equals("pwd")) {
            resolve.resolve("User login is successful.");
        } else {
            reject.reject("User login is failed.");
        }
    }
}

public class AssignmentValidation {
    public static void main(String[] args) {
        UserLogin userLogin = new UserLogin();
        userLogin.validate(response -> System.out.println(response), response -> System.out.println(response));
    }
}
