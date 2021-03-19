package hashSet;

public class Student {
	private String index, fName, lName;

	public Student(String index, String fName, String lName) {
		this.index = index;
		this.fName = fName;
		this.lName = lName;
	}

	public String toString() {
		return index + ", " + fName + " " + lName;
	}

	public boolean equals(Object anotherStudent) {
		if (anotherStudent != null && anotherStudent instanceof Student) {
			Student s = (Student) anotherStudent;
			return index.equals(s.index) && fName.equals(s.fName) && lName.equals(s.lName);
		} else {
			return false;
		}
	}

	public int hashCode() {
		return toString().hashCode();
	}

}
