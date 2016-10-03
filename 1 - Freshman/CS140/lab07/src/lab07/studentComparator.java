package lab07;

import java.util.Comparator;

public class studentComparator implements Comparator<Student> {
	
	public int compare(Student arg0, Student arg1){
		
		int returnVal = 0;
		
		if((arg0 instanceof GraduateStudent) && (arg1 instanceof GraduateStudent)){	
			returnVal = 0;
		} else if (!(arg0 instanceof GraduateStudent) && (arg1 instanceof GraduateStudent)){
			returnVal = -1;
		} else if ((arg0 instanceof GraduateStudent) && !(arg1 instanceof GraduateStudent)){
			returnVal = 1;
		} 
		
		if(returnVal == 0){
			String major1 = arg0.getMajor();
			String major2 = arg1.getMajor();
			int compMajor = major1.compareToIgnoreCase(major2);
			if(compMajor == 0){
				String name1 = ((Student) arg0).getPerson().toString();
				String name2 = ((Student) arg1).getPerson().toString();
				int compName = name1.compareToIgnoreCase(name2);
				if(compName == 0){
					returnVal = 0;
				} else if (compName > 0){
					returnVal = 1;
				} else if (compName < 0){
					returnVal = -1;
				}
			} 
		}
		
		return returnVal;
	}
}
