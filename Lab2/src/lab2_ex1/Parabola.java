package lab2_ex1;

public class Parabola {
	private double a;
	private double b;
	private double c;
	
	public Parabola(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public Parabola(Parabola parabola) {
		this.a = parabola.a;
		this.b = parabola.b;
		this.c = parabola.c;
	}
	
	public void Afisare() {
		System.out.print("f(x) = ");
		if(this.a != 0) {
			System.out.print(this.a + "x ");
		}
		if(this.b > 0 && this.a != 0) {
			System.out.print("+ " + this.b + "x ");
		}
		else if(this.b < 0) {
			System.out.print(this.b + "x ");
		}
		if(this.c > 0) {
			System.out.print("+ " + this.c);
		}
		else if(this.c < 0) {
			System.out.print(this.c);
		}		
	}
	
	public double[][] CalculVarf(){
		double[][] coordonate = {
				{-(this.b/(2*this.a))},
				{(-this.b*this.b + 4*this.a*this.c)/(4*this.a)}
		};
		
		return coordonate;
	}
	
	public static double[][] CalculMijloculSegmentului(Parabola p1, Parabola p2){
		double[][] coordonateMijloc = {
				{(p1.CalculVarf()[0][0] + p2.CalculVarf()[0][0])/2},
				{(p1.CalculVarf()[1][0] + p2.CalculVarf()[1][0])/2}
		};
		
		return coordonateMijloc;
	}
}
