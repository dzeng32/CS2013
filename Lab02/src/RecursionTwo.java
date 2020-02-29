
public class RecursionTwo {
	
	public static void main(String[] args) {
		
		reverseDisplay(123);
		System.out.println();
		
		reverseDisplay("a");
		System.out.println();
		
		reverseDisplay("abc");
		System.out.println();
		
	}
	
	public static void reverseDisplay(int value) {
		if(value < 10) 
			System.out.print( value );
		else {
			System.out.print(value % 10);
			reverseDisplay(value / 10);
		}
	}
	
	public static void reverseDisplay(String value) {
		if(value.length() == 1)
			System.out.print(value);
		else {
			System.out.print(value.charAt(value.length() - 1));
			reverseDisplay(value.substring(0, value.length() - 1));
		}
	}
	
	public static void permutation(String value) {
		
	}
}
