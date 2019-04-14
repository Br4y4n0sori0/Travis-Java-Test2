import edu.princeton.cs.algs4.StdOut;

public class pruebaUnitaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Matriz a = Matriz.generarMatrizAleatoria(3,3);
		Matriz b= Matriz.generarMatrizAleatoria(3,3);
		Matriz c= Matriz.generarMatrizAleatoria(2,2);
		c.Mostar();
		Matriz.eliminacionGaussiana(c);
		c.Mostar();
//		b.Mostar();
//		c.Mostar();
//		

	}

}
