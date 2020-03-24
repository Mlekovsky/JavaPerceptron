/**
 * Klasa zawieraj�ca dwie metody statyczne
 * s�u��ce do oblicznaia warto�ci funckji "f" dla zadanego x,
 * oraz do zwracania warto�ci pochodnej dla zadanego x
 * 
 * @author Damian �mietana
 *
 */
public class Sigmoid {
	
	/**
	 * Funkcja zwraca warto�� funkcji sigmoid dla danego argumentu
	 * @param x - argument funkcji
	 * @return warto�� funkcji w punkcie x
	 */
	public static double f(double x) {		
		return 1 / (1 + Math.pow(Math.E, -x));
	}
	
	/**
	 * Funkcja zwraca pochodn� dla podanego argumentu, zgodnie ze wzorem x(1-x)
	 * @param x - argument funkcji
	 * @return pochodn� dla zadanej warto�ci
	 */
	public static double der(double x) {		
		return x * (1 - x);
	}
}
