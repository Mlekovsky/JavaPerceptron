/**
 * G��wna klasa programu realizuj�cego podstawowy
 * algorytm uczenia perceptron�w
 * @author Damian
 *
 */
public class Main {
    public static void main( String []args ) {
    	
    	//Tablica wej�ciowa
    	double[][] In = {{0,0,1},{0,1,1},{1,0,1},{1,1,1}};
    	
    	//Tablice wyj�ciowe
    	double[] OutAND = {0,0,0,1};
    	double[] OutOR = {0,1,1,1};
    	double[] OutNAND = {1,1,1,0};
    	double[] OutNOR = {1,0,0,0};
    	double[] OutXOR = {0,1,1,0};
    	
    	//tworzenie obiekt�w dla r�nych funkcji logicznych
    	Perceptron neuronAND = new Perceptron(In, OutAND);
    	Perceptron neuronOR = new Perceptron(In, OutOR, 5, 0.000001);
    	Perceptron neuronNAND = new Perceptron(In, OutNAND, 10, 0.0001, 10000);
    	Perceptron neuronNOR = new Perceptron(In, OutNOR, 25);
    	Perceptron neuronXOR = new Perceptron(In, OutXOR, 15, 0.03, 1000);
    	
    	//wywo�anie metody uczenia neuronu
    	neuronAND.uczenieNeuronu();
    	//wywo�anie metody wy�wietlaj�cej wyniki uczenia
    	neuronAND.printWynik();
    	//wywo�anie metody wy�wietlaj�cej wagi neuronu
    	neuronAND.printWagi();
    	//wywo�anie metody wy�wietlaj�cej b��d uczenia
    	neuronAND.printError();
    	//wywo�anie metody wy�wietlaj�cej liczb� epok uczenia
    	neuronAND.printEpochs();
    	
    	//Nauka oraz wypisanie informacji OR
    	neuronOR.uczenieNeuronu();
    	neuronOR.PrintLearingProccessInfo(); //Metoda agreguj�ca wszystkie metody odpowiedzialne za wypisywanie informacji
    	
    	//Nauka oraz wypisanie informacji NAND
    	neuronNAND.uczenieNeuronu();
    	neuronNAND.PrintLearingProccessInfo(); 
    	
    	//Nauka oraz wypisanie informacji NOR
    	neuronNOR.uczenieNeuronu();
    	neuronNOR.PrintLearingProccessInfo(); //Metoda agreguj�ca wszystkie metody odpowiedzialne za wypisywanie informacji
    	
    	//Nauka oraz wypisanie informacji XOR
    	neuronXOR.uczenieNeuronu();
    	neuronXOR.PrintLearingProccessInfo(); //Metoda agreguj�ca wszystkie metody odpowiedzialne za wypisywanie informacji
    	
    	
    }
}
