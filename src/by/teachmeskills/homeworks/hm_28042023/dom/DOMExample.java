package by.teachmeskills.homeworks.hm_28042023.dom;

import by.teachmeskills.homeworks.hm_28042023.sax.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMExample {
    private static final String XML_FILE_PATH = "C:\\Users\\Alshuk\\IdeaProjects\\TMS\\src\\by\\teachmeskills\\homeworks\\hm_28042023\\medical_institution.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(XML_FILE_PATH));

        NodeList employeeElement = document.getDocumentElement().getElementsByTagName("employee");

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < employeeElement.getLength(); i++) {
            employees.add(getEmployee(employeeElement.item(i)));
        }

        employees.forEach(e -> System.out.printf("Employee name: %s, position: %s, department: %s, experience: %s\n",
                e.getName(), e.getPosition(), e.getDepartment(), e.getExperience()));
    }

    private static Employee getEmployee(Node node) {
        Employee employee = new Employee();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            employee.setName(getTagValue("name", element));
            employee.setPosition(getTagValue("position", element));
            employee.setDepartment(getTagValue("department", element));
            employee.setExperience(Integer.parseInt(getTagValue("experience", element)));
        }
        return employee;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
