package lab07;

public class Student implements Comparable<Student> {
    private Person self;
    private String bNumber;
    private String major;
    
    public Student(Person self, String bNum) {
        this.self = self;
        bNumber = bNum;
    }
    
    public void setMajor(String major){
    	 this.major = major;
    }
    
    public String getMajor(){
    	return major;
    }
    
    public Person getPerson(){
    	return self;
    }

    public int compareTo(Student arg) {
        return self.compareTo(arg.self);
    }
}