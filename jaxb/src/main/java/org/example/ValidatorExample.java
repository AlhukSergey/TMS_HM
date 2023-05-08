package org.example;

import org.example.exceptions.ValidationException;

public class ValidatorExample {
    public static void main(String[] args) {
        try {
            Validator.checkName("Ivanova Inna Sergeevna");
            Validator.checkDepartment("Surgery department");
            Validator.checkPosition("Nurse of 3 category");
            Validator.checkExperience("12 years");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}
