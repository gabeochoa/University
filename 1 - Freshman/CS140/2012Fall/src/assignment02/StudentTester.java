package assignment02;

//@author Gabriel Ochoa
//09/07/2012
//CS 140

public class StudentTester {

	public static void main(String args[])
	{
		//Create Student object
		Student johnSmith = new Student("John Smith",  new DOB(1990,12,21,6,18), 91.5);
		
		//Print score
		System.out.println("\nTotal Score for "+johnSmith.getName()+" : "+johnSmith.getTotalScore());
		System.out.println("Average Score for "+johnSmith.getName()+" : "+johnSmith.getAverageScore());
		
		//Add a quiz
		johnSmith.addQuiz(68.6);
		
		//print again
		System.out.println("\nTotal Score for "+johnSmith.getName()+" : "+johnSmith.getTotalScore());
		System.out.println("Average Score for "+johnSmith.getName()+" : "+johnSmith.getAverageScore());
		
		//add another quiz
		johnSmith.addQuiz(82.6);
		
		//print again
		System.out.println("\nTotal Score for "+johnSmith.getName()+" : "+johnSmith.getTotalScore());
		System.out.println("Average Score for "+johnSmith.getName()+" : "+johnSmith.getAverageScore());
		
		
	}
}
