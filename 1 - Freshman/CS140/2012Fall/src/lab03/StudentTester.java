package lab03;
//Gabriel Ochoa
public class StudentTester
{

	
	public static void main(String[] args)
	{
		Student John = new Student("John");

		John.addQuiz(75,100);
		John.addQuiz(80,100);
		John.addQuiz(64,100);
		John.addQuiz(56,100);
		John.addQuiz(99,100);

		System.out.println(John.getName());
		System.out.println(John.getAverage());
		System.out.println(John.get4PointValue());
		System.out.println(John.getLetterGPAValue());
		
	}

}
