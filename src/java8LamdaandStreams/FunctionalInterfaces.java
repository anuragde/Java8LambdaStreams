package java8LamdaandStreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaces {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
									 new Person("Charles", "Dickens", 60),
									 new Person("Lewis", "Carroll", 42),
									 new Person("Thomas", "Carlyle", 51),
									 new Person("Charlotte", "Bronte", 45),
									 new Person("Matthew", "Arnold", 39)
									 );
		//Step 1. Sort list by first name

		Collections.sort(people, (person1, person2) -> 
									person1.firstName.compareTo(person2.firstName));
		
		//Step 2. Create a method that prints all elements in the list
		printConditionally(people, p -> true, p -> System.out.println(p));

		//Step 3. Create a method that prints people that have last name beginning with 'C'
		printConditionally(people, p ->  p.getLastName().startsWith("C"), p -> System.out.println(p));
				
		
	}
	
	private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p : people) {
			if(predicate.test(p)) {
					consumer.accept(p);			
					}
		}
	}
	
	

	
}
