package java8LamdaandStreams;

public class MethodReferences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(MethodReferences::printMessage);	
		t.start();
	}
	
	public static void 	printMessage() {
		System.out.println("Hello World");
	}
}
