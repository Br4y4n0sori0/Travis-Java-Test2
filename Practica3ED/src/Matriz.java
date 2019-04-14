import java.io.IOException;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Matriz {

	private int n, m;
	private double miMatriz[][];

	public Matriz(int n, int m) {
		super();
		this.n = n;
		this.m = m;
		miMatriz = new double[n][m];

	}

	public Matriz(int n) {
		super();
		this.n = n;
		this.m = n;
		miMatriz = new double[n][n];

	}

	public static Matriz Sumar(Matriz a, Matriz b) {

		if ((a.miMatriz.length == b.miMatriz.length) && (a.miMatriz[0].length == b.miMatriz[0].length) && a != null
				&& b != null) {
			Matriz resultadoSuma = new Matriz(a.n, a.m);
			for (int i = 0; i < a.miMatriz.length; i++) {

				for (int j = 0; j < a.miMatriz[i].length; j++) {

					resultadoSuma.miMatriz[i][j] = a.miMatriz[i][j] + b.miMatriz[i][j];
				}
			}

			return resultadoSuma;

		} else
			return null;

	}

	public static Matriz Restar(Matriz a, Matriz b) {

		Matriz resultadoResta = new Matriz(a.n, a.m);

		if ((a.miMatriz.length == b.miMatriz.length) && (a.miMatriz[0].length == b.miMatriz[0].length) && a != null
				&& b != null) {
			for (int i = 0; i < a.miMatriz.length; i++) {

				for (int j = 0; j < a.miMatriz[i].length; j++) {

					resultadoResta.miMatriz[i][j] = a.miMatriz[i][j] - b.miMatriz[i][j];
				}
			}
			return resultadoResta;
		} else

			return null;

	}

	public void Mostar() {

		if (this.miMatriz != null) {

			for (int i = 0; i < miMatriz.length; i++) {

				StdOut.println();
				for (int j = 0; j < miMatriz[i].length; j++) {

					StdOut.print(" " + miMatriz[i][j]);
				}
			}

			StdOut.println();

		} else {
			StdOut.println("La matriz no se puede mostrar");
		}

	}

	public static Matriz generarMatrizIdentidad(int N) {

		Matriz matrizIdentidad = new Matriz(N);

		for (int i = 0; i < matrizIdentidad.miMatriz.length; i++) {

			for (int j = 0; j < matrizIdentidad.miMatriz[i].length; j++) {

				if (i == j) {
					matrizIdentidad.miMatriz[i][j] = 1;
				} else {

					matrizIdentidad.miMatriz[i][j] = 0;
				}
			}
		}

		return matrizIdentidad;

	}

	public static Matriz generarMatrizAleatoria(int N, int M) {

		Matriz matrizAleatoria = new Matriz(N, M);

		for (int i = 0; i < matrizAleatoria.miMatriz.length; i++) {

			for (int j = 0; j < matrizAleatoria.miMatriz[i].length; j++) {

				matrizAleatoria.miMatriz[i][j] = (int) (Math.random() * 100) + 1;
			}
		}

		return matrizAleatoria;

	}

	public static Matriz generarAumentada(Matriz Coef, Matriz Const) {
		int n = Coef.miMatriz.length;
		int m = Const.miMatriz.length;
		Matriz Aumentada = new Matriz(n, n + 1);

		if (n != m) {
			StdOut.println("no es posible hacer la matriz aumentada A|b debido que"
					+ "las filas de la matriz 1 es diferente al numero de elementos de la matriz de constantes");

		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n + 1; j++) {
					if (j == n) {
						Aumentada.miMatriz[i][j] = Const.miMatriz[i][0];
					} else {
						Aumentada.miMatriz[i][j] = Coef.miMatriz[i][j];
					}
				}
			}
		}
		return Aumentada;
	}

	public void llenarMatriz() {

		double temp;
		int contf = 0;
		int contc = 0;
		if (this != null) {

			for (int i = 0; i < this.miMatriz.length; i++) {

				contf++;
				contc = 0;

				for (int j = 0; j < this.miMatriz[i].length; j++) {

					contc++;

					StdOut.println("Ingrese el valor la para la poscicion: " + contf + "," + contc);
					temp = StdIn.readDouble();
					this.miMatriz[i][j] = temp;
				}
			}

		}

	}

	public static void eliminacionGaussiana(Matriz A) {
		int n = A.miMatriz.length;
		int l = A.miMatriz[0].length;
		if (n != l) {

			StdOut.println("A no es una matriz cuadrada.");
			return;

		} else {

			double m = 0;
			for (int k = 0; k < n - 1; k++) {

				for (int i = k + 1; i < n; i++) {

					StdOut.println(A.miMatriz[i][k]);

					m = A.miMatriz[i][k] / A.miMatriz[k][k];
					StdOut.println(m);

					for (int j = k; j < n + 1; j++) {
						StdOut.println(A.miMatriz[i][k]);

						A.miMatriz[i][j] = (double) A.miMatriz[i][j] - m * A.miMatriz[k][j];
					}
				}
			}
			// double suma;
			// double[] x = new double[n];
			// for (int i = n - 1; i >= 0; i--) {
			// suma = 0;
			// for (int j = i + 1; j < n; j++) {
			// suma = suma + A.miMatriz[i][j] * x[j];
			// }
			// x[i] = (A.miMatriz[i][n] - suma) / A.miMatriz[i][i];
			// }
		}
	}

}
