/**
 * 
 */
package fr.epita.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import fr.epita.datamodel.*;
import fr.epita.services.dao.QuestionXMLDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Quiz.
 *
 * @author Persistence
 */
public class Quiz {

	/** The user. */
	private static String user = "";
	
	/** The score. */
	private static int score = 0;
	
	/** The type. */	private static int type = 0;
	
	/** The scan. */
	private static Scanner scan;
	
	/** The dao. */
	private static QuestionXMLDAO dao;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Initialisation
		scan = new Scanner(System.in);
		dao = new QuestionXMLDAO();
		welcomeMenu();

	}

	/**
	 * Welcome menu.
	 */
	public static void welcomeMenu() {
		System.out.println("***********************" + "QUIZ" + "***********************");
		System.out.print("Please enter your name:");
		user = scan.nextLine();
		System.out.println("Select the quiz please:");
		System.out.println("1-By topics");
		System.out.println("2-Normal quiz");
		try {
			List<Question> questions = new ArrayList<Question>();
			type = scan.nextInt();
			scan.nextLine();
			if (type == 1) {
				questions = buildByTopic();
			} else {
				questions = buildNormal();
			}
			for (int i = 0; i < questions.size(); i++) {
				showQuestion(i, questions.get(i));
				System.out.println("");
			}
			System.out.println("***********************************");
			System.out.println("****************" + "END" + "****************");
			System.out.println("***********************************");
			System.out.println(user + " You have " + score + " over " + questions.size() + " questions");
			System.out.println("************************************");
			System.out.println("Do you want to export the quiz?");
			System.out.println("1-Yes");
			System.out.println("2-No");
			int resp = scan.nextInt();
			scan.nextLine();
			if (resp == 1) {
				System.out.print("Enter the filename: ");
				String name = scan.nextLine();
				buildFile(name, questions);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Builds the file.
	 *
	 * @param name the name
	 * @param questions the questions
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static void buildFile(String name, List<Question> questions) throws IOException {
		String filename = System.getProperty("user.home") + File.separator + name + ".txt";
		File fout = new File(filename);
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for (int i = 0; i < questions.size(); i++) {
			bw.write((i + 1) + "-" + questions.get(i).getQuestion());
			if (!questions.get(i).getChoices().isEmpty()) {
				for (int j = 0; j < questions.get(i).getChoices().size(); j++) {
					System.out.println("-->" + (j + 1) + "-" + questions.get(i).getChoices().get(j).getChoice());
				}
			} else {
				System.out.println("--> " + questions.get(i).getAnswer().getText());
			}
			bw.newLine();
		}
		bw.close();
		System.out.println("Your file is at " + filename);
	}

	/**
	 * Show question.
	 *
	 * @param index the index
	 * @param question the question
	 */
	private static void showQuestion(int index, Question question) {
		System.out.println((index + 1) + "-" + question.getQuestion());
		if (!question.getChoices().isEmpty()) {
			System.out.println("Your choice: ");
			System.out.println("");
			for (int i = 0; i < question.getChoices().size(); i++) {
				System.out.println("-->" + (i + 1) + "-" + question.getChoices().get(i).getChoice());
			}
			int choice = scan.nextInt();
			scan.nextLine();
			if (question.getChoices().get(choice - 1).isValid()) {
				score++;
			}
		} else {
			System.out.print("Enter your answer: ");
			String reponse = scan.nextLine();
			if (question.getAnswer() != null && question.getAnswer().getText().equalsIgnoreCase(reponse)) {
				score++;
			}
		}
	}

	/**
	 * Builds the normal.
	 *
	 * @return the list
	 * @throws XPathExpressionException the x path expression exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException the parser configuration exception
	 */
	public static List<Question> buildNormal()
			throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
		List<Question> questions = new ArrayList<Question>();
		questions = dao.getAllQuestions();
		return questions;
	}

	/**
	 * Builds the by topic.
	 *
	 * @return the list
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static List<Question> buildByTopic() throws ParserConfigurationException, SAXException, IOException {
		List<Question> questions = new ArrayList<Question>();
		System.out.println("Select the topic please:");
		List<String> topics = dao.getAllTopics();
		for (int i = 0; i < topics.size(); i++) {
			System.out.println((i + 1) + "-" + topics.get(i));
		}
		int sout = scan.nextInt();
		scan.nextLine();
		questions = dao.getAllQuestionsByTopic(topics.get(sout - 1));
		// System.out.println("Questions " + questions);
		return questions;
	}

}
