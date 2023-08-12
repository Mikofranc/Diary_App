package org.example.utility;

import org.example.exceptions.InvalidNameException;
import org.example.exceptions.InvalidPasswordException;

import java.util.InvalidPropertiesFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean name(String input){
        if(validateName(input)) return true;
        throw new InvalidNameException("Invalid name");
    }
    public static boolean password(String password){
        if (validatePassword(password)) {return true;}
        throw new InvalidPasswordException("Invalid Password");
    }
    private static boolean validateName(String input){
        String regex = "^[a-zA-z]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    private static boolean validatePassword(String input){
        String regex = "^[a-z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String name = "1234";
        Validator.password(name);
    }
}
