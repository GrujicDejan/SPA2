package arraySort;

public class HeapSort {
	
	public static <T extends Comparable<T>> void sort(T[] arr) {
		int lastIndex = arr.length - 1;
		int lastParrent = (lastIndex - 1) / 2; // poslednji otac 
		
		// uspostavi struktru heapa
		while (lastParrent >= 0) {
			makeHeap(arr, lastParrent, lastIndex);
			lastParrent--;
		}
		
		// indeks poslednjeg elementa u nesortiranom delu niza
		int end = lastIndex;
		
		while (end > 0) {
			// razmeni prvi element sa poslednjim elementom
			// iz nesortiranog dela niza
			T tmp = arr[0];
			arr[0] = arr[end];
			arr[end] = tmp;
			
			// nesortirani deo je sada kraci za jedan element
			end--;
			
			// uspostavi strukturu hipa u nesortiranom delu
			makeHeap(arr, 0, end);
		}
		
	}

	private static <T extends Comparable<T>> void makeHeap(T[] arr, int start, int end) {
		int parrentIndex = start;
		boolean heapRestore = false;
		
		while (!heapRestore) {
			int maxSonIndex = getMaxSon(arr, parrentIndex, end);
			
			// ne postoji ni jedan od sinova
			if (maxSonIndex == -1) {
				heapRestore = true;
			} else {
				// uporedi oca sa vecim sinom
				if (arr[maxSonIndex].compareTo(arr[parrentIndex]) > 0) {
					// razmeni oca sa vecim sinom
					T tmp = arr[maxSonIndex];
					arr[maxSonIndex] = arr[parrentIndex];
					arr[parrentIndex] = tmp;
					
					// otac je sada na poziciji vece sina
					parrentIndex = maxSonIndex;
				} else {
					heapRestore = true;
				}
			}
		}
		
	}

	// Odredjuje indeks veceg sina za datog roditelja
	// Vraca -1 ukoliko ne postoji ni jedan od sinova 
	private static <T extends Comparable<T>> int getMaxSon(T[] arr, int parrentIndex, int end) {
		int son1Index = 2 * parrentIndex + 1;
		int son2Index = 2 * parrentIndex + 2;
		int maxSonIndex = -1;
		
		// postoji sin1?
		if (son1Index <= end) {
			maxSonIndex = son1Index;
		}
		
		// postoji sin2?
		if (son2Index <= end) {
			// postoje oba sina, uporedi ih
			if (arr[son2Index].compareTo(arr[son1Index]) > 0) {
				maxSonIndex = son2Index;
			}
		}
		
		return maxSonIndex;
	}
	

}








