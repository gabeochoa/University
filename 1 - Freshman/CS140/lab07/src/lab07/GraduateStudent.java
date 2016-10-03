package lab07;

public class GraduateStudent extends Student{
	private String undergradMajor;
	
	public GraduateStudent(Person self, String bNum, String undergradMajor){
		super(self, bNum);
		this.undergradMajor = undergradMajor;
	}
	
	public String getUGMajor(){
		return undergradMajor;
	}

}
