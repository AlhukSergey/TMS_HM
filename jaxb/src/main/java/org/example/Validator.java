package org.example;

import org.example.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static String REGEX_NAME = "[A-Z][a-z]+(\\s[A-Z][a-z]+){2}";
    private static String REGEX_POSITION = "[A-Z][a-z\\s-]+";
    private static String REGEX_DEPARTMENT = "[\\d\\sA-Za-z-]+";
    private static String REGEX_EXPERIENCE = "[\\d]+[\\syears]";

    private Validator() {
    }

    public static void checkName(String name) throws ValidationException {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new ValidationException("The name isn't valid!");
        }
    }

    public static void checkPosition(String position) throws ValidationException {
        Pattern pattern = Pattern.compile(REGEX_POSITION);
        Matcher matcher = pattern.matcher(position);
        if (!matcher.matches()) {
            throw new ValidationException("The position isn't valid!");
        }
    }

    public static void checkDepartment(String department) throws ValidationException {
        Pattern pattern = Pattern.compile(REGEX_DEPARTMENT);
        Matcher matcher = pattern.matcher(department);
        if (!matcher.matches()) {
            throw new ValidationException("The department isn't valid!");
        }
    }

    public static void checkExperience(String experience) throws ValidationException {
        Pattern pattern = Pattern.compile(REGEX_EXPERIENCE);
        Matcher matcher = pattern.matcher(experience);
        if (!matcher.matches()) {
            throw new ValidationException("The experience isn't valid!");
        }
    }
}
