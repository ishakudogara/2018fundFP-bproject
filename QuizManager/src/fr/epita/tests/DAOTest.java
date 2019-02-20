package fr.epita.tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import fr.epita.datamodel.Question;
import fr.epita.services.dao.QuestionDAO;
import fr.epita.services.dao.QuestionXMLDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class DAOTest.
 */
public class DAOTest {
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws TransformerConfigurationException the transformer configuration exception
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerFactoryConfigurationError the transformer factory configuration error
	 * @throws TransformerException the transformer exception
	 */
	public static void main(String[] args) throws TransformerConfigurationException, ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		Question question = new Question();
		question.setQuestion("What are the main differences between Java and C++ ?");
		question.setDifficulty(8);
		String[] topics = new String[2];
		topics[0] = "Java";
		topics[1] = "C++";
		question.setTopics(topics);
		QuestionXMLDAO dao = new QuestionXMLDAO();
		dao.create(question);
	}

}
