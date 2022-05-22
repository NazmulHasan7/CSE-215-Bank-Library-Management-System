
public class Librarian {
	private String name;
	private String LibrarianId;
	private double salary;
	private int age;
	
	public Librarian() {
		super();
	}
	public Librarian(String name, String librarianId, double salary, int age) {
		super();
		this.name = name;
		LibrarianId = librarianId;
		this.salary = salary;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLibrarianId() {
		return LibrarianId;
	}
	public void setLibrarianId(String librarianId) {
		LibrarianId = librarianId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return " Librarian Information : \n Librarian Name = " + name +
				"\n Librarian Id = " + LibrarianId + "\n Salary = " + salary + "\nAge = " + age + "\n";
	}	
}
