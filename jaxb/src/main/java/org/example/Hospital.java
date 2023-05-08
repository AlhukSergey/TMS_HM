package org.example;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;

import java.util.List;

@XmlRootElement(name = "hospital")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hospital {
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "employees=" + employees +
                '}';
    }
}
