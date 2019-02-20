package fr.epita.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionXMLDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLWriterTest.
 */
public class XMLWriterTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		//parsing file
		//create();
		//modify();
		delete();
		
	}

	/**
	 * Delete.
	 *
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerConfigurationException the transformer configuration exception
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerException the transformer exception
	 */
	private static void delete() throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		QuestionXMLDAO dao = new QuestionXMLDAO();
		List<Question> listQuestions = dao.getAllQuestions();
		Question question = listQuestions.get(0);
		dao.delete(question);
	}

	/**
	 * Modify.
	 *
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws TransformerException the transformer exception
	 */
	private static void modify() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		QuestionXMLDAO dao = new QuestionXMLDAO();
		List<Question> listQuestions = dao.getAllQuestions();
		Question question = listQuestions.get(0);
		question.setDifficulty(1);
		dao.update(question);
		
		
	}

	/**
	 * Creates the.
	 *
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerConfigurationException the transformer configuration exception
	 * @throws TransformerException the transformer exception
	 */
	private static void create() throws ParserConfigurationException, SAXException, IOException,
			TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fact.newDocumentBuilder(); // create builder to parse the xml file
		Document doc = builder.parse(new File("questions.xml")); // parse xml file with builder and store it in doc object

		Element newQuestion = doc.createElement("question"); // new element creation
		newQuestion.setAttribute("order", "3");
		Element rootElement = doc.getDocumentElement(); // "questions" element
		rootElement.appendChild(newQuestion); // adding the element as a child of a given element (here the root element)
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); // creating a transformer to push the modifications
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.transform(new DOMSource(doc), new StreamResult("questions.xml")); // pushing the new value for the xml file
	}
}
