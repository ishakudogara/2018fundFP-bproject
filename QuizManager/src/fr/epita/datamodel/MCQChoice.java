package fr.epita.datamodel;

// TODO: Auto-generated Javadoc
/**
 * The Class MCQChoice.
 */
public class MCQChoice {

	/** The question. */
	private MCQQuestion question;

	/** The choice. */
	private String choice;

	/** The valid. */
	private boolean valid;

	/**
	 * Gets the choice.
	 *
	 * @return the choice
	 */
	public String getChoice() {
		return choice;
	}

	/**
	 * Instantiates a new MCQ choice.
	 *
	 * @param question the question
	 * @param choice the choice
	 * @param valid the valid
	 */
	public MCQChoice(MCQQuestion question, String choice, boolean valid) {
		super();
		this.question = question;
		this.choice = choice;
		this.valid = valid;
	}

	/**
	 * Instantiates a new MCQ choice.
	 *
	 * @param choice the choice
	 * @param valid the valid
	 */
	public MCQChoice(String choice, boolean valid) {
		super();
		this.choice = choice;
		this.valid = valid;
	}

	/**
	 * Sets the choice.
	 *
	 * @param choice the new choice
	 */
	public void setChoice(String choice) {
		this.choice = choice;
	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * Sets the valid.
	 *
	 * @param valid the new valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public MCQQuestion getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(MCQQuestion question) {
		this.question = question;
	}

}
