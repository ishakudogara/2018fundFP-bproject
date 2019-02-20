package fr.epita.datamodel;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Exam.
 */
public class Exam {
	
	/** The list answers. */
	private List<Answer> listAnswers;
	
	/** The list MCQ answers. */
	private List<MCQAnswer> listMCQAnswers;
	
	/** The grade. */
	private long grade;

	/** The student. */
	private Student student;
	
	/** The quiz. */
	private Quiz quiz;

	/**
	 * Gets the list answers.
	 *
	 * @return the list answers
	 */
	public List<Answer> getListAnswers() {
		return listAnswers;
	}

	/**
	 * Sets the list answers.
	 *
	 * @param listAnswers the new list answers
	 */
	public void setListAnswers(List<Answer> listAnswers) {
		this.listAnswers = listAnswers;
	}

	/**
	 * Gets the list MCQ answers.
	 *
	 * @return the list MCQ answers
	 */
	public List<MCQAnswer> getListMCQAnswers() {
		return listMCQAnswers;
	}

	/**
	 * Sets the list MCQ answers.
	 *
	 * @param listMCQAnswers the new list MCQ answers
	 */
	public void setListMCQAnswers(List<MCQAnswer> listMCQAnswers) {
		this.listMCQAnswers = listMCQAnswers;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public long getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(long grade) {
		this.grade = grade;
	}

	/**
	 * Gets the student.
	 *
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * Sets the student.
	 *
	 * @param student the new student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * Gets the quiz.
	 *
	 * @return the quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}

	/**
	 * Sets the quiz.
	 *
	 * @param quiz the new quiz
	 */
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	
}
