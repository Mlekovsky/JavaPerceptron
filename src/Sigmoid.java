/**
 * Klasa zawieraj¹ca dwie metody statyczne
 * s³u¿¹ce do oblicznaia wartoœci funckji "f" dla zadanego x,
 * oraz do zwracania wartoœci pochodnej dla zadanego x
 * 
 * @author Damian Œmietana
 *
 */
public class Sigmoid {
	
	/**
	 * Funkcja zwraca wartoœæ funkcji sigmoid dla danego argumentu
	 * @param x - argument funkcji
	 * @return wartoœæ funkcji w punkcie x
	 */
	public static double f(double x) {		
		return 1 / (1 + Math.pow(Math.E, -x));
	}
	
	/**
	 * Funkcja zwraca pochodn¹ dla podanego argumentu, zgodnie ze wzorem x(1-x)
	 * @param x - argument funkcji
	 * @return pochodn¹ dla zadanej wartoœci
	 */
	public static double der(double x) {		
		return x * (1 - x);
	}
}
