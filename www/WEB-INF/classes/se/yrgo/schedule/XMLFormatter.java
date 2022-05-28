package se.yrgo.schedule;

import java.util.List;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.DOMException;

/**
 * A class implementing the Formatter interface.
 * Formats a List of Assignment to XML.
 */
public class XMLFormatter implements Formatter {
    public String format(List<Assignment> assignments) {
        if (assignments.size() == 0) {
            return new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
                    .append("<schedules></schedules>\n")
                    .toString();
        } else {
            try {
                //Creating the Document
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();
                //Creating the root element
                Element rootElement = doc.createElement("schedules");
                doc.appendChild(rootElement);

                //For-each loop to create XML
                for (Assignment assignment : assignments) {
                    // Create an Element schedule using doc.createElement("schedule")
                    // set the attribute "date" on this schedule (use this assignment's date)
                    // Create an Element school the same way
                    // Create an Element schoolName the same way
                    // add a text node to schoolName and use the assignment's school's name
                    //    to create a textNode, use doc.createTextNode(the text as a string);
                    // add schoolName as a child to school
                    // Create an Element address the same way as above
                    // append a textNode to address with the assignment's school's address
                    // append address as a child to school
                    // Append the whole school as a child to schedule
                    // Create an Element substitute
                    // Create an element Element name
                    // Append a text node to name with the assignment's teacher's name
                    // Append name as a child to substitute
                    // Append the whole substitute as a child to schedule
                    // Append the whole schedule as a child to rootElement
                }

                StringWriter xml = new StringWriter();
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(xml);
                transformer.transform(source, result);
                return xml.toString();

            } catch (ParserConfigurationException | TransformerException e) {
                return "XML Error";
            }
        }
    }
}
