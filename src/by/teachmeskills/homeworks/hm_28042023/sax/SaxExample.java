package by.teachmeskills.homeworks.hm_28042023.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxExample {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static final String XML_FILE_PATH = "C:\\Users\\Alshuk\\IdeaProjects\\TMS\\src\\by\\teachmeskills\\homeworks\\hm_28042023\\medical_institution.xml";

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(new File(XML_FILE_PATH), handler);
            employees.forEach(e -> System.out.printf("Employee name: %s, position: %s, department: %s, experience: %s\n",
                    e.getName(), e.getPosition(), e.getDepartment(), e.getExperience()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class XMLHandler extends DefaultHandler {
        boolean isName, isPosition, isDepartment, isExperience;
        Employee employee;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                employee = new Employee();
            }
            if (qName.equals("name")) {
                isName = true;
            }
            if (qName.equals("position")) {
                isPosition = true;
            }
            if (qName.equals("department")) {
                isDepartment = true;
            }
            if (qName.equals("experience")) {
                isExperience = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                employee.setName(new String(ch, start, length));
            }
            if (isPosition) {
                employee.setPosition(new String(ch, start, length));
            }
            if (isDepartment) {
                employee.setDepartment(new String(ch, start, length));
            }
            if (isExperience) {
                employee.setExperience(Integer.parseInt(new String(ch, start, length)));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("employee")) {
                employees.add(employee);
            }
            if (qName.equals("name")) {
                isName = false;
            }
            if (qName.equals("position")) {
                isPosition = false;
            }
            if (qName.equals("department")) {
                isDepartment = false;
            }
            if (qName.equals("experience")) {
                isExperience = false;
            }
        }
    }
}
