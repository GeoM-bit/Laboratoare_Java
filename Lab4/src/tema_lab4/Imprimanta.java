package tema_lab4;

import java.io.Serializable;

import tema_lab4.enums.ModScriere;
import tema_lab4.enums.Stare;
import tema_lab4.enums.Tip;
import tema_lab4.enums.ZonaMagazin;

public class Imprimanta extends Echipament implements Serializable{
	
	private String rezolutie;
	private Integer p_car;
	private ModScriere modScriere;
	private Integer ppm;
	
	public Imprimanta(String denumire, Integer nr_inv, Float pret, ZonaMagazin zona_mag, Stare stare,
			Integer ppm, String rezolutie, Integer p_car, ModScriere modScriere ) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.rezolutie = rezolutie;
		this.p_car = p_car;
		this.modScriere = modScriere;
		this.ppm=ppm;
	}

	public Integer getPpm() {
		return ppm;
	}

	public void setPpm(Integer ppm) {
		this.ppm = ppm;
	}

	public String getRezolutie() {
		return rezolutie;
	}

	public void setRezolutie(String rezolutie) {
		this.rezolutie = rezolutie;
	}

	public Integer getP_car() {
		return p_car;
	}

	public void setP_car(Integer p_car) {
		this.p_car = p_car;
	}

	public ModScriere getModScriere() {
		return modScriere;
	}

	public void setModScriere(ModScriere modScriere) {
		this.modScriere = modScriere;
	}

	@Override
	public String toString() {
		return super.toString()+", " + ppm + ", " + rezolutie + ", " + p_car + ", " + modScriere;
	}
	
	public String scriereFisier() {
		return super.scriereFisier() + "imprimanta;" + ppm + ";" + rezolutie + ";" + p_car + ";" + modScriere;

	}
}
