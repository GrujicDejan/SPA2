package ArraySort.selectionSort;

public class SelectionSort {

	public static <T extends Comparable<T>> void sort(T[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			
			int maxIndex = i;
			for (int j = 1; j <= i; j++) {
				if (arr[maxIndex].compareTo(arr[j]) > 0) {
					maxIndex = j;
				}
			}
			
			if (maxIndex != i) {
				T tmp = arr[maxIndex];
				arr[maxIndex] = arr[i];
				arr[i] = tmp;
			}
			
		}
	}
	
	public static <T extends Comparable<T>> void sort_v2(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					minIndex = j;
				}
			}
			
			if (minIndex != i) {
				T tmp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = tmp;
			}
			
		}
	}
	
}
