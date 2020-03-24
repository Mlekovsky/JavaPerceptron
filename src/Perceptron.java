/**
* Klasa Perceptron posiada metodê
* realizuj¹c¹ uczenie neuronu
* na podstawie wzorcowej macierzy wejœciowej
* i wektora wyjœciowego.
* Posiada te¿ metody do wyœwietlania wyników
*
* @author DŒ
*
*/

import java.util.Random;

public class Perceptron {
	private double[][] in; //wzorcowa tablica wejsciowa
	private double[] out; //wzorcowa tablica wyjsciowa
	private double lr = 10; //predkosc uczenia perceptronu
	private double maxError = 0.001;; //maksymalny b³ad
	private int maxEpochs = 10000; //maksymalna liczba epok
	private double[] wagi; //tablica z wagami
	private double error; //b³¹d uczenia
	private int epochs; //liczba epok

	public Perceptron(double[][] in, double[] out) 
	{
		this.in=in;
		this.out=out;
	}

	public Perceptron(double[][] in, double[] out, double lr) 
	{
		this.in=in;
		this.out=out;
		this.lr=lr;
	}
	
	public Perceptron(double[][] in, double[] out, double lr, double maxError) 
	{
		this.in=in;
		this.out=out;
		this.lr=lr;
		this.maxError=maxError;
	}
	
	public Perceptron(double[][] in, double[] out, double lr, double maxError, int maxEpochs) 
	{
		this.in=in;
		this.out=out;
		this.lr=lr;
		this.maxError=maxError;
		this.maxEpochs=maxEpochs;
	}

	/**
	 * Metoda realizuje proces losowania wag, które nastêpnie bêda u¿yte w ramach procesu nauki dla neuronu
	 * 
	 * @author Damian
	 * @return Tablica z losowo wygenerowanymi wagami 
	 */
	private double[] losujWagi() 
	{
		//Odpowiedzi na pytania z pkt 6
		//in[0].length zwraca d³ugoœæ tablicy (iloœæ elementów) pod indeksem 0 z tablicy wejœciowej (dwuwymiarowej)
		//in.length zwraca d³ugoœæ tablicy dwuwymiarowej, czyli iloœæ tablic przechowywanych w ramach tablicy dwuwymiarowej
		
		Random rand = new Random();
		double[] wgs = new double[this.out.length];
		for (int i = 0; i < this.in[0].length; i++) 
		{
			wgs[i] = 2 * rand.nextDouble() - 1; //losowanie wag
		}
		return wgs;
	}
	
	/**
	 * Metoda realizuj¹ca uczenie neuronu
	 * 
	 * @author Damian
	 */
	public void uczenieNeuronu() 
	{
		//przypisanie wartoœci pocz¹tkowych epok i b³êdu uczenia
		this.epochs = 0;
		this.error = 1;
		
		//inicjowanie tablic lokalnych (istniej¹ tylko w tej metodzie)
		double[] y = new double[this.out.length];
		double[] zeros = new double[this.out.length];
		double[] blad = new double[this.out.length];
		double[] poprawka = new double[this.out.length];
		this.wagi = losujWagi(); //losowanie wag pocz¹tkowych
		
		while (this.error > this.maxError && this.epochs < this.maxEpochs) 
		{
			//klonowanie tablicy zero, która posiada zerowe elementy
			y = zeros.clone();
			blad = zeros.clone(); //jw
			poprawka = zeros.clone(); //jw
			
			//obliczanie aktualnych wart. Wyjœæ. perceptronu i tablicy poprawek
			for (int i = 0; i < this.out.length; i++) 
			{
					for (int j = 0; j < this.in[0].length; j++) 
					{
						//mno¿enie wejscia i wagi z jednoczesnym sumowaniem
						y[i] += this.in[i][j] * this.wagi[j];
					}
				y[i] = Sigmoid.f(y[i]); //wartoœæ wyjœciowa perceptronu
				blad[i] = this.out[i] - y[i]; // wyjœæ. wzorcowe – wyjœæ. aktualne
				poprawka[i] = blad[i] * Sigmoid.der(y[i]); //tablica poprawek
			}
			
			//wagi
			for (int k = 0; k < this.in[0].length; k++) 
			{
				double sum = 0;
				for (int l = 0; l < this.out.length; l++) 
				{
					sum += this.in[l][k] * poprawka[l];
				}
				this.wagi[k] += this.lr * sum; // wyznaczenie nowych wag
			}
			
			//b³¹d uczenia
			this.error = 0;
			for (int m = 0; m < this.out.length; m++) 
			{
				//b³¹d œredniokwadratowy
				this.error += Math.pow(blad[m], 2) / this.out.length;
			}
			this.epochs++; //liczba epok + 1
		}
	}
	
	/**
	 * Metoda wypisuj¹ca wyniki uczenia danego neuronu
	 * 
	 * @author Damian
	 */
	public void printWynik() 
	{		
		System.out.println("Uczenie pojedynczego perceptronu do realizacji funkcji logicznej:");
		System.out.println("Wynik neuronu | Wynik wzorcowy");
		
		double[] Yspr = new double[this.out.length];
		
		for(int i = 0; i < this.out.length; i++) 
		{
			for(int j = 0; j < this.in[0].length; j++) 
			{
				Yspr[i] += this.in[i][j] * this.wagi[j];
			}
			Yspr[i] = Sigmoid.f(Yspr[i]);
			System.out.println(Yspr[i]+" | "+this.out[i]);
		}
		
		System.out.println(""); //pusty wiersz na koñcu
	}
	
	/**
	 * Metoda wypisuj¹ca wagi u¿yte podczas uczenia neuronu
	 * 
	 * @author Damian
	 */
	public void printWagi() 
	{
		System.out.println("Wspó³czynniki wagowe:");
		
		for (int i = 0; i < this.wagi.length; i++) 
		{
			System.out.print(this.wagi[i] + ", ");
		}
		System.out.println("");
	}
	
	/**
	 * Metoda wypisuj¹ca b³¹d podczas uczenia neuronu 
	 * 
	 * @author Damian
	 */
	public void printError()
	{
		System.out.println("");
		System.out.println("B³¹d uczenia neuronu: " + this.error);
		System.out.println("");
	}
	
	/**
	 * Metoda wypisuj¹ca liczbê epok potrzenych w ramach procesu nauczania neuronu
	 * 
	 * @author Damian
	 */
	public void printEpochs()
	{
		System.out.println("Liczba epok uczenia: " + this.epochs);
		System.out.println("");
	}
	
	/**
	 * Metoda wypisuj¹ca wszystkie informacje na temat procesu uczenia dla danego neuronu
	 * 
	 * @author Damian
	 */
	public void PrintLearingProccessInfo()
	{
		this.printWynik();
		this.printWagi();
		this.printError();
		this.printEpochs();
	}
		
}
