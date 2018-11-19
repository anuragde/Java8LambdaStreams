package java8LamdaandStreams;

public class LambdaThisreference {
	private void doProcess(int i, Process p) {
		p.process(i);
	}
	public static void main(String[] args) {
		LambdaThisreference lambdaThisreference = new LambdaThisreference();
		
		lambdaThisreference.doProcess(10, new Process() {
			public void process(int i) {
				System.out.println(i);
				System.out.println(this);
			}
		});
		
		lambdaThisreference.doProcess(10, i -> {
			System.out.println("Value of i is " + i);
			//System.out.println(this);
		});
	}
}


