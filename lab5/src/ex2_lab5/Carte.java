package ex2_lab5;

public class Carte {
	private String titlu;
	private String autor;
	private Integer anul_aparitiei;
	
	public Carte(String titlu, String autor, Integer anul_aparitiei) {
		super();
		this.titlu = titlu;
		this.autor = autor;
		this.anul_aparitiei = anul_aparitiei;
	}

	public String getTitlu() {
		return titlu;
	}

	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getAnul_aparitiei() {
		return anul_aparitiei;
	}

	public void setAnul_aparitiei(Integer anul_aparitiei) {
		this.anul_aparitiei = anul_aparitiei;
	}

	@Override
	public String toString() {
		return "[titlu=" + titlu + ", autor=" + autor + ", anul_aparitiei=" + anul_aparitiei + "]";
	}
	
	
}
