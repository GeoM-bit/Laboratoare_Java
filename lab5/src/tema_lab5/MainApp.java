package tema_lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;

public class MainApp {

	public static void main(String[] args) {
		
		int optiune;
		List<Angajat> lista_angajati = new ArrayList<Angajat>();
		
		do {
			System.out.println("Meniu:");
			System.out.println("1. Citirea angajatilor.");
			System.out.println("2. Afisarea colectiei.");
			System.out.println("3. Afisarea angajatilor cu salariu peste 2500 ron.");
			System.out.println("4. Crearea listei angajatilor cu functii de conducere.");
			System.out.println("5. Afisarea angajatilor fara functie de conducere.");
			System.out.println("6. Crearea listei cu numele angajatilor.");
			System.out.println("7. Afisarea salariilor mai mici de 3000 ron.");
			System.out.println("8. Iesire");
			System.out.println("Alegeti optiunea: ");
			
			Scanner scanner=new Scanner(System.in);
			optiune = scanner.nextInt();
			
			switch(optiune) {
				case 1->{
					lista_angajati = Citire();
				}
				case 2->{
					lista_angajati.forEach(System.out::println);
				}
				case 3->{
					lista_angajati
							.stream()
							.filter(a->a.getSalariu()>2500)
							.forEach(System.out::println);
					
					

				}
				case 4->{
					var colectie_angajati=lista_angajati
							.stream()
							.filter(a->a.getData_angajarii().getYear()==LocalDate.now().getYear() &&
										a.getData_angajarii().getMonth()==Month.APRIL &&
										(a.getPost().contains("sef") || a.getPost().contains("director")))
							.collect(Collectors.toList());
					colectie_angajati.forEach(System.out::println);

				}
				case 5->{
					var colectie_angajati=lista_angajati
							.stream()
							.filter(a->!(a.getPost().contains("sef") || a.getPost().contains("director")))
							.sorted((a,b)->((Float)b.getSalariu()).compareTo((Float)a.getSalariu()))
							.collect(Collectors.toList());
					colectie_angajati.forEach(System.out::println);
		
				}
				case 6->{
					List<String> nume_angajati = lista_angajati
							.stream()
                            .map(Angajat::getNume)
                            .map(String::toUpperCase)
                            .collect(Collectors.toList());
					nume_angajati.forEach(System.out::println);
				}
				case 7->{
							lista_angajati
							.stream()
							.filter(a->a.getSalariu()<2500)
							.map(Angajat::getSalariu)
							.collect(Collectors.toList())
							.forEach(System.out::println);
				}
				case 8->{
					scanner.close();
					break;
				}
			}
		}while(optiune!=8);
	}
	
	public static List<Angajat> Citire()
	{
		 
		List<Angajat> angajati = new ArrayList<Angajat>();
		
		try {
			BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in.txt")));
			String linie = flux_in.readLine();
			while(linie!= null)
			{
				String[] proprietati = linie.split(";");	
				String nume = proprietati[0];
				String post = proprietati[1];
				LocalDate data_angajarii = LocalDate.parse(proprietati[2]);
				float salariu = Float.valueOf(proprietati[3]);
				Angajat angajat = new Angajat(nume,post,data_angajarii,salariu);
				angajati.add(angajat);
				linie = flux_in.readLine();
			}
			flux_in.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return angajati;
	}
}




