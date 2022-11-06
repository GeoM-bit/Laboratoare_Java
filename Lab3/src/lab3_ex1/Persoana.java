package lab3_ex1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoana {
	private String nume;
	private String cnp;
	
	public Persoana(String nume, String cnp) {
		super();
		this.nume = nume;
		this.cnp = cnp;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	
	public int getVarsta() {
		char[] an = {cnp.charAt(1), cnp.charAt(2)};
		String an_nastere = new String(an);
		Integer an_int = Integer.parseInt(an_nastere.trim());
		if(cnp.charAt(0) == '1' || cnp.charAt(0)=='2') {
			an_int += 1900;
		}
		else {
			an_int+=2000;
		}
		char[] luna = {cnp.charAt(3), cnp.charAt(4)};
		String luna_nastere = new String(luna);		
		char[] zi = {cnp.charAt(5), cnp.charAt(6)};
		String zi_nastere = new String(zi);
		LocalDate data_nasterii = LocalDate.parse(an_int.toString() + "-" + luna_nastere + "-" + zi_nastere);
		int ani = (int) ChronoUnit.YEARS.between(data_nasterii, LocalDate.now());
		return ani;
	}
}
