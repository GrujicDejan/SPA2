package arraySort;

import sort.insertionSort.InsertionSort;

public class QuickSort {
	
	public static <T extends Comparable<T>> void sort(T[] arr) {
		sort(arr, 0, arr.length - 1);
		//sortPivotIncenter(arr, 0, arr.length - 1);
	}

	private static <T extends Comparable<T>> void sort(T[] arr, int l, int h) {
		if (h - l < 17) {
			InsertionSort.sort(arr);
		} else {
			//int j = partitionHoare(arr, l, h);
			int j = partitionLomuto(arr, l, h);
			
			sort(arr, l, j - 1);
			sort(arr, j + 1, h);
		}
	}

	private static <T extends Comparable<T>> int partitionHoare(T[] arr, int l, int h) {
		T pivot = arr[l];
		int i = l + 1;
		int j = h;
		
		while (i < j) {
			while (i <= h && arr[i].compareTo(pivot) < 0) i++;
			while (j >= l && arr[j].compareTo(pivot) > 0) j--;
			
			if (i < j) {
				T tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		T tmp = arr[l];
		arr[l] = arr[j];
		arr[j] = tmp;
		
		return j;
	}

	private static <T extends Comparable<T>> int partitionLomuto(T[] arr, int l, int h) {
		T pivot = arr[h];
		int ltePivot = l - 1; // indeks elementa koji su <= pivota
		
		for (int i = l; i < h; i++) {
			if (arr[i].compareTo(pivot) <= 0) {
				++ltePivot;
				T tmp = arr[ltePivot];
				arr[ltePivot] = arr[i];
				arr[i] = tmp;
			}
		}
		
		int placeForPivot = ltePivot + 1;
		T tmp = arr[placeForPivot];
		arr[placeForPivot] = arr[h];
		arr[h] = tmp;
		
		return placeForPivot;
	}
	
	private static <T extends Comparable<T>> void sortPivotIncenter(T[] arr, int l, int h) {
		T pivot = arr[(l + h) / 2];
		int i = l;
		int j = h;
		
		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0) i++;
			while (arr[j].compareTo(pivot) > 0) j--;
			
			if (i <= j) {
				T tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		
		if (l < j) sort(arr, l, j);
		if (i < h) sort(arr, i, h);
	}
	
}


