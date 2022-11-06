package lab1_ex1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double perimetru, aria, lungime, latime;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Lungime: ");
		lungime = scanner.nextDouble();
		
		System.out.println("Latime: ");
		latime = scanner.nextDouble();
		
		perimetru = 2 * (latime + lungime);
		aria = lungime * latime;
		
		System.out.println("Perimetru: " + perimetru + "\n" + "Aria: " + aria);
		scanner.close();
	}

}
