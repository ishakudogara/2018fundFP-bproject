package fr.epita.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.services.dao.QuestionXMLDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLReaderTest.
 */
public class XMLReaderTest {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws XPathExpressionException the x path expression exception
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		
		
		//parsing file
		//readAllQuestions();
		testXpath();
	}

	/**
	 * Test xpath.
	 *
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws XPathExpressionException the x path expression exception
	 */
	private static void testXpath() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder(); // create builder to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); // parse xml file with builder and store it in doc object
		
		//set up xpath parser
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		
		// example of element list retrieval
		String expression = "//topic"; // all the elements of the tag name "topic" in the file
		NodeList elementList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		for (int i=0; i<elementList.getLength(); i++) {
			System.out.println(elementList.item(i).getTextContent());
		}
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");
				
		// example of attribute list retrieval
		expression ="//@id"; // all the attributes named "id"
		NodeList attributeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		for (int i=0; i<attributeList.getLength(); i++) {
			System.out.println(attributeList.item(i));
		}
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");
		// example of operators
		expression = "//topic | //label"; // all elements that are either named "topic" or "label"
		elementList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		for (int i=0; i<elementList.getLength(); i++) {
			System.out.println(elementList.item(i).getTextContent());
		}
		
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");
		// example of element list retrieval using hierarchy
		expression = "/questions/question[last()]"; // the last question from the root element questions
		Element element = (Element) xpath.evaluate(expression, doc, XPathConstants.NODE);
		System.out.println(element.getElementsByTagName("label").item(0).getTextContent());

		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");

		//example using the DAO method of xpath
		QuestionXMLDAO dao = new QuestionXMLDAO();
		List<String> labels = dao.getAllQuestionLabels();
		for (String label : labels) {
			System.out.println(label);
		}
	}

	/**
	 * Read all questions.
	 *
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void readAllQuestions() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder(); // create builder to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); // parse xml file with builder and store it in doc object
		
		
		NodeList list = doc.getElementsByTagName("question"); // extract all questions from the xml file
		
		for (int i=0; i<list.getLength(); i++) { // loop on all questions
			Element el  = (Element) list.item(i);  // extract the "question" element
			String order = el.getAttribute("order"); // get the "order" attribute
			System.out.println(order);	// print
			NodeList label = el.getElementsByTagName("label"); 
			System.out.println(label.item(0).getTextContent()); // display the label of the question
		}
	}

}
