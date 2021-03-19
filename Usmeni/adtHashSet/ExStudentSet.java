package adtHashSet;

public class ExStudentSet {
	public static void main(String[] args) {
		OHashSet<Student> s = new OHashSet<Student>(5);
		s.insert(new Student("264/03", "Stojan", "Markovic"));
		s.insert(new Student("145/03", "Jovana", "Lackovic"));
		s.insert(new Student("264/03", "Stojan", "Markovic"));
		s.print();
	}
}
