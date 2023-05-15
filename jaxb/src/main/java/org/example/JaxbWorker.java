package org.example;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.example.exceptions.NoEmployeeFoundException;

import java.io.File;

public class JaxbWorker {
    private static final String XML_FILE_PATH = "C:\\Users\\Alshuk\\IdeaProjects\\TMS\\jaxb\\medical_institution.xml";

    public static void main(String[] args) {
        Hospital hospital = convertFromXMLToObject(XML_FILE_PATH);
        System.out.println(hospital);
        System.out.println("____________________________");
        try {
            System.out.println(checkEmployee("Ivanova Inna Sergeevna", hospital).toString());
        } catch (NoEmployeeFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("____________________________");
    }

    private static Hospital convertFromXMLToObject(String filePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Hospital.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Hospital) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static Employee checkEmployee(String str, Hospital hospital) throws NoEmployeeFoundException {
        return hospital.getEmployees().stream().filter(s -> s.getName().equals(str)).findAny().orElseThrow(() -> new NoEmployeeFoundException("No such employee found!"));
    }
}