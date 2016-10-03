package lab03;
//Gabriel Ochoa
public class Student
{

	    private String name;
	    private double totalQuizGrade;
	    private int numQuizzes;
	    private double maxQuizGrade;
	    
	    private GPA gpa;

	    public Student(String name) {
	        this.name = name;
	    }
	    public void addQuiz(int n, int max) {
	    	totalQuizGrade += n;
	    	maxQuizGrade += max;
	         numQuizzes++;
	    }
	    public double getAverage() {
	        double returnVal = 0;
	        if(numQuizzes > 0) {
	             returnVal = totalQuizGrade / numQuizzes;
	        }
	        return returnVal;       
	    }
	    public String getName() {
	        return name;
	    }
	    public double getTotalQuizGrade() {
	        return totalQuizGrade;
	    }
	    public int getNumQuizzes() {
	        return numQuizzes;
	    }
	    
	    public String getLetterGPAValue()
	    {
	    	gpa = new GPA(getAverage(), 100);
	    	return gpa.getLetterValue();
	    }
	    
	    public double get4PointValue()
	    {
	    	gpa = new GPA(getAverage(), 100);
	    	return gpa.get4PointValue();
	    }

}

