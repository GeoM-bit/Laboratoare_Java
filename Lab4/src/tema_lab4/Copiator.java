package tema_lab4;

import java.io.Serializable;

import tema_lab4.enums.Format;
import tema_lab4.enums.Stare;
import tema_lab4.enums.Tip;
import tema_lab4.enums.ZonaMagazin;

public class Copiator extends Echipament implements Serializable{
	
	private Integer ppm;
	private Integer p_ton;
	private Format format;
	
	public Copiator(String denumire, Integer nr_inv, Float pret, ZonaMagazin zona_mag, Stare stare,
			Integer ppm, Integer p_ton, Format format) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.p_ton = p_ton;
		this.format = format;
		this.ppm = ppm;
	}

	public Integer getPpm() {
		return ppm;
	}

	public void setPpm(Integer ppm) {
		this.ppm = ppm;
	}

	public Integer getP_ton() {
		return p_ton;
	}

	public void setP_ton(Integer p_ton) {
		this.p_ton = p_ton;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return super.toString()+", " + ppm + ", " + p_ton + ", " + format;
	}
	
	public String scriereFisier() {
		return super.scriereFisier() + "copiator;" + ppm + ";" + p_ton + ";" + format;

	}
	
}
