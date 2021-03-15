package arraySort;

public class Radnik implements Comparable<Radnik>{
	
	private String ime;
	private int plata;
	
	public Radnik(String ime, int plata) {
		this.ime = ime;
		this.plata = plata;
	}

	public String getIme() {
		return ime;
	}

	public int getPlata() {
		return plata;
	}

	@Override
	public String toString() {
		return ime + ", plata=" + plata;
	}

	@Override
	public int compareTo(Radnik other) {
		return this.ime.compareTo(other.getIme());
	}

}
