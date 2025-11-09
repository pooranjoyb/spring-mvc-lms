package com.javalesson.util;

public class BookValidator {

    public static boolean validateTitle(String title) {
        if(title.isBlank()) {
            System.out.println("Title Cannot be blank");
            return false;
        }
        else return true;
    }
}
