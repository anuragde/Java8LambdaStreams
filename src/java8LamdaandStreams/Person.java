package java8LamdaandStreams;
public class Person {
	String firstName;
	private String lastName;
	private int age;
	
	public Person(String firstName, String lastName, int age) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
}
