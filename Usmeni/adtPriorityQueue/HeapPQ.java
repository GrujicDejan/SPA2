package adtPriorityQueue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapPQ <T extends Comparable<T>> implements PriorityQueue<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 100;
	
	private ArrayList<T> queue;
	
	public HeapPQ(int initialCapacity) {
		if (initialCapacity <= 0) 
			throw new IllegalArgumentException("initial capacity <= 0 ?!");
		
		queue = new ArrayList<>(initialCapacity);
	}
	
	public HeapPQ() {
		queue = new ArrayList<>(DEFAULT_INITIAL_CAPACITY);
	}

	@Override
	public void insert(T element) {
		queue.add(element);
		restoreHeapProperty(queue.size() - 1);
	}

	private void restoreHeapProperty(int sonIndex) {
		boolean heapRestored = false;
		int parrentIndex = (sonIndex - 1) / 2;
		while (sonIndex > 0 && !heapRestored) {
			T parrent = queue.get(parrentIndex);
			T son = queue.get(sonIndex);
			
			if (parrent.compareTo(son) > 0) {
				heapRestored = true;
			} else {
				swap(sonIndex, parrentIndex);
				
				sonIndex = parrentIndex;
				parrentIndex = (sonIndex - 1) / 2;
			}
		}
	}

	@Override
	public T delMax() {
		if (queue.size() == 0) 
			throw new NoSuchElementException("empty queue");

		T res = queue.get(0);
		swap(0, queue.size() - 1);
		queue.remove(queue.size() - 1);
		
		restoreHeapProperty2();
		return res;
	}

	private void restoreHeapProperty2() {
		boolean heapRestpred = false;
		int parrentIndex = 0;
		while (!heapRestpred) {
			int maxSonIndex = getMaxSon(parrentIndex);
			if (maxSonIndex == -1) {
				heapRestpred = true;
			} else {
				T parrent = queue.get(parrentIndex);
				T maxSon = queue.get(maxSonIndex);
				
				if (parrent.compareTo(maxSon) > 0) {
					heapRestpred = true;
				} else {
					swap(parrentIndex, maxSonIndex);
					
					parrentIndex = maxSonIndex;
				}
			}
		}
	}
	
	private int getMaxSon(int parrentIndex) {
		int son1Index = 2 * parrentIndex + 1;
		int son2Index = 2 * parrentIndex + 2;
		int maxSonIndex = -1;
		
		if (son1Index < queue.size()) {
			maxSonIndex = son1Index;
		}
		
		if (son2Index < queue.size()) {
			if (queue.get(son2Index).compareTo(queue.get(son1Index)) > 0) 
				maxSonIndex = son2Index;
		}
		
		return maxSonIndex;
	}
	
	private void swap(int indexa, int indexb) {
		T a = queue.get(indexa);
		queue.set(indexa, queue.get(indexb));
		queue.set(indexb, a);
	}
	
	@Override
	public T max() {
		if (queue.size() == 0)
			throw new NoSuchElementException("Empty queue");
		
		return (T) queue.get(0);
	}

	@Override
	public boolean isEmpty() {
		return queue.size() == 0;
	}

	@Override
	public int size() {
		return queue.size();
	}
	
	

}
