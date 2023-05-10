package org.example;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
    private String name;
    private String position;
    private String department;
    private int experience;

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "position: " + position + "\n" +
                "department: " + department + "\n" +
                "experience: " + experience + " years" + "\n";
    }
}
