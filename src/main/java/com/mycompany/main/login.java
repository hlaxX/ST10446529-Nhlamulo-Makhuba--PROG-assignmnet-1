/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
// Login class
class login {
    private user registeredUser;

    // register a new user
    public void registerUser(String username, String password, String firstName, String lastName) {
        if (validateUsername(username) && validatePassword(password)) {
            registeredUser = new user(username, password, firstName, lastName);
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed due to invalid inputs.");
        }
    }

    // validate username
   public boolean validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            System.out.println("Username successfully captured");
            return true;
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return false;
        }
    }

    // validate password
   public boolean validatePassword(String password) {
        // Regular expression for password validation: Minimum 8 characters, at least 1 uppercase, 1 number, and 1 special character
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Password successfully captured");
            return true;
        } else {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return false;
        }
    }

    // Method to handle user login
public boolean loginUser(String username, String password) {
    if (registeredUser != null) {
        if (registeredUser.getUsername().equals(username) && registeredUser.getPassword().equals(password)) {
            System.out.println("Welcome " + registeredUser.getFirstName() + " " + registeredUser.getLastName() + ", it is great to see you again.");
            return true;  // Login successful
        } else {
            System.out.println("Username or password incorrect, please try again.");
            return false;  // Login failed
        }
    } else {
        System.out.println("No registered user found. Please register first.");
        return false;  // No registered user
    }
}
}
