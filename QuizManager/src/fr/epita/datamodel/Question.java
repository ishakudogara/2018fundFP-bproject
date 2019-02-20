package fr.epita.datamodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Question.
 */
public class Question {

	// CREATE TABLE QUESTION(QUESTION VARCHAR(255) PRIMARY KEY,DIFFICULTY
	// INTEGER(10));

	/** The id. */
	private int id;

	/** The question. */
	private String question;

	/** The topics. */
	private String[] topics;

	/** The difficulty. */
	private int difficulty;

	/** The answer. */
	private Answer answer = null;

	/** The choices. */
	private List<MCQChoice> choices = new ArrayList();

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Gets the topics.
	 *
	 * @return the topics
	 */
	public String[] getTopics() {
		return topics;
	}

	/**
	 * Sets the topics.
	 *
	 * @param topics the new topics
	 */
	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	/**
	 * Gets the difficulty.
	 *
	 * @return the difficulty
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the difficulty.
	 *
	 * @param difficulty the new difficulty
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the answer.
	 *
	 * @return the answer
	 */
	public Answer getAnswer() {
		return answer;
	}

	/**
	 * Sets the answer.
	 *
	 * @param answer the new answer
	 */
	public void setAnswer(Answer answer) {
		this.answer = new Answer();
		this.answer = answer;
	}

	/**
	 * Gets the choices.
	 *
	 * @return the choices
	 */
	public List<MCQChoice> getChoices() {
		return choices;
	}

	/**
	 * Sets the choices.
	 *
	 * @param choices the new choices
	 */
	public void setChoices(List<MCQChoice> choices) {
		this.choices = choices;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", topics=" + Arrays.toString(topics) + ", difficulty="
				+ difficulty + ", answer=" + answer + ", choices=" + choices + "]";
	}

}
