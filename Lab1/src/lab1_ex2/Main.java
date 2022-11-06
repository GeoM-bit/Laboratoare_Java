package lab1_ex2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

	public static void main(String[] args) throws IOException {
		int suma=0, min=0, max=0, contor_numere=0;
		float ma=0;
		
		try {
			BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
			String linie = flux_in.readLine();
			int numar = Integer.parseInt(linie);
			min = numar;
			max = numar;
			
			while(linie!=null) {
				numar = Integer.parseInt(linie);
				suma += numar;
				contor_numere++;
				if(numar < min) {
					min = numar;
				}
				if(numar > max) {
					max = numar;
				}
				linie = flux_in.readLine();
			}
			if(contor_numere!=0) {
				ma=suma/contor_numere;
			}
			flux_in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Suma: " + suma);
		System.out.println("Media artimetica: " + ma);
		System.out.println("Minimul: " + min);
		System.out.println("Maximul: " + max);
		
		PrintStream flux_out = new PrintStream ("out.txt");
		flux_out.println("Suma: " + suma + "\nMedia artimetica: " + ma + "\nMinimul: " + min + "\nMaximul: " + max);
		flux_out.close();
	}

}
