package lab02;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//@author Gabriel Ochoa

public class DOB
{

	private Date date;
	
	public DOB(int year, int month, int day, int hour, int minute)
	{
		date = new GregorianCalendar(year, month, day, hour, minute).getTime();
	}
	
	public int getAge() {
        long ageInMillis = new Date().getTime() - date.getTime();

        Date age = new Date(ageInMillis);

        //return age.getYear();
        Calendar now = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(date);
        int years = now.get(Calendar.YEAR);
        int birthYear = birth.get(Calendar.YEAR);
        
        return years - birthYear;
	}


	   public  static  int  getAge ( Date  dateOfBirth )  { 
		   
	       Calendar  today  =  Calendar.getInstance (); 
	       Calendar  birthDate  =  Calendar.getInstance (); 
	  
	       int  age  =  0 ; 
	  
	      birthDate.setTime( dateOfBirth ); 
	       if  ( birthDate.after(today))  { 
	           throw  new  IllegalArgumentException ( "Can't be born in the future" ); 
	       } 
	  
	      age  =  today.get( Calendar.YEAR ) - birthDate.get(Calendar.YEAR ); 
	  
	       // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year    
	       if  (  ( birthDate.get( Calendar.DAY_OF_YEAR )  -  today.get(Calendar.DAY_OF_YEAR )  >  3 )  || 
	               ( birthDate.get( Calendar.MONTH )  >  today.get( Calendar.MONTH  ))){ 
	          age --; 
	  
	        // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age 
	       } else  if  (( birthDate.get(Calendar.MONTH )  ==  today.get(Calendar.MONTH  ))  && 
	                 ( birthDate.get(Calendar.DAY_OF_MONTH )  >  today.get(Calendar.DAY_OF_MONTH  ))){ 
	          age --; 
	       } 
	  
	       return  age ; } 

	public static void main(String[] args)
	{
		DOB test = new DOB(1990,12,21,6,18);
		System.out.println(getAge(test.date));
		System.out.println(test.getAge());
		
		test = new DOB(1990,12,31,6,18);
		System.out.println("\n"+getAge(test.date));
		System.out.println(test.getAge());
		
		test = new DOB(1990,2,29,6,18);
		System.out.println("\n"+getAge(test.date));
		System.out.println(test.getAge());
		
		test = new DOB(1990,1,1,6,18);
		System.out.println("\n"+getAge(test.date));
		System.out.println(test.getAge());
		
	}

}
