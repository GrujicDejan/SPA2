package listSort;

public class TestProgram {

	public static void main(String[] args) {
		SortableList<Integer> list = new SortableList<>();
		SortableList<Integer> list2 = new SortableList<>();
		SortableList<Integer> list3 = new SortableList<>();
		for (int i = 0; i < 20; i++) {
			list.add((int) (Math.random() * 10));
			list2.add((int) (Math.random() * 10));
			list3.add((int) (Math.random() * 10));
		}
		
		System.out.println("Insertion sort...");
		list.print();
		list.insertionSort();
		list.print();
		
		System.out.println("Merge sort...");
		list2.print();
		list2.mergeSort();
		list2.print();
		
		System.out.println("Quick sort...");
		list3.print();
		list3.quickSort();
		list3.print();
	}
}
