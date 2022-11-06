package lab3_ex1;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		boolean cnp_invalid = false;
		String nume, cnp=null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nume: ");
		nume = scanner.next();
		do {
			try {
				System.out.println("CNP: ");
				cnp = scanner.next();
				if(cnp.length()==13) {
					for( int i = 0; i < cnp.length(); i++) {
						if(!Character.isDigit(cnp.charAt(i))) {
							throw new CNP_Eronat("CNP-ul nu trebuie sa contina litere.");
						}
					}
				if(cnp.charAt(0) == '1' || cnp.charAt(0)=='2' || cnp.charAt(0)=='5' || cnp.charAt(0)=='6') {
					char[] an = {cnp.charAt(1), cnp.charAt(2)};
					String an_nastere = new String(an);
					Integer an_int = Integer.parseInt(an_nastere.trim());
					if(cnp.charAt(0) == '1' || cnp.charAt(0)=='2') {
						an_int += 1900;
					}
					else {
						an_int+=2000;
					}
					
					if(an_int >0 && an_int <= LocalDate.now().getYear()) {
						char[] luna = {cnp.charAt(3), cnp.charAt(4)};
						String luna_nastere = new String(luna);
						Integer luna_int = Integer.parseInt(luna_nastere.trim());
						
						if(luna_int > 0 && luna_int <=12) {
							char[] zi = {cnp.charAt(5), cnp.charAt(6)};
							String zi_nastere = new String(zi);
							Integer zi_int = Integer.parseInt(zi_nastere.trim());
								
								if(zi_int > 0 && zi_int<=31) {
									if(LocalDate.parse(an_int.toString()+"-"+luna_nastere+"-"+zi_nastere).compareTo(LocalDate.now())>0) {
										throw new CNP_Eronat("Data nu poate fi din viitor.");
									}
							}
								else {
									throw new CNP_Eronat("Zi invalida");
								}
						}
						else {
							throw new CNP_Eronat("Luna invalida.");
						}
						
					}
					else {
						throw new CNP_Eronat("An invalid");
					}
					
				}
				else {
					throw new CNP_Eronat("CNP-ul poate incepe cu cifrele 1,2,5 sau 6.");
				}
				}
				else {
					throw new CNP_Eronat("CNP-ul trebuie sa aiba 13 cifre.");
				}
				cnp_invalid = false;
			}
			catch(CNP_Eronat e) {
				cnp_invalid = true;
				System.out.println(e);
			}
		}while(cnp_invalid==true);
		scanner.close();
		
		Persoana p = new Persoana(nume, cnp);
		System.out.println("Varsta: " + p.getVarsta());
	}
}
