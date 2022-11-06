package lab1_ex3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("n = ");
		int n = scanner.nextInt();
		scanner.close();
		int i,d=0;
		
		for(i = 2; i <= Math.sqrt(n); i++) {
			if(n % i==0) {
				d++;
				System.out.println(i);
			}
		}
		if(d==0) {
			System.out.println("Numarul " + n + " este prim.");
		}
	}

}
