package arraySort;

import java.util.Comparator;

//import quickSort.QuickSort;
//import sort.bruteForceSort.BruteForceSort;
//import sort.exchangeSort.ExchangeSort;
//import sort.insertionSort.InsertionSort;
//import sort.selectionSort.SelectionSort;
//import sort.shellSort.ShellSort;
//import sort.heapSort.HeapSort;

public class Zadatak {

	public static void main(String[] args) {

		Radnik[] radnici = new Radnik[4];
		radnici[0] = new Radnik("Petar", 60000);
		radnici[1] = new Radnik("Marko", 70000);
		radnici[2] = new Radnik("Nikola", 120000);
		radnici[3] = new Radnik("Aleksandar", 50000);
		
//		BruteForceSort.sort(radnici);
//		ispisi(radnici);
//		System.out.println("\nRadnici sortirani po plati");
//		BruteForceSort.sort_v2(radnici, new KomparatorPoPlati());
		
//		InsertionSort.sort(radnici);
//		ispisi(radnici);
//		InsertionSort.sort_v2(radnici);
//		ispisi(radnici);
		
//		SelectionSort.sort(radnici);
//		ispisi(radnici);
//		SelectionSort.sort_v2(radnici);
//		ispisi(radnici);
		
//		ExchangeSort.sort(radnici);
//		ispisi(radnici);
//		ExchangeSort.sort_v2(radnici);
//		ispisi(radnici);
//		ExchangeSort.sort_v3(radnici);
//		ispisi(radnici);
		
//		ShellSort.sort(radnici);
//		ispisi(radnici);
		
//		HeapSort.sort(radnici);
//		ispisi(radnici);
		
//		QuickSort.sort(radnici);
//		ispisi(radnici);
		
		
		
	}
	
	public static void ispisi(Radnik[] arr) {
		for (Radnik r : arr)
			System.out.println(r);
	}

}

class KomparatorPoPlati implements Comparator<Radnik> {

	@Override
	public int compare(Radnik r1, Radnik r2) {
		return r2.getPlata() - r1.getPlata();
	}
	
}
