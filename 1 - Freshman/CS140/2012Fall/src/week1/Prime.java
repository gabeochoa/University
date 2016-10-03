package week1;

public class Prime {
	private int value;
	private Prime next;

	public Prime(int newPrime) {
		value = newPrime;
	}

	public void addIfPrime(int n) {
		if(n > value && n % value != 0) { 
			if(next != null) {
				next.addIfPrime(n);
			} else {
				next = new Prime(n);
			}
		}
	}
	
	public long getValue() {
		return value;
	}

	public Prime getNext() {
		return next;
	}

	public String print() {
		String list = "" + value;
		if(next != null) {
			list += ", " + next.print();
		}
		return list;
	}
}
