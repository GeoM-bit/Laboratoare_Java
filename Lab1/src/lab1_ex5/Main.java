package lab1_ex5;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		int n = random.nextInt(0, 20);
		System.out.println("n = " + n);
		if(fibonacci(n)) {
			System.out.println("Numarul " + n + " face parte din sirul lui Fibonacci.");
		}
		else { 
			System.out.println("Numarul " + n + " NU face parte din sirul lui Fibonacci.");
		}

	}
	
	public static boolean patratPerfect(int x)
	{
	    int s = (int)Math.sqrt(x);
	    return (s * s == x);
	}
	
	public static boolean fibonacci(int n)
	{
	    return patratPerfect(5 * n * n + 4)
	           || patratPerfect(5 * n * n - 4);
	}

}
