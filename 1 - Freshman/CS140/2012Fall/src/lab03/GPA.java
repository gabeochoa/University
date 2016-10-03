package lab03;
//Gabriel Ochoa

public class GPA
{

	private double percentage;
	
	public GPA(double score, double maxScore)
	{
		if(maxScore <= 0) {
			  throw new IllegalArgumentException("The maximum score must be positive.");
			}
		
		percentage = score/maxScore * 100;
	}
	
	
	public double get4PointValue()
	{
		double point = 0.0;
		
		point = (percentage * 4.0)/ 100.0;
		
		point = (Math.round(point*1000)/1000.0);
		
		return point;
	}
	
	
	public String getLetterValue()
	{
		String letter = "F";
		
		if(percentage >= 92.5)
			letter = "A";
		else if(percentage >= 90.0)
			letter = "A-";
		else if(percentage >= 87.5)
			letter = "B+";
		else if(percentage >= 82.5)
			letter = "B";
		else if(percentage >= 80.0)
			letter = "B-";
		else if(percentage >= 77.5)
			letter = "C+";
		else if(percentage >= 72.5)
			letter = "C";
		else if(percentage >= 70.0)
			letter = "C-";
		else if(percentage >= 65.0)
			letter = "D";
		else
			letter = "F";
	
			
		return letter;
	}
	
}
