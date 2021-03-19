package adtPriorityQueue;

public class ExPriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Kandidat> pq = new HeapPQ<Kandidat>(3);
		pq.insert(new Kandidat("Pera", 10, 20));
		pq.insert(new Kandidat("Zika", 15, 18));
		pq.insert(new Kandidat("Mika", 12, 14));
		pq.insert(new Kandidat("Tika", 22, 22));
		pq.insert(new Kandidat("Cale", 20, 20));
		pq.insert(new Kandidat("Sale", 11, 25));
		
		while (!pq.isEmpty()) {
			Kandidat k = pq.delMax();
			System.out.println("Upisujem kandidata " + k);
		}
	}
}
