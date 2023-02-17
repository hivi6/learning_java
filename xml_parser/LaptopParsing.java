package xml_parser;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LaptopParsing {
    public static void main(String[] args) {
        var factory = DocumentBuilderFactory.newInstance();
        try {
            var builder = factory.newDocumentBuilder();

            // Get the laptop documents
            var document = builder.parse(new File("xml_parser/laptops.xml"));

            // normalize the xml structure
            document.getDocumentElement().normalize();

            // get all laptop tag element
            var laptopList = document.getElementsByTagName("laptop");
            for (int i = 0; i < laptopList.getLength(); i++) {
                var laptop = laptopList.item(0);
                if (laptop.getNodeType() == Node.ELEMENT_NODE) {
                    Element laptopElement = (Element) laptop;
                    System.out.println("Laptop Name: " + laptopElement.getAttribute("name"));

                    var laptopDetails = laptop.getChildNodes();
                    for (int j = 0; j < laptopDetails.getLength(); j++) {
                        var detail = laptopDetails.item(j);
                        if (detail.getNodeType() == Node.ELEMENT_NODE) {
                            var detailElement = (Element) detail;
                            System.out.println("    " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                        }
                    }

                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
