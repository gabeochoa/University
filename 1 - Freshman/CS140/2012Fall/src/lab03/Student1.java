package lab03;

import java.util.Arrays;

public class Student1
{

	    private String name;
	    private double[] quizGrades = new double[5];
	    private double[] temp;
	    private int nextQuizIndex;
	    
	    private GPA gpa;

	    public Student1(String name) {
	        this.name = name;
	    }
	    public void addQuiz(int n) {
	        
	    	
	    	if(nextQuizIndex >= quizGrades.length)
	    	{
	    		temp = new double[quizGrades.length * 2];
	    		System.arraycopy(quizGrades, 0, temp, 0, quizGrades.length);
	    		quizGrades = temp;
	    	}
	    	
	    	quizGrades[nextQuizIndex] = n;
	         nextQuizIndex++;         
	    }
	    
	    public double getAverage() {
	        double totalQuizGrade = 0.0;
	        
	        for(int i = 0; i < nextQuizIndex; i++) {
	           totalQuizGrade += quizGrades[i];
	        }
	        
	        return totalQuizGrade / nextQuizIndex;       
	    }
	    
	    public void printGrades()
	    {
	    	System.out.println(Arrays.toString(quizGrades));	
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public int getNumQuizzes() {
	        return nextQuizIndex;
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
	    
	    public double getMaximumGrade()
	    {
	    	double grade = 0.0;
	    	
	    	for(int i=0; i<quizGrades.length; i++)
	    	{
	    		if(grade <  quizGrades[i])
	    			grade = quizGrades[i];
	    	}
	    	
	    	return grade;
	    }
	    
	    public double getMinimumGrade()
	    {
	    	double grade = 100.0;
	    	
	    	for(int i=0; i<quizGrades.length; i++)
	    	{
	    		if(grade >  quizGrades[i])
	    			grade = quizGrades[i];
	    	}
	    	
	    	return grade;
	    }

}
