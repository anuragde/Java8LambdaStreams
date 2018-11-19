package java8LamdaandStreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(
				 new Person("Charles", "Dickens", 60),
				 new Person("Lewis", "Carroll", 42),
				 new Person("Thomas", "Carlyle", 51),
				 new Person("Charlotte", "Bronte", 45),
				 new Person("Matthew", "Arnold", 39)
				 );
		
		
		//for each example
		people.stream()
				.filter(p -> p.getLastName().startsWith("C"))
				.forEach(p -> System.out.println(p.firstName));
		
		//count example with parallel stream
		long count = people.parallelStream()
				.filter(p -> p.getLastName().startsWith("D"))
				.count();
		System.out.println(count);
		
		practiceStreams();
		
	}
	
	static void practiceStreams() {	
		Stream<Long> stream = Stream.of(4L);
		stream.forEach(System.out::println);
		
		//Flat map example
		List<Integer> primeNumbers = Arrays.asList(5, 7, 11,13); 
        
        // Creating a list of Odd Numbers 
        List<Integer> oddNumbers = Arrays.asList(1, 3, 5); 
          
        // Creating a list of Even Numbers 
        List<Integer> evenNumbers = Arrays.asList(2, 4, 6, 8); 
        
        List<List<Integer>> listOfListofInts = 
                Arrays.asList(primeNumbers, oddNumbers, evenNumbers); 
  
        System.out.println("The Structure before flattening is : " + listOfListofInts);
		
        List<Integer> listOfInts = listOfListofInts.stream()
        							.flatMap(list -> list.stream())
        							.collect(Collectors.toList());
        
        System.out.println("The Structure after flattening is : " + listOfInts);
        
        //Int Stream
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
       
        System.out.println();

        
        //
        String[] names = {"AI", "Ankit", "Kushal", "Brent", "Hans"};
        Arrays.stream(names)
        		.filter(x -> x.startsWith("A"))
        		.map(String::toLowerCase)
        		.sorted()
        		.forEach(System.out::println);
        
        System.out.println();
        
        
        //reading stream from files
        try {
			Stream<String> bands = Files.lines(Paths.get("bands.txt"));
			bands.sorted()
				  .filter(x -> x.length() > 13)
				  .forEach(System.out::println);
			bands.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
        				.reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);
        
        //Summary Statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
        											.summaryStatistics();
        System.out.println(summary);
        }
	
	
	}
