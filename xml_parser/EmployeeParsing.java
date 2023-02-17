package xml_parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class EmployeeParsing {
    public static void main(String[] args) {
        var factory = DocumentBuilderFactory.newInstance();
        try {
            var builder = factory.newDocumentBuilder();

            // create a document
            var doc = builder.parse(new File("xml_parser/Employees.xml"));

            // get the Employee nodes
            var employeeList = doc.getElementsByTagName("Employee");
            for (int i = 0; i < employeeList.getLength(); i++) {
                var employee = employeeList.item(i);
                if (employee.getNodeType() == Node.ELEMENT_NODE) {
                    var employeeElement = (Element) employee;
                    System.out.println("Employee id: " + employeeElement.getAttribute("ID"));

                    var employeeDetails = employee.getChildNodes();
                    for (int j = 0; j < employeeDetails.getLength(); j++) {
                        var detail = employeeDetails.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE) {
                            Element detailElement = (Element) detail;
                            System.out.println("    " + detailElement.getTagName() + ": " + detailElement.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
