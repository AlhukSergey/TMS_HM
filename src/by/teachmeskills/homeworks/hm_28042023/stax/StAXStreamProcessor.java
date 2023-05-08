package by.teachmeskills.homeworks.hm_28042023.stax;

import by.teachmeskills.homeworks.hm_28042023.sax.Employee;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StAXStreamProcessor implements AutoCloseable {
    private Employee employee;
    private List<Employee> employees = new ArrayList<>();
    private static final XMLInputFactory factory = XMLInputFactory.newInstance();
    private final XMLStreamReader reader;

    public StAXStreamProcessor(InputStream is) throws XMLStreamException {
        this.reader = factory.createXMLStreamReader(is);
    }

    public void startElement() throws XMLStreamException {
        while (reader.hasNext()) {
            reader.next();
            if (reader.getEventType() == XMLEvent.START_ELEMENT) {
                if (reader.getLocalName().equals("employee")) {
                    employee = new Employee();
                }
                switch (reader.getLocalName()) {
                    case "name" -> employee.setName(reader.getElementText());
                    case "position" -> employee.setPosition(reader.getElementText());
                    case "department" -> employee.setDepartment(reader.getElementText());
                    case "experience" -> employee.setExperience(Integer.parseInt(reader.getElementText()));
                }
            }

            if (reader.getEventType() == XMLEvent.END_ELEMENT && (reader.getLocalName().equals("employee"))) {
                employees.add(employee);
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void close() throws Exception {
        if (Optional.ofNullable(reader).isPresent()) {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
