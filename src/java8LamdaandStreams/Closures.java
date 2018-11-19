package java8LamdaandStreams;

public class Closures {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		doProcess(a, (i) -> System.out.println(i + b));
		//b = 30;
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
}

interface Process{
	void process(int i);
}