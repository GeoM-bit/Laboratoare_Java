package lab6;

import java.util.HashSet;
import java.util.Set;

public class Client {
	private String nume;
	private String adresa;
	private Set<ContBancar> conturi;
	
	public Client(String nume, String adresa, Set<ContBancar> conturi) {
		super();
		this.nume = nume;
		this.adresa = adresa;
		this.conturi = conturi;
	}
	
	public Client(String nume, String adresa) {
		super();
		this.nume = nume;
		this.adresa = adresa;
		this.conturi = new HashSet<ContBancar>();
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Set<ContBancar> getConturi() {
		return conturi;
	}
	public void setConturi(Set<ContBancar> conturi) {
		this.conturi = conturi;
	}
	
	public void adaugaCont(ContBancar cont) {
		this.conturi.add(cont);
	}

	@Override
	public String toString() {
		return "\n\t\t[nume=" + nume + ", adresa=" + adresa + ",\n\t\t\t conturi=" + conturi + "]";
	}
	
	public void afisare()
	{
		System.out.println(this.toString());
	}

}
