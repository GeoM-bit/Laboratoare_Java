package lab3_ex1;

public class CNP_Eronat extends Exception{
	private String message;
	
	public CNP_Eronat(String message) {
		this.message = message;
	}
	public String toString() {
		return this.message;
	}
}
