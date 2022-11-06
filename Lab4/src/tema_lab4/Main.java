package tema_lab4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tema_lab4.enums.ModScriere;
import tema_lab4.enums.Stare;
import tema_lab4.enums.Tip;
import tema_lab4.enums.ZonaMagazin;
import tema_lab4.enums.Format;
import tema_lab4.enums.InstallOS;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader flux_in;
		List<Echipament> echipamente = new ArrayList<Echipament>();
		try {
			flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("echipamente.txt")));
			 String linie = flux_in.readLine();
			while(linie!= null)
			{				
				String[] element = linie.split(";");	
				
				String denumire = element[0];
				Integer nr_inv = Integer.parseInt(element[1]);
				Float pret = Float.parseFloat(element[2]);
				ZonaMagazin zona_mag = ZonaMagazin.valueOf(element[3]);
				Stare stare = Stare.valueOf(element[4]);
				Tip tip = Tip.valueOf(element[5]);
				
				switch(tip) {
				case imprimanta->
				{
					Integer ppm = Integer.parseInt(element[6]);
					String rezolutie = element[7];
					Integer p_car = Integer.parseInt(element[8]);
					ModScriere modScriere = ModScriere.valueOf(element[9]);
					Imprimanta imprimanta = new Imprimanta(denumire,nr_inv,pret,zona_mag,stare,ppm,rezolutie,p_car,modScriere);
					echipamente.add(imprimanta);
				}
				case copiator->
				{
					Integer ppm = Integer.parseInt(element[6]);
					Integer p_ton = Integer.parseInt(element[7]);
					Format format = Format.valueOf(element[8]);
					Copiator copiator = new Copiator(denumire,nr_inv,pret,zona_mag,stare,ppm,p_ton,format);
					echipamente.add(copiator);
				}
				case sistem_de_calcul->
				{
					String tip_mon = element[6];
					Float vit_proc = Float.parseFloat(element[7]);
					Integer c_hdd = Integer.parseInt(element[8]);
					InstallOS install = InstallOS.valueOf(element[9]);
					SistemCalcul sistem = new SistemCalcul(denumire,nr_inv,pret,zona_mag,stare,tip_mon,vit_proc,c_hdd,install);
					echipamente.add(sistem);
				}
				}
				
				linie = flux_in.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner scanner=new Scanner(System.in);
		int optiune;
		
		do {
		System.out.println("Meniu:");
		System.out.println("1. Afisarea imprimantelor.");
		System.out.println("2. Afisarea copiatoarelor.");
		System.out.println("3. Afisarea sistemelor de calcul.");
		System.out.println("4. Modificarea starii in care se afla un echipament.");
		System.out.println("5. Setarea unui anumit mod de scriere pentru o imprimanta.");
		System.out.println("6. Setarea unui format de copiere pentru copiatoare.");
		System.out.println("7. Instalarea unui anumit sistem de operare pe un sistem de calcul.");
		System.out.println("8. Afisarea echipamentelor vandute");
		System.out.println("9. Serializare");
		System.out.println("10. Deserializare");
		System.out.println("11. Iesire");
		System.out.println("Alegeti optiunea: ");
		optiune = scanner.nextInt();

		int nr_imprimante=0, nr_copiatoare=0, nr_sisteme= 0;
		boolean gasit;
		
		switch(optiune) {
		case 1->{
			System.out.println("Imprimante:" );
			for (Echipament p : echipamente)
			{
				if(p.getClass().toString().equals("class tema_lab4.Imprimanta"))
				{
					nr_imprimante++;
					System.out.print(nr_imprimante + ". ");
					System.out.println(p);
				}
			}
		}
		case 2->
		{
			System.out.println("Copiatoare:");
			for (Echipament p : echipamente)
			{
				if(p.getClass().toString().equals("class tema_lab4.Copiator")){
					nr_copiatoare++;
					System.out.print(nr_copiatoare + ". ");
					System.out.println(p);
				}
			}
		}
		case 3->{
			System.out.println("Sisteme de calcul:");
			for (Echipament p : echipamente)
			{
				if(p.getClass().toString().equals("class tema_lab4.SistemCalcul")) {
					nr_sisteme++;
					System.out.print(nr_sisteme + ". ");
					System.out.println(p);
				}
			}
		}
		case 4->{
			Stare stare;
			int nr_inventar, opt;
			gasit=false;
			System.out.println("Numarul de inventar al echipamentului ce va fi modificat: ");
			nr_inventar = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Noua stare: ");
			System.out.println("1. Achizitionat");
			System.out.println("2. Expus");
			System.out.println("3. Vandut");
			opt = scanner.nextInt();
			stare = switch(opt) {
			case 1 -> Stare.achizitionat;
			case 2-> Stare.expus;
			case 3-> Stare.vandut;
			default -> throw new IllegalArgumentException("Unexpected value: " + opt);
			};
			for(Echipament p : echipamente) {
				if(p.getNr_inv() == nr_inventar) {
					p.setStare(stare);
					gasit = true;
					break;
				}
			}
			
			PrintStream flux = new PrintStream("echipamente.txt");
			for(Echipament p : echipamente) {
				flux.println(p.scriereFisier());
			}
			if(!gasit) {
				System.out.println("Echipamentul nu a fost gasit.");
			}
		}
		case 5->{
			ModScriere scriere;
			int nr_inventar, opt;
			gasit=false;
			System.out.println("Numarul de inventar al imprimantei ce va fi modificata: ");
			nr_inventar = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Noul mod de scriere: ");
			System.out.println("1. Color");
			System.out.println("2. Alb-negru");
			opt = scanner.nextInt();
			scriere = switch(opt) {
			case 1 -> ModScriere.color;
			case 2-> ModScriere.albNegru;
			default -> throw new IllegalArgumentException("Unexpected value: " + opt);
			};
			for(Echipament p : echipamente) {
				if(p.getNr_inv() == nr_inventar) {
					if(p.getClass().toString().equals("class tema_lab4.Imprimanta")) {
						((Imprimanta)p).setModScriere(scriere);
						gasit = true;
						break;
					}
				}
			}
			
			PrintStream flux = new PrintStream("echipamente.txt");
			for(Echipament p : echipamente) {
				flux.println(p.scriereFisier());
			}
			if(!gasit) {
				System.out.println("Echipamentul nu a fost gasit.");
			}
		}
			
		case 6->{
			Format format;
			int nr_inventar, opt;
			gasit=false;
			System.out.println("Numarul de inventar al copiatorului ce va fi modificat: ");
			nr_inventar = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Noul mod de scriere: ");
			System.out.println("1. A3");
			System.out.println("2. A4");
			opt = scanner.nextInt();
			format = switch(opt) {
			case 1 -> Format.A3;
			case 2-> Format.A4;
			default -> throw new IllegalArgumentException("Unexpected value: " + opt);
			};
			for(Echipament p : echipamente) {
				if(p.getNr_inv() == nr_inventar) {
					if(p.getClass().toString().equals("class tema_lab4.Copiator")) {
						((Copiator)p).setFormat(format);
						gasit = true;
						break;
					}
				}
			}
			
			PrintStream flux = new PrintStream("echipamente.txt");
			for(Echipament p : echipamente) {
				flux.println(p.scriereFisier());
			}
			if(!gasit) {
				System.out.println("Echipamentul nu a fost gasit.");
			}
			
		}
		case 7->{
			InstallOS os;
			int nr_inventar, opt;
			gasit=false;
			System.out.println("Numarul de inventar al sistemului de calcul ce va fi modificat: ");
			nr_inventar = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Noul sistem de operare: ");
			System.out.println("1. Windows");
			System.out.println("2. Linux");
			opt = scanner.nextInt();
			os = switch(opt) {
			case 1 -> InstallOS.windows;
			case 2-> InstallOS.linux;
			default -> throw new IllegalArgumentException("Unexpected value: " + opt);
			};
			for(Echipament p : echipamente) {
				if(p.getNr_inv() == nr_inventar) {
					if(p.getClass().toString().equals("class tema_lab4.SistemCalcul")) {
						((SistemCalcul)p).setInstall(os);;
						gasit = true;
						break;
					}
				}
			}
			
			PrintStream flux = new PrintStream("echipamente.txt");
			for(Echipament p : echipamente) {
				flux.println(p.scriereFisier());
			}
			if(!gasit) {
				System.out.println("Echipamentul nu a fost gasit.");
			}
			
		}
		case 8->{
			System.out.println("Echipamente vandute: ");
			for(Echipament e : echipamente) {
				if(e.getStare().equals(Stare.vandut)) {
					System.out.println(e.toString());
				}
			}
		}
		
		case 9 ->{
			scrie(echipamente, "echip.bin");
		}
		
		case 10->{
			List<Echipament> q= (List<Echipament>) citeste("echip.bin");
			for(Echipament p : q)
				System.out.println(p);
		}
		
		case 11->{
			scanner.close();
			break;
		}

	}
	}while(optiune!=11);
}
	
	static void scrie(Object o, String fis) {
		try {
			FileOutputStream f = new FileOutputStream(fis);
			ObjectOutputStream oos = new ObjectOutputStream(f);
			oos.writeObject(o);
			oos.close();
			f.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object citeste(String fis) {
		try {
			FileInputStream f = new FileInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(f);
			Object o=ois.readObject();
			ois.close();
			f.close();
			return o;
		}
		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}