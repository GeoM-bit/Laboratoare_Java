package tema_lab4;

import java.io.Serializable;

import tema_lab4.enums.InstallOS;
import tema_lab4.enums.Stare;
import tema_lab4.enums.Tip;
import tema_lab4.enums.ZonaMagazin;

public class SistemCalcul extends Echipament implements Serializable{
	
	private String tip_mon;
	private Float vit_proc;
	private Integer c_hdd;
	private InstallOS install;
	
	public SistemCalcul(String denumire, Integer nr_inv, Float pret, ZonaMagazin zona_mag, Stare stare,
			String tip_mon, Float vit_proc, Integer c_hdd, InstallOS install) {
		super(denumire, nr_inv, pret, zona_mag, stare);
		this.tip_mon = tip_mon;
		this.vit_proc = vit_proc;
		this.c_hdd = c_hdd;
		this.install = install;
	}

	public String getTip_mon() {
		return tip_mon;
	}

	public void setTip_mon(String tip_mon) {
		this.tip_mon = tip_mon;
	}

	public Float getVit_proc() {
		return vit_proc;
	}

	public void setVit_proc(Float vit_proc) {
		this.vit_proc = vit_proc;
	}

	public Integer getC_hdd() {
		return c_hdd;
	}

	public void setC_hdd(Integer c_hdd) {
		this.c_hdd = c_hdd;
	}

	public InstallOS getInstall() {
		return install;
	}

	public void setInstall(InstallOS install) {
		this.install = install;
	}

	@Override
	public String toString() {
		return super.toString()+", " + tip_mon + ", " + vit_proc + ", " + c_hdd + ", " + install;
	}
	
	public String scriereFisier() {
		return super.scriereFisier() + "sistem_de_calcul;" + tip_mon + ";" + vit_proc + ";" + c_hdd + ";" + install;

	}
	
}
