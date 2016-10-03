package lab07;

public class Person implements Comparable<Person>{
    private String firstNames;
    private String lastNames;

    public Person(String firstNames, String lastNames) {
        this.firstNames = firstNames;
        this.lastNames = lastNames;
    }
    public int compareTo(Person arg) {
        String thisFullName = lastNames + firstNames;
        String otherFullName= arg.lastNames + arg.firstNames;

        return thisFullName.compareToIgnoreCase(otherFullName);
    }
}
