import java.util.Scanner;

public class Start {
	private static Scanner input;
	private  static Library library;
	public static void main(String[] args) {
		
		Book books[] = new Book[10];
		books[0] = new Book(100,"C Programming","Beginners guide","Dennis Ritche","ABC publisher",199.99,5);
		books[1] = new Book(101,"Introduction To Java","Beginner to Expert","Y Daniel Liang","Pearson",249.99,10);
		books[2] = new Book(105,"Calculus","Early Transcendentals","Howard Anton","WILEY Publisher",149.99,7);
		
		Teacher teachers[] = new Teacher[10];
		teachers[0] = new Teacher("101-1001","John Smith","CSE","johnsmith@gmail.com","919-217-001","Dhaka-1200",0,1208);
		teachers[1] = new Teacher("101-1002","David Warner","CSE","davidwarner@gmail.com","929-217-119","Dhaka-1230",0,1211);
		teachers[2] = new Teacher("110-1009","John Doe","MATH","johndoe19@gmail.com","910-017-986","Dhaka-1229",0,1205);

		Student students[] = new Student[10];
		students[0] = new Student("042","Alam Morium","CSE","alammorium07@gmail.com","0138778685","Dhaka-1230",0,"MD Alam","014324434");
		students[1] = new Student("045","Nazmul Hasan","CSE","nhnazmulhasan085@gmail.com","0136598685","Dhaka-1229",0,"MD Ismail","01435434");
		students[2] = new Student("043","Leo Messi","EEE","leomessi@gmail.com","54545459","Dhanmondi-30",0,"George Messi","85854504");

		Librarian lib = new Librarian("Bruce Lee","102030",35000,39);
		library = new Library("AIUB Library","AIUB campus",students,teachers,books,lib);
		library.setNoOfBooks(3);
		library.setNoOfStudents(3);
		library.setNoOfTeachers(3);
		
		menu();
		System.out.println("\n\n           THANKS FOR USING\n\n");
		System.out.println("\n\n           By- Alam Morium\n\n");
	}
	
	public static void menu() {
		input = new Scanner(System.in);
		System.out.println("\n_______________MENU_________________ ");
		System.out.print("1.	Student Management\r\n" + 
				"2.	Teacher Management\r\n" + 
				"3.	Book Management\r\n" + 
				"4.	Borrow/ Return management\r\n" + 
				"5.	Exit [ Press any  key except 1,2,3,4] \r\n" + 
				"Enter your choice : ");
		int choice = input.nextInt();	
		switch(choice) {
		       case 1 : studentManagement(); break;
		       case 2 : teacherManagement(); break;
		       case 3 : bookManagement(); break;
		       case 4 : borrowReturnManagement(); break;
		       default :  return;
		}
	}
	
	public static void studentManagement() {
		System.out.println("\n_____STUDENT MANAGEMENT____");
		System.out.print("1. Insert New Student \n2. Remove Existing Student	\n3. Show All Student\nPress any other key to go to main menu......"
				+ "\nEnter your choice : ");
		int choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		       case 1 : System.out.println("\nEnter Student Info ........................");
		                      System.out.print("Name ? ");
		                      String name = input.nextLine();
		                      System.out.print("ID ? ");
		                      String id = input.nextLine();
		                      System.out.print("Department ? ");
		                      String dept = input.nextLine();
		                      System.out.print("Email ? ");
		                      String email = input.nextLine();
		                      System.out.print("Contact No ? ");
		                      String conNo = input.nextLine();
		                      System.out.print("Address ? ");
		                      String address = input.nextLine();
		                      System.out.print("Guardian Name ? ");
		                      String gName = input.nextLine();
		                      System.out.print("Guardian Contact ? ");
		                      String gCon = input.nextLine();
		                      Student newStudent = new Student(id,name,dept,email,conNo,address,0,gName,gCon);
		                      System.out.println();
		                      library.insertStudent(newStudent);
		                      studentManagement();
		                      break;
		       case 2 : System.out.print("Enter Student Id to remove : ");
		                      String sid = input.nextLine();
		                      Student student = library.getStudent(sid);
		                      System.out.println();
		                      if(student!=null) {
		                    	  library.removeStudent(student);
		                      } 
		                      System.out.println();
		                      studentManagement();
		                      break;
		       case 3 : System.out.println("\nShowing All  Students :");
		    	              library.showAllStudents();
		                      System.out.println();
		                     studentManagement();
		                      break;
		       default : menu();                
		}
	}
	
	public static void teacherManagement() {
		System.out.println("\n_____TEACHER MANAGEMENT____");
		System.out.print("1. Insert New Teacher \n2. Remove Existing Teacher	\n3. Show All Teacher\nPress any other key to go to main menu......"
				+ "\nEnter your choice : ");
		int choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		       case 1 : System.out.println("\nEnter Teacher Info ........................");
		                      System.out.print("Name ? ");
		                      String name = input.nextLine();
		                      System.out.print("ID ? ");
		                      String id = input.nextLine();
		                      System.out.print("Department ? ");
		                      String dept = input.nextLine();
		                      System.out.print("Email ? ");
		                      String email = input.nextLine();
		                      System.out.print("Contact No ? ");
		                      String conNo = input.nextLine();
		                      System.out.print("Address ? ");
		                      String address = input.nextLine();
		                      System.out.print("Office Room ? ");
		                      int officeRoom = input.nextInt();
		                      Teacher newTeacher = new Teacher(id,name,dept,email,conNo,address,0,officeRoom);
		                      System.out.println();
		                      library.insertTeacher(newTeacher);
		                      teacherManagement();
		                      break;
		       case 2 : System.out.print("Enter Teacher Id to remove : ");
		                      String tid = input.nextLine();
		                      Teacher teacher = library.getTeacher(tid);
		                      System.out.println();
		                      if(teacher!=null) {
		                    	  library.removeTeacher(teacher);
		                      } 
		                      System.out.println();
		                      teacherManagement();
		                      break;
		       case 3 : System.out.println("\nShowing All  Teachers :");
		    	              library.showAllTeachers();
		                      System.out.println();
		                      teacherManagement();
		                      break;
		       default : menu();                
		}
	}
	
	public static void bookManagement() {
		System.out.println("\n_____BOOK MANAGEMENT____");
		System.out.print("1. Insert New Book \n2. Remove Existing Book	\n3. Show All Books\nPress any other key to go to main menu......"
				+ "\nEnter your choice : ");
		int choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		       case 1 : System.out.println("\nEnter Book Info ........................");
		                      System.out.print("Title ? ");
		                      String title = input.nextLine();
		                      System.out.print("Subtitle ? ");
		                      String subtitle = input.nextLine();
		                      System.out.print("Author ? ");
		                      String author = input.nextLine();
		                      System.out.print("Publisher ? ");
		                      String publisher = input.nextLine();
		                      System.out.print("Book ID ? ");
		                      int id = input.nextInt();
		                      System.out.print("Number of copies ? ");
		                      int noCopies = input.nextInt();
		                      System.out.print("Price ? ");
		                      double price = input.nextDouble();
		                      Book newBook = new Book(id,title,subtitle,author,publisher,price,noCopies);
		                      System.out.println();
		                      library.insertBook(newBook);
		                      bookManagement();
		                      break;
		       case 2 : System.out.print("Enter Book Id to remove : ");
		                      int bid = input.nextInt();
		                      Book book = library.getBook(bid);
		                      System.out.println();
		                      if(book!=null) {
		                    	  library.removeBook(book);
		                      } 
		                      System.out.println();
		                      bookManagement();
		                      break;
		       case 3 : System.out.println("\nShowing All  Books :");
		    	              library.showAllBooks();
		                      System.out.println();
		                      bookManagement();
		                      break;
		       default : menu();                
		}
	}
	
	public static void borrowReturnManagement() {
		System.out.println("\n_____BOOK MANAGEMENT____");
		System.out.print("1. Borrow Book \n2. Return Book \nPress any other key to go to main menu......"
				+ "\nEnter your choice : ");
		int choice = input.nextInt();
		input.nextLine();
		switch(choice) {
		        case 1 : System.out.print("Book will be borrowed by ? \n1. Teacher 2. Student\n");
		                        int borrower = input.nextInt();
		                        input.nextLine();
		                        if(borrower == 1) {
		                        	System.out.print("Enter Teacher ID : ");
		                        	String tid = input.nextLine();
		                        	Teacher teacher = library.getTeacher(tid);
		                        	System.out.print("Enter book ID : ");
		                        	int bid = input.nextInt();
		                        	Book book = library.getBook(bid);
		                        	
		                        	if(teacher != null && book != null) {
		                        		teacher.borrowBook(book);
			                        	System.out.println("\nProcess Completed........\n");
		                        	}
		                        	else
		                        		System.out.println("Can't borrow book. Invalid teacher or Book id.");
		                        }
		                        else if(borrower == 2) {
		                        	System.out.print("Enter Student ID : ");
		                        	String sid = input.nextLine();
		                        	Student student = library.getStudent(sid);
		                        	System.out.print("Enter book ID : ");
		                        	int bid = input.nextInt();
		                        	Book book = library.getBook(bid);
		                        	
		                        	if(student != null && book != null) {
		                        		student.borrowBook(book);
			                        	System.out.println("\nProcess Completed........\n");
		                        	}
		                        	else
		                        		System.out.println("Can't borrow book. Invalid student or Book id.");
		                        }
		                        else {
		                        	System.out.println("Wrong input.");
		                        }
		                        borrowReturnManagement();
		                        break;
		        
		        case 2 :  System.out.print("Book will be returned by ? \n1. Teacher 2. Student\n");
                                 int returner = input.nextInt();
                                 input.nextLine();
                                 
                                 if(returner == 1) {
                                	      System.out.print("Enter book ID : ");
           	                              int bid = input.nextInt();
           	                              System.out.println(bid);
           	                              Book book = library.getBook(bid);
                	                      System.out.print("Enter Teacher ID : ");
                	                      String tid = input.nextLine();
                	                      Teacher teacher = library.getTeacher(tid);
                	                      
                	                      if(teacher != null && book != null) {
                	                    	  teacher.returnBook(book);
                    	                      System.out.println("\nProcess Completed........\n");
                	                      }
                	                      else
                	                    	  System.out.println("Invalid book id or teacher id");
                                  }
                                   else if(returner == 2) {
                	                       System.out.print("Enter Student ID : ");
                                       	   String sid = input.nextLine();
                	                       Student student = library.getStudent(sid);
                	                       System.out.print("Enter book ID : ");
                	                       int bid = input.nextInt();
                	                       Book book = library.getBook(bid);
                	                       
                	                       if(student != null && book != null) {
                	                    	   student.returnBook(book);
                    	                       System.out.println("\nProcess Completed........\n");
                	                       }
                	                       else
                	                    	   System.out.println("Invalid book id or student id");
                                  }
                                  else {
                	                        System.out.println("Wrong input.");
                                  }
                                 borrowReturnManagement();
                                  break;      
		        default : menu();                                           
		}
	}
}
