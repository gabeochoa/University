package week1;

public class PrimeDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Prime headOfList = new Prime(2);
		int testElement = 44819;
		for(int i = 3; i <= testElement; i++) {
			headOfList.addIfPrime(i);
		}
		System.out.println(headOfList.print());
		System.out.println("Last element:");
		Prime temp = headOfList;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		System.out.println(temp.getValue());
		if(testElement == temp.getValue()) {
			System.out.println(testElement + " is a prime number");
		}
	}

}
