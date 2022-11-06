package lab2_ex2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
		int i;
		List<Produs> produse = new ArrayList<Produs>();
		Produs produs_pret_min, produs_pret_max;
		
		String linie = flux_in.readLine();
		String[] atribute_produs1 = linie.split(";");
		float pret1 = Float.parseFloat(atribute_produs1[1]);
		float pret_min=pret1;
		float pret_max=pret1;
		
		while(linie!=null) {
			String[] atribute_produs = linie.split(";");
			String denumire = atribute_produs[0];
			float pret = Float.parseFloat(atribute_produs[1]);
			float cantitate = Float.parseFloat(atribute_produs[2]);
			Produs produs = new Produs(denumire, pret, cantitate);
			
			produse.add(produs);
			
			if(pret<pret_min) {
				pret_min = pret;
			}
			
			if(pret>pret_max) {
				pret_max = pret;
			}
			
			linie= flux_in.readLine();
		}
 
		final float min = pret_min;
		final float max = pret_max;
		
		produs_pret_min = 
			 produse
			.stream()
			.filter(a->a.getPret() == min)
            .findFirst()
            .get();
		
		produs_pret_max =
			produse
			.stream()
			.filter(a->a.getPret() == max)
	        .findFirst()
	        .get();
		
		PrintStream flux_out = new PrintStream("out.txt");
		flux_out.print("Denumire\tPret\tCantitate\n");
		produse.forEach(flux_out::println);
		flux_out.print("\nProdus cu pret minim: " + produs_pret_min.toString());
		flux_out.print("\nProdus cu pret maxim: " + produs_pret_max.toString());
		flux_out.close();
		
		System.out.println("Cantitate: ");
		Scanner scanner = new Scanner(System.in);
		int cantitate = scanner.nextInt();
		scanner.close();
		produse
			.stream()
			.filter(p->p.getCantitate()<cantitate)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}

}
