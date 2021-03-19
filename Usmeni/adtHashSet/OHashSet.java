package hashSet;


public class OHashSet<T> implements Set<T> {
	private static final int DEFAULT_TABLE_SIZE = 101;
	
	public static class Node {
		Object value;
		Node next;
		
		public Node(Object value) {
			this.value = value;
		}
	}
	
	private Node[] table;
	
	public OHashSet() {
		this(DEFAULT_TABLE_SIZE);
	}
	
	public OHashSet(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Velicina hash tabele ne moze biti negativna");
		}
		table = new Node[size];
	}
	
	public int hash(T o) {
		if (o == null)
			throw new IllegalArgumentException("Hash funkcija se ne moze racunati za null objekat");
		
		return Math.abs(o.hashCode() % table.length);
	}
	
	private Node[] searchColissionChain(T element, int hashValue) {
		Node current = table[hashValue];
		Node prev = null;
		
		while (current != null) {
			if (current.value.equals(element)) {
				Node[] ret = new Node[2];
				ret[0] = current;
				ret[1] = prev;
				return ret;
			}
			
			prev = current;
			current = current.next;
		}
		
		return null;
	}

	@Override
	public boolean insert(T element) {
		int hashValue = hash(element);
		Node[] n = searchColissionChain(element, hashValue);
		if (n != null)
			return false;
		
		Node newElement = new Node(element);
		newElement.next = table[hashValue];
		table[hashValue] = newElement;
		
		return true;
	}

	@Override
	public boolean remove(T element) {
		int hashValue = hash(element);
		Node[] n = searchColissionChain(element, hashValue);
		if (n == null)
			return false;
		
		if (n[1] == null) {
			table[hashValue] = table[hashValue].next;
		} else {
			n[1].next = n[0].next;
		}
		
		return true;
	}

	@Override
	public boolean member(T element) {
		return searchColissionChain(element, hash(element)) != null;
	}

	public void print() {
		for (int i = 0; i < table.length; i++) {
			System.out.println("HashCode = " + i + ": ");
			
			Node head = table[i];
			if (head == null) {
				System.out.println(" empty");
			} else {
				while (head != null) {
					System.out.println("[" + head.value + "]");
					head = head.next;
				}
				System.out.println();
			}
			
		}
	}
	
	
	
}
