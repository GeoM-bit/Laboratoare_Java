package lab6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContBancar implements Operatiuni{
	private String numarCont;
	private float suma;
	private Moneda moneda;
	private LocalDate data_deschiderii;
	private LocalDate data_ultimei_operatiuni;	
	
	public ContBancar(String numarCont, float suma, Moneda moneda, LocalDate data_deschiderii,
			LocalDate data_ultimei_operatiuni) {
		super();
		this.numarCont = numarCont;
		this.suma = suma;
		this.moneda = moneda;
		this.data_deschiderii = data_deschiderii;
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}
	
	
	public String getNumarCont() {
		return numarCont;
	}


	public void setNumarCont(String numarCont) {
		this.numarCont = numarCont;
	}


	public float getSuma() {
		return suma;
	}


	public void setSuma(float suma) {
		this.suma = suma;
	}


	public Moneda getMoneda() {
		return moneda;
	}


	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}


	public LocalDate getData_deschiderii() {
		return data_deschiderii;
	}


	public void setData_deschiderii(LocalDate data_deschiderii) {
		this.data_deschiderii = data_deschiderii;
	}


	public LocalDate getData_ultimei_operatiuni() {
		return data_ultimei_operatiuni;
	}


	public void setData_ultimei_operatiuni(LocalDate data_ultimei_operatiuni) {
		this.data_ultimei_operatiuni = data_ultimei_operatiuni;
	}	

	@Override
	public String toString() {
		return "\n\t\t\t\t[numarCont=" + numarCont + ", suma=" + suma + ", moneda=" + moneda + ", data_deschiderii="
				+ data_deschiderii + ", data_ultimei_operatiuni=" + data_ultimei_operatiuni  + "]";
	}
	
	public void afisare()
	{
		System.out.println(this.toString());
	}

	@Override
	public float calculeaza_dobanda() {
		float dobanda = 0;
		if(this.moneda==Moneda.RON) {
			if(this.suma<500){
				dobanda = (float) (0.3* (ChronoUnit.DAYS.between(this.data_ultimei_operatiuni, LocalDate.now())));
			}
			else {
				dobanda = (float) (0.8* (ChronoUnit.DAYS.between(this.data_ultimei_operatiuni, LocalDate.now())));
			}
		}
		else {
			dobanda = (float) (0.1* (ChronoUnit.DAYS.between(this.data_ultimei_operatiuni, LocalDate.now())));
		}
		return dobanda;
	}
	@Override
	public float actualizare_suma() {
		this.suma += this.calculeaza_dobanda();
		this.data_ultimei_operatiuni = LocalDate.now();
		return this.suma;
	}
	@Override
	public void depunere(float suma) {
		this.actualizare_suma();
		this.suma += suma;
	}
	@Override
	public void extragere(float suma) {
		this.actualizare_suma();
		this.suma -= suma;
	}

}
