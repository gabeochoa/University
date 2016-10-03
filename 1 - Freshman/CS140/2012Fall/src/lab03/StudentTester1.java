package lab03;
//Gabriel Ochoa
public class StudentTester1
{

	
	public static void main(String[] args)
	{
		Student1 John = new Student1("John");

		John.addQuiz(75);
		John.addQuiz(80);
		John.addQuiz(64);
		John.addQuiz(56);
		John.addQuiz(100);
		
		John.addQuiz(45);
		John.addQuiz(92);
		John.addQuiz(54);
		John.addQuiz(76);
		John.addQuiz(80);
		
		John.addQuiz(100);
		John.addQuiz(15);
		John.addQuiz(83);
		John.addQuiz(64);
		John.addQuiz(46);

		System.out.println(John.getName());
		System.out.println(John.getAverage());
		System.out.println(John.get4PointValue());
		System.out.println(John.getLetterGPAValue());

		John.printGrades();
		System.out.println(John.getMaximumGrade());
		System.out.println(John.getMinimumGrade());
	}

}
