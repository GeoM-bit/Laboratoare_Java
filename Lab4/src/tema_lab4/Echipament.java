package tema_lab4;

import java.io.Serializable;

import tema_lab4.enums.Stare;
import tema_lab4.enums.Tip;
import tema_lab4.enums.ZonaMagazin;

public class Echipament implements Serializable{
	private String denumire;
	private Integer nr_inv;
	private Float pret;
	private ZonaMagazin zona_mag;
	private Stare stare;
	
	public Echipament(String denumire, Integer nr_inv, Float pret, ZonaMagazin zona_mag, Stare stare) {
		super();
		this.denumire = denumire;
		this.nr_inv = nr_inv;
		this.pret = pret;
		this.zona_mag = zona_mag;
		this.stare = stare;
	}
	
	public Integer getNr_inv() {
		return nr_inv;
	}

	public void setNr_inv(Integer nr_inv) {
		this.nr_inv = nr_inv;
	}

	public Float getPret() {
		return pret;
	}

	public void setPret(Float pret) {
		this.pret = pret;
	}

	public ZonaMagazin getZona_mag() {
		return zona_mag;
	}

	public void setZona_mag(ZonaMagazin zona_mag) {
		this.zona_mag = zona_mag;
	}

	public Stare getStare() {
		return stare;
	}

	public void setStare(Stare stare) {
		this.stare = stare;
	}


	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	@Override
	public String toString() {
		return denumire + ", " + nr_inv + ", " + pret + ", " + zona_mag + ", " + stare;
	}
	
	public String scriereFisier() {
		return denumire + ";" + nr_inv + ";" + pret + ";" + zona_mag + ";" + stare + ";";
	}
}
