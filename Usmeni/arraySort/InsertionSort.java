package ArraySort;

public class InsertionSort {

	public static <T extends Comparable<T>> void sort(T arr[]) {
		
		for (int i = 1; i < arr.length; i++) {
			T current = arr[i];
			
			int j = i - 1;
			while (j >= i && arr[j].compareTo(arr[i]) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = current;
		}
		
	}
	
	
	// Sa granicnikom -- Kod programskih jezika gde nije podrzano lenjo izracunavanje
	// prethodni metod moze dovesti do pucanja programa ako j postane -1, a onda pozove
	// da poredimo arr[-1].compareTo(arr[0]). S toga implementiran je metod sa granicnikom,
	// pa u ovom slucaju ne moze doci do pucanja programa.
	public static <T extends Comparable<T>> void sort_v2(T arr[]) {
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[minIndex]) < 0) {
				minIndex = i;
			}
		}
		
		if (minIndex != 0) {
			T tmp = arr[minIndex];
			arr[minIndex] = arr[0];
			arr[0] = tmp;
		}
		
		for (int i = 2; i < arr.length; i++) {
			T current = arr[i];
			
			int j = i - 1;
			while (arr[j].compareTo(arr[i]) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = current;
		}
		
	}
	
}
