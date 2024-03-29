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

                //Adding child elements
                for (Assignment assignment : assignments) {
                    // Create an Element schedule using doc.createElement("schedule")
                    Element schedule = doc.createElement("schedule");
                    // set the attribute "date" on this schedule (use this assignment's date)
                    schedule.setAttribute("date", assignment.date());

                    // Create Elements school & schoolName the same way
                    Element school = doc.createElement("school");
                    Element schoolName = doc.createElement("schoolName");
                    // add a text node to schoolName and use the assignment's school's name
                    //    to create a textNode, use doc.createTextNode(the text as a string);
                    schoolName.appendChild(doc.createTextNode(assignment.school().name()));
                    // add schoolName as a child to school
                    school.appendChild(schoolName);

                    // Create an Element address the same way as above
                    Element address = doc.createElement("address");
                    // append a textNode to address with the assignment's school's address
                    address.appendChild(doc.createTextNode(assignment.school().address()));
                    // append address as a child to school
                    school.appendChild(address);
                    // Append the whole school as a child to schedule
                    schedule.appendChild(school);

                    // Create Elements substitute & name
                    Element substitute = doc.createElement("substitute");
                    Element name = doc.createElement("name");
                    // Append a text node to name with the assignment's teacher's name
                    name.appendChild(doc.createTextNode(assignment.teacher().name()));
                    // Append name as a child to substitute
                    substitute.appendChild(name);
                    // Append the whole substitute as a child to schedule
                    schedule.appendChild(substitute);
                    // Append the whole schedule as a child to rootElement
                    rootElement.appendChild(schedule);
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
