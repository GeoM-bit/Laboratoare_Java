package lab6;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

public class MainApp {

	public static void main(String[] args) {
		
		int optiune = 0;
		boolean optiune_invalida  = false;
		Vector<Banca> banci = new Vector<Banca>();
		
		Scanner scanner=new Scanner(System.in);

		do {
			System.out.println("1. Adaugare banca");
			System.out.println("2. Adaugare client");
			System.out.println("3. Adaugare cont");
			System.out.println("4. Afisarea datelor introduse");
			System.out.println("5. Afisarea denumirii bancilor introduse si a numarului de clienti pe care il are fiecare");
			System.out.println("6. Afisarea clientilor unei banci");
			System.out.println("7. Afisarea conturilor unui client la o banca specificata");
			System.out.println("8. Afisarea conturilor unui client, indiferent de banca");
			System.out.println("9. Depunerea unei sume intr-un cont");
			System.out.println("10. Extragerea unei sume dintr-un cont");
			System.out.println("11. Transfer de bani intre 2 conturi");
			System.out.println("12. Iesire");
			System.out.println("Introduceti optiunea: ");
		
			try {
				optiune = scanner.nextInt();
				scanner.nextLine();
				optiune_invalida = false;
				if(optiune<=0 || optiune>12 ) {
					throw new OptiuneInvalida();
				}
					
			}
			
			catch(OptiuneInvalida e) {
				optiune_invalida = true;
				System.out.println(e);
			}
			
			catch( InputMismatchException e) {
				optiune_invalida=true;
				System.out.println("Optiune invalida.");
				scanner.nextLine();
			}
			
			switch(optiune) {
			case 1->{
				System.out.println("Nume banca: ");
				var nume = scanner.next();
				Banca banca = new Banca(nume);
				banci.add(banca);

			}
			case 2->{
				System.out.println("Nume client: ");
				var nume = scanner.next();
				System.out.println("Adresa client: ");
				var adresa = scanner.next();
				System.out.println("Banca clientului: ");
				var banca = scanner.next();
				Client client = new Client(nume, adresa);
				for (Banca b : banci){
					if(b.getDenumire_banca().equals(banca)){
						b.adaugaClienti(client);
					}
				}
				
			}
			case 3->{
				System.out.println("Banca contului: ");
				var banca = scanner.next();
				System.out.println("Nume client: ");
				var nume = scanner.next();
				System.out.println("Numar cont: ");
				var numarCont = scanner.next();
				System.out.println("Suma: ");
				var suma = scanner.nextFloat();
				System.out.println("Moneda: ");
				System.out.println("1. RON");
				System.out.println("2. EUR");
				var opt = scanner.nextInt();
				Moneda moneda = switch(opt) {
				case 1-> Moneda.RON;
				case 2->Moneda.EUR;
				default -> throw new IllegalArgumentException("Unexpected value: " + opt);

				};

				System.out.println("Data deschiderii (formatul datei e AAAA-LL-ZZ) : ");
				var data = scanner.next();
				var data_deschiderii = LocalDate.parse(data);
				System.out.println("Data_ultimei_operatiuni (formatul datei e AAAA-LL-ZZ): ");
				var data_operatiune = scanner.next();
				var data_ultimei_operatiuni = LocalDate.parse(data_operatiune);
				ContBancar cont = new ContBancar(numarCont,suma,moneda,data_deschiderii, data_ultimei_operatiuni);
				for (Banca b : banci){
					if(b.getDenumire_banca().equals(banca)){
						for(Client c : b.getClienti()) {
							if(c.getNume().equals(nume)) {
								c.adaugaCont(cont);
							}
						}
					}
				}
				
			}
			case 4->{
				banci.forEach(System.out::println);
			}
			case 5->{
				banci
					.stream()
					.flatMap(e->Stream.of("Banca: " + e.getDenumire_banca() + "; ","Numar clienti: " + e.getClienti().size() + "\n"))
					.forEach(System.out::print);
			}
			case 6->{
				System.out.println("Dati numele bancii:");
				String nume = scanner.next();
				banci
					.stream()
					.filter(a->a.getDenumire_banca().equals(nume))
					.map(Banca::getClienti)
					.forEach(System.out::println);
			}
			case 7->{
				System.out.println("Dati numele bancii:");
				String nume_banca = scanner.next();
				System.out.println("Dati numele clientului:");
				String nume_client = scanner.next();
				
				banci
					.stream()
					.filter(a->a.getDenumire_banca().equals(nume_banca))
					.flatMap(b->b.getClienti()
							.stream()
							.filter(c->c.getNume().equals(nume_client))
							.map(c->c.getConturi())						
							)						
				.forEach(System.out::println);
			}
			case 8->{
				System.out.println("Dati numele clientului:");
				String nume_client = scanner.next();
				
				banci
					.stream()
					.flatMap(a->a.getClienti()
							.stream()
							.filter(b->b.getNume().equals(nume_client))
							.map(c->c.getConturi())
							)
					.forEach(System.out::println);
			}
			case 9->{
				System.out.println("Banca: ");
				String banca = scanner.next();
				System.out.println("Client: ");
				String client = scanner.next();
				System.out.println("Numar de cont: ");
				String nr_cont = scanner.next();
				System.out.println("Suma: ");
				float suma = scanner.nextFloat();
				
				for(Banca b : banci) {
					if(b.getDenumire_banca().equals(banca)) {
						for(Client c : b.getClienti()) {
							if(c.getNume().equals(client)) {
								for(ContBancar cb : c.getConturi()) {
									if(cb.getNumarCont().equals(nr_cont)) {
										cb.depunere(suma);
									}
								}
							}
						}
					}
				}
			}
			case 10->{
				System.out.println("Banca: ");
				String banca = scanner.next();
				System.out.println("Client: ");
				String client = scanner.next();
				System.out.println("Numar de cont: ");
				String nr_cont = scanner.next();
				System.out.println("Suma: ");
				float suma = scanner.nextFloat();
				
				for(Banca b : banci) {
					if(b.getDenumire_banca().equals(banca)) {
						for(Client c : b.getClienti()) {
							if(c.getNume().equals(client)) {
								for(ContBancar cb : c.getConturi()) {
									if(cb.getNumarCont().equals(nr_cont)) {
										cb.extragere(suma);
									}
								}
							}
						}
					}
				}
			}
			
			case 11->{
				System.out.println("Pentru contul din care se trimite: ");
				System.out.println("Banca: ");
				String banca = scanner.next();
				System.out.println("Client: ");
				String client = scanner.next();
				System.out.println("Numar de cont: ");
				String nr_cont = scanner.next();
				System.out.println("Suma: ");
				float suma = scanner.nextFloat();
				
				System.out.println("Pentru contul catre care se trimite: ");
				System.out.println("Banca: ");
				String banca1 = scanner.next();
				System.out.println("Client: ");
				String client1 = scanner.next();
				System.out.println("Numar de cont: ");
				String nr_cont1 = scanner.next();
				
				for(Banca b : banci) {
					if(b.getDenumire_banca().equals(banca)) {
						for(Client c : b.getClienti()) {
							if(c.getNume().equals(client)) {
								for(ContBancar cb : c.getConturi()) {
									if(cb.getNumarCont().equals(nr_cont)) {
										cb.extragere(suma);
									}
								}
							}
						}
					}
				}
				
				for(Banca b : banci) {
					if(b.getDenumire_banca().equals(banca1)) {
						for(Client c : b.getClienti()) {
							if(c.getNume().equals(client1)) {
								for(ContBancar cb : c.getConturi()) {
									if(cb.getNumarCont().equals(nr_cont1)) {
										cb.depunere(suma);
									}
								}
							}
						}
					}
				}
			}
			
			case 12->{
				break;
			}
			}
			
		}while(optiune!=12 || optiune_invalida);
		scanner.close();

	}	

}
