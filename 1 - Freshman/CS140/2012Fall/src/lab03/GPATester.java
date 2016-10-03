package lab03;
//Gabriel Ochoa

public class GPATester
{

	public static void main(String[] args)
	{
		GPA g = new GPA( 91.7,100);

		System.out.println(g.get4PointValue());
		System.out.println(g.getLetterValue());
		
		g = new GPA(20.5,30);

		System.out.println(g.get4PointValue());
		System.out.println(g.getLetterValue());
	}

}
