package arraySort;

import java.util.Comparator;

public class BruteForceSort {

	public static <T extends Comparable<T>> void sort(T[] arr) {
		
		for (int j = 1; j < arr.length; j++) {
			for (int i = 0; i < j; i++) {
				
				if (arr[i].compareTo(arr[j]) > 0) {
					T tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
				
			}
		}
		
	}
	
	public static <T> void sort_v2(T[] arr, Comparator<T> cmp) {
		
		for (int j = 1; j < arr.length - 1; j++) {
			for (int i = 0; i < j; i++) {
				
				if (cmp.compare(arr[i],arr[j]) > 0) {
					T tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
				
			}
		}
		
	}
	
	
	
	
}
