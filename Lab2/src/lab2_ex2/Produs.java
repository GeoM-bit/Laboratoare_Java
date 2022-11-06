package lab2_ex2;

public class Produs {
	private String denumire;
	private float pret;
	private float cantitate;
	
	public Produs(String denumire, float pret, float cantitate) {
		super();
		this.denumire = denumire;
		this.pret = pret;
		this.cantitate = cantitate;
	}
	
	public String getDenumire() {
		return denumire;
	}
	
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	
	public float getPret() {
		return pret;
	}
	
	public void setPret(float pret) {
		this.pret = pret;
	}
	
	public float getCantitate() {
		return cantitate;
	}
	
	public void setCantitate(float cantitate) {
		this.cantitate = cantitate;
	}
	
	@Override
	public String toString() {
		return denumire + "\t\t" + pret + "\t\t" + cantitate ;
	}
	
	
}
