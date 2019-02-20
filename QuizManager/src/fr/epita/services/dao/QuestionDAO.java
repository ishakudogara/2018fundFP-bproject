package fr.epita.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.datamodel.Question;

// TODO: Auto-generated Javadoc
/**
 * The Class QuestionDAO.
 */
public class QuestionDAO {

	/** The Constant DB_PASSWORD. */
	private static final String DB_PASSWORD = "";
	
	/** The Constant DB_USERNAME. */
	private static final String DB_USERNAME = "sa";
	
	/** The Constant DB_URI. */
	private static final String DB_URI = "jdbc:h2:C:/Formation/db/h2DS";
										//"~/test/"

	
	/**
										 * Creates the.
										 *
										 * @param question the question
										 */
										public void create(Question question) {
		try {
			Connection connection = DriverManager.getConnection(DB_URI, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("INSERT INTO QUESTION VALUES (?, ?)");
			statement.setString(0, question.getQuestion());
			statement.setInt(1, question.getDifficulty());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}    
		
	}
	
	/**
	 * Read by difficulty.
	 *
	 * @param difficulty the difficulty
	 * @return the list
	 */
	public List<Question> readByDifficulty(int difficulty) {
		List<Question> foundQuestions = new ArrayList<Question>();
		try {
			Connection connection = DriverManager.getConnection(DB_URI, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("SELECT QUESTION, DIFFICULTY FROM QUESTION WHERE DIFFICULTY = ?");
			statement.setInt(0, difficulty);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {  // for all questions matching the difficulty
				String SQLquestion = resultSet.getString(1); // get match question name
				int SQLdifficulty = resultSet.getInt(2); //get match difficulty
				Question foundQuestion = new Question(); // put it in a question
				foundQuestion.setQuestion(SQLquestion);
				foundQuestion.setDifficulty(SQLdifficulty);
				foundQuestions.add(foundQuestion); // add customer to the result list
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return foundQuestions;
	}
	
	/**
	 * Update difficulty.
	 *
	 * @param question the question
	 * @param newDifficulty the new difficulty
	 */
	public void updateDifficulty(Question question, int newDifficulty) {
		try {
			Connection connection = DriverManager.getConnection(DB_URI, DB_USERNAME, DB_PASSWORD);
			PreparedStatement statement = connection.prepareStatement("UPDATE QUESTION SET DIFFICULTY = ? WHERE NAME = ?");
			statement.setInt(0, newDifficulty);
			statement.setString(1, question.getQuestion());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete.
	 *
	 * @param question the question
	 */
	public void delete(Question question) {
		//TODO open connection
		//TODO prepare SQL statement
		//TODO add parameters
		//TODO execute statement
	}
}
