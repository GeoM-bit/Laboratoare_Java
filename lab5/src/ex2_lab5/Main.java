package ex2_lab5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tema_lab5.Angajat;

public class Main {

	public static void main(String[] args) {
		Map<Integer,Carte> map=new HashMap<Integer,Carte>();
		
		map = Citire();
		
		var entryset=map.entrySet();
		var it=entryset.iterator();
		
		while(it.hasNext())
		{
			var m =it.next();
			Integer key=m.getKey();
			Carte value = m.getValue();
			System.out.println("Cheie :"+key+" Valoare :"+value.toString());
		}
		System.out.println("---------------------------------------------------------");
		
		List<Carte> carti = map.values()
				.stream()
				.collect(Collectors.toList());
		carti.forEach(System.out::println);
		System.out.println("---------------------------------------------------------");
				
		carti
		.stream()
		.sorted((a,b)->a.getTitlu().compareToIgnoreCase(b.getTitlu()))
		.forEachOrdered(System.out::println);
		
		}
	
		
	
	public static Map<Integer,Carte> Citire()
	{
		Map<Integer,Carte> map = new HashMap<Integer,Carte>();
		
		try (BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("in2.txt")))){
			String linie = flux_in.readLine();
			while(linie!= null)
			{
				String[] proprietati = linie.split(";");	
				Integer id = Integer.parseInt(proprietati[0]);
				String titlu = proprietati[1];
				String autor = proprietati[2];
				Integer anul_aparitiei = Integer.parseInt(proprietati[3]);
				Carte carte = new Carte(titlu, autor, anul_aparitiei);
				map.put(id, carte);
				linie = flux_in.readLine();
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return map;
	}

}
