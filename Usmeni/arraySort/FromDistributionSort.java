package arraySort;

public class FromDistributionSort {
	
	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < 20; i++) {
			arr[i] = ((int) (Math.random() * 10));
		}
		
		print(arr);
		sort(arr);
		print(arr);
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < 20; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void sort(int[]  arr) {
		// pronalazimo maksimum niza
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) 
				max = arr[i];
		}
		
		// formiramo distribuciju
		int[] distr = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			distr[arr[i]]++;
		}
		
		// na osnovu distribucije formiramo sortiran niz
		int currentPosition = 0;
		for (int i = 0; i < distr.length; i++) {
			for (int j = 0; j < distr[i]; j++) {
				arr[currentPosition++] = i;
			}
		}
		
	}
}
