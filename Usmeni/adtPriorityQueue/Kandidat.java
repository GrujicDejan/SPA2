package adtPriorityQueue;

public class Kandidat implements Comparable<Kandidat> {
	private String ime;
	private int brBodovaSkola;
	private int brBodovaPrijemni;

	public Kandidat(String ime, int brBodovaPrijemni, int brBodovaSkola) {
		this.brBodovaSkola = brBodovaSkola;
		this.brBodovaPrijemni = brBodovaPrijemni;
		this.ime = ime;
	}

	public String toString() {
		return ime + ", " + brBodovaPrijemni + ", " + brBodovaSkola;
	}

	public int compareTo(Kandidat drugi) {
		int uk1 = brBodovaSkola + brBodovaPrijemni;
		int uk2 = drugi.brBodovaSkola + drugi.brBodovaPrijemni;
		return uk1 - uk2;
	}
}
