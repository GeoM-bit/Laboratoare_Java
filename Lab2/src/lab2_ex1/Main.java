package lab2_ex1;

public class Main {

	public static void main(String[] args) {
		Parabola p = new Parabola(2, 4, -24);
		Parabola p1 = new Parabola(1, 2, 3);
		Parabola p2 = new Parabola(2, 9, -4);
		
		System.out.print("p - > ");
		p.Afisare();
		System.out.print("\np1 - > ");
		p1.Afisare();
		System.out.print("\np2 - > ");
		p2.Afisare();
		
		System.out.println("\nCoordonatele varfului sunt: ( " + p.CalculVarf()[0][0] + " ; " + p.CalculVarf()[1][0] + " )");
		System.out.println("Coordonatele mijlocului sunt: ( " + Parabola.CalculMijloculSegmentului(p1, p2)[0][0] + " ; " + Parabola.CalculMijloculSegmentului(p1, p2)[1][0] + " )");
	}

}
