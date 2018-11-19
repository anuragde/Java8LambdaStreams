package java8LamdaandStreams;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 0, 3, 4};
		int key = 5;
		
		process(nums, key, wrapperLambda((v, k) -> System.out.println(k / v)));
		
	}
	
	private static void process(int[] nums, int key, BiConsumer<Integer, Integer> consumer) {
		for(int i : nums) {
			consumer.accept(i, key);
		}
	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer){
		return (v, k) -> {
			try {
				consumer.accept(v, k);
			}
			catch(ArithmeticException e) {
				System.out.println("Exception caught in Wrapper Lambda");
			}
		};
	}
	
}
