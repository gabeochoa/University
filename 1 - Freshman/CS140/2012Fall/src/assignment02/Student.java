package assignment02;

//@author Gabriel Ochoa
//09/07/2012
//CS 140

public class Student {

	private String name;
	private double quizScore;
	private int numberOfQuizzes;
	private DOB dob;
	
	public Student(String name, DOB d, double quizScore)
	{
		this.name = name;
		this.dob = d;
		this.quizScore = quizScore;
		this.numberOfQuizzes = 1;
	}

	public double getTotalScore() {
		return quizScore;
	}

	public String printDateTime()
	{
		return dob.printDateTime();
	}
	public double getAverageScore() {
		return (quizScore/numberOfQuizzes);
	}
	
	public void addQuiz(double score)
	{
		numberOfQuizzes++;
		quizScore +=score;
	}

	public String getName() {
		return name;
	}
}
