
public class Library implements ITeacherOperations, IStudentOperations, IBookOperations{
	private String libraryName;
	private String address;
	private Student students[ ];
	private Teacher teachers[];
	private Book books[ ];
	private int noOfBooks;
	private int noOfStudents;
	private int noOfTeachers;
	private Librarian librarian;
	
	public Library() {
		super();
	}
	public Library(String libraryName, String address, int noOfBooks, Librarian librarian) {
		super();
		this.libraryName = libraryName;
		this.address = address;
		this.noOfBooks = noOfBooks;
		this.librarian = librarian;
		books = new Book[100];
		teachers = new Teacher[100];
		students = new Student[100];
	}
	public Library(String libraryName, String address, Student[] students, Teacher[] teachers, Book[] books,
			 Librarian librarian) {
		super();
		this.libraryName = libraryName;
		this.address = address;
		this.students = students;
		this.teachers = teachers;
		this.books = books;
		noOfBooks = books.length;
		noOfStudents = students.length;
		noOfTeachers = teachers.length;
		this.librarian = librarian;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	public Teacher[] getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}
	public Book[] getBooks() {
		return books;
	}
	public void setBooks(Book[] books) {
		this.books = books;
	}
	public int getNoOfBooks() {
		return noOfBooks;
	}
	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public int getNoOfTeachers() {
		return noOfTeachers;
	}
	public void setNoOfTeachers(int noOfTeachers) {
		this.noOfTeachers = noOfTeachers;
	}
	public Librarian getLibrarian() {
		return librarian;
	}
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}
	public void LibararyInfo() {
		System.out.println("Library Information \nLibrary Name : " +libraryName+ ",\nAddress : " +address+ "\nStudents : "); 
		showAllStudents();
		showAllTeachers();
		showAllBooks();
		System.out.println("\nLibrarian :  " +librarian.toString());
	}
	@Override
	public void insertBook(Book b) {
		int i=0;
		while(books[i] != null) {
			i++;
		}
		books[i] = b;
		noOfBooks++;
		System.out.println("Book Added...........");
	}
	@Override
	public void removeBook(Book b) {
		int i;
		for(i=0; i<noOfBooks; i++) {
			if(books[i].getId() == b.getId()) {
				break;
			}
			else if	(i == noOfBooks) {
				System.out.println("The book is not found.");
				return;
			}
		}
		books[i] = books[noOfBooks-1];
		books[noOfBooks-1] = null;
		noOfBooks--;
		System.out.println("Book Removed............");
	}
	@Override
	public Book getBook(int bookId) {
		for(int i=0; i<noOfBooks; i++) {
			if(books[i].getId() == bookId) {
				return books[i];
			}
		}
		System.out.println("Book Id doesn't match.");
			return null;
	}
	@Override
	public void showAllBooks() {
		System.out.println("\nBooks : ");
		for(int i=0; i<noOfBooks; i++) {
			System.out.println(books[i].toString());
		}
	}
	@Override
	public void insertStudent(Student s) {
		int i=0;
		while(students[i] != null) {
			i++;
		}
		students[i] = s;
		noOfStudents++;
		System.out.println("Student Added..........");
	}
	@Override
	public void removeStudent(Student s) {
		int i;
		for(i=0; i<noOfStudents; i++) {
			if((students[i].getID()).equals(s.getID())) {
				break;
			}
			else if	(i == noOfStudents) {
				System.out.println("The Student is not found.");
				return;
			}
		}
		students[i] = students[noOfStudents-1];
		students[noOfStudents-1] = null;
		noOfStudents--;
		System.out.println("Student Removed");
	}
	@Override
	public Student getStudent(String studentId) {
		for(int i=0; i<noOfStudents; i++) {
			if(students[i].getID().equals(studentId)) {
				return students[i];
			}
		}
		System.out.println("Student Id doesn't match.");
			return null;
	}
	@Override
	public void showAllStudents() {
		for(int i=0; i<noOfStudents; i++) {
			System.out.println();
			students[i].showInfo();
		}	
	}
	@Override
	public void insertTeacher(Teacher t) {
		int i=0;
		while(teachers[i] != null) {
			i++;
		}
		teachers[i] = t;
		noOfTeachers++;
		System.out.println("Teacher Added");
	}
	@Override
	public void removeTeacher(Teacher t) {
		int i;
		for(i=0; i<noOfTeachers; i++) {
			if((teachers[i].getID()).equals(t.getID())) {
				break;
			}
			else if	(i == noOfTeachers) {
				System.out.println("The Teacher is not found.");
				return;
			}
		}
		teachers[i] = teachers[noOfTeachers-1];
		teachers[noOfTeachers-1] = null;
		noOfTeachers--;
		System.out.println("Teacher Removed");
	}
	@Override
	public Teacher getTeacher(String teacherId) {
		for(int i=0; i<noOfTeachers; i++) {
			if(teachers[i].getID().equals(teacherId)) {
				return teachers[i];
			}
		}
		System.out.println("Teacher Id doesn't match.");
			return null;
	}
	@Override
	public void showAllTeachers() {
		System.out.println("\nTeachers : ");
		for(int i=0; i<noOfTeachers; i++) {
			System.out.println();
			teachers[i].showInfo();
		}
	}
}
