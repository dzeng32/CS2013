
public class RecursionOne {
	public static void main(String[] args) {
		
		double x = 2.0;
		int n = 4;
		double power = powerN(x, n);
		System.out.println(x + " to the " + n + " power is: " + power);
		
		int n2 = 4;
		double sum = sum(n2);
		System.out.println("Sum for n = " + n2 + " is: " + sum);
		
		int gcdm = 45;
		int gcdn = 15;
		int gcd = gcd(gcdm, gcdn);
		System.out.println("The greatest common divisor for gcd(" + gcdm + "," + gcdn + ") is: " + gcd);
	}
	
	public static double powerN(double x, int n) {
		if(n == 0)
			return 1;
		else
			return x * powerN(x, n - 1);
	}
	
	public static double sum(int n) {
		if(n == 1)
			return 1/2.0;
		else
			return n / (n + 1.0) + sum(n - 1);
	}
	
	public static int gcd(int m, int n) {
		if(m % n == 0)
			return n;
		else
			return gcd(n, m%n);
	}
}
