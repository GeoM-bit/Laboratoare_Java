package lab1_ex4;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		int nr1 = random.nextInt(30);
		int nr2 = random.nextInt(30);
		
		System.out.println("Nr1: " + nr1);
		System.out.println("Nr2: " + nr2);

		while(nr2 != 0) {
			int rest = nr1 % nr2;
			nr1 = nr2;
			nr2 = rest;
		}
		
		System.out.println("Cmmdc: " + nr1);
	}

}
