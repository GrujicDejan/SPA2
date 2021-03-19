package hashSet;

public class CHashSet<T> implements Set<T> {
	
	private static final int DEFAULT_TABLE_SIZE = 101;
	
	private enum Status {
		EMPTY, OCCUPIED, DELETED;
	}
	
	private Object[] table; // Tabela
	private Status[] status; // Statusi celija
	private int numElements; // Broj elemenata (OCCUPIED celija) u tabeli
	
	public CHashSet() {
		this(DEFAULT_TABLE_SIZE);
	}

	public CHashSet(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Velicina hash tabele ne moze biti negativna");
		}
		
		reset(size);
	}

	private void reset(int size) {
		table = new Object[size];
		status = new Status[size];
		for (int i = 0; i < status.length; i++) {
			status[i] = Status.EMPTY;
		}
		numElements = 0;
	}
	
	public int hash(T o) {
		if (o == null) {
			throw new IllegalArgumentException("Hash funkcija se ne moze racunati za null objekat");
		}
		
		return Math.abs(o.hashCode() % table.length);
	}
	
	public int searchCollisionChain(T element, int hashValue) {
		int currentPosition = hashValue;
		int i = 0;
		int maxChainLength = (table.length - 1) / 2;
		
		while (i <= maxChainLength && status[currentPosition] != Status.EMPTY) {
			if (status[currentPosition] == Status.OCCUPIED && table[currentPosition].equals(element)) {
				return currentPosition;
			}
			i++;
			currentPosition = (hashValue + i * i) % table.length;
		}
		
		return -1;
	}

	@Override
	public boolean remove(T element) {
		int pos = searchCollisionChain(element, hash(element));
		if (pos == -1)
			return false;
		
		status[pos] = Status.DELETED;
		numElements--;
		
		return true;
	}

	@Override
	public boolean member(T element) {
		return searchCollisionChain(element, hash(element)) >= 0;
	}
	
	@Override
	public boolean insert(T element) {
		int hashValue = hash(element);
		
		int maxChainLength = (table.length - 1) / 2;
		int i = 0;
		boolean endOfChain = false;
		int firstAvilablePosition = -1;
		
		while (!endOfChain && i <= maxChainLength) {
			int currentPosition = (hashValue + i * i) % table.length;
			
			if (status[currentPosition] == Status.OCCUPIED) {
				if (table[currentPosition].equals(element)) {
					return false;
				}
			} else {
				if (firstAvilablePosition == -1) {
					firstAvilablePosition = currentPosition;
				}
				
				if (status[currentPosition] == Status.EMPTY) {
					endOfChain = true;
				}
			}
			
			i++;
		}
		
		if (firstAvilablePosition == -1 || loadFactor() > 0.7) {
			expand();
			hashValue = hash(element);
			add(element, hashValue);
		} else {
			status[firstAvilablePosition] = Status.OCCUPIED;
			table[firstAvilablePosition] = element;
			numElements++;
		}
		
		return true;
	}

	private void add(T element, int hashValue) {
		boolean foundPosition = false;
		int i = 0;
		
		while (!foundPosition) {
			int currentPosition = (hashValue + i * i) % table.length;
			
			if (status[currentPosition] != Status.OCCUPIED) {
				status[currentPosition] = Status.OCCUPIED;
				table[currentPosition] = element;
				numElements++;
				foundPosition = true;
			} else {
				i++;
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void expand() {
		int oldSize = table.length;
		int size = oldSize * 2;
		while (!isPrime(size))
			size++;
		
		Object[] oldTable = new Object[oldSize];
		Status[] oldStatus = new Status[oldSize];
		
		for (int i = 0; i < oldSize; i++) {
			oldTable[i] = table[i];
			oldStatus[i] = status[i];
		}
		
		reset(size);
		
		for (int i = 0; i < oldSize; i++) {
			if (oldStatus[i] == Status.OCCUPIED) {
				T elem = (T) oldTable[i];
				add(elem, hash(elem));
			}
		}
		
		oldTable = null;
		oldStatus = null;
	}

	private boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		
		return true;
	}

	private double loadFactor() {
		return (double) numElements / (double) table.length; 
	}
	
	public void print() {
		for (int i = 0; i < table.length; i++) {
			if (status[i] == Status.EMPTY) {
				System.out.print("[E]");
			} else if (status[i] == Status.DELETED) {
				System.out.print("[D]");
			} else if (status[i] == Status.OCCUPIED) {
				System.out.print("[O - " + table[i] + "]");
			}
		}
	}

}
