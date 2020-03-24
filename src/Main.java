/**
 * G³ówna klasa programu realizuj¹cego podstawowy
 * algorytm uczenia perceptronów
 * @author Damian
 *
 */
public class Main {
    public static void main( String []args ) {
    	
    	//Tablica wejœciowa
    	double[][] In = {{0,0,1},{0,1,1},{1,0,1},{1,1,1}};
    	
    	//Tablice wyjœciowe
    	double[] OutAND = {0,0,0,1};
    	double[] OutOR = {0,1,1,1};
    	double[] OutNAND = {1,1,1,0};
    	double[] OutNOR = {1,0,0,0};
    	double[] OutXOR = {0,1,1,0};
    	
    	//tworzenie obiektów dla ró¿nych funkcji logicznych
    	Perceptron neuronAND = new Perceptron(In, OutAND);
    	Perceptron neuronOR = new Perceptron(In, OutOR, 5, 0.000001);
    	Perceptron neuronNAND = new Perceptron(In, OutNAND, 10, 0.0001, 10000);
    	Perceptron neuronNOR = new Perceptron(In, OutNOR, 25);
    	Perceptron neuronXOR = new Perceptron(In, OutXOR, 15, 0.03, 1000);
    	
    	//wywo³anie metody uczenia neuronu
    	neuronAND.uczenieNeuronu();
    	//wywo³anie metody wyœwietlaj¹cej wyniki uczenia
    	neuronAND.printWynik();
    	//wywo³anie metody wyœwietlaj¹cej wagi neuronu
    	neuronAND.printWagi();
    	//wywo³anie metody wyœwietlaj¹cej b³¹d uczenia
    	neuronAND.printError();
    	//wywo³anie metody wyœwietlaj¹cej liczbê epok uczenia
    	neuronAND.printEpochs();
    	
    	//Nauka oraz wypisanie informacji OR
    	neuronOR.uczenieNeuronu();
    	neuronOR.PrintLearingProccessInfo(); //Metoda agreguj¹ca wszystkie metody odpowiedzialne za wypisywanie informacji
    	
    	//Nauka oraz wypisanie informacji NAND
    	neuronNAND.uczenieNeuronu();
    	neuronNAND.PrintLearingProccessInfo(); 
    	
    	//Nauka oraz wypisanie informacji NOR
    	neuronNOR.uczenieNeuronu();
    	neuronNOR.PrintLearingProccessInfo(); //Metoda agreguj¹ca wszystkie metody odpowiedzialne za wypisywanie informacji
    	
    	//Nauka oraz wypisanie informacji XOR
    	neuronXOR.uczenieNeuronu();
    	neuronXOR.PrintLearingProccessInfo(); //Metoda agreguj¹ca wszystkie metody odpowiedzialne za wypisywanie informacji
    	
    	
    }
}
