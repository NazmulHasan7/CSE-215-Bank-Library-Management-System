import java.io.*;
import java.util.Date;

public abstract class Patron implements IBasicOperations{
	private String ID;
	private String name;
	private String departmentName;
	private String email;
	private String contactNo;
	private String address;
	private Book borrowBookList[] = new Book [5];
	private int booksBorrowed;
	
	public Patron() {
		super();
	}
	public Patron(String iD, String name, String departmentName, String email, String contactNo, String address,
			int booksBorrowed) {
		super();
		ID = iD;
		this.name = name;
		this.departmentName = departmentName;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.booksBorrowed = booksBorrowed;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getBooksBorrowed() {
		return booksBorrowed;
	}
	public void setBooksBorrowed(int booksBorrowed) {
		this.booksBorrowed = booksBorrowed;
	}
	public Book[] getBorrowBookList() {
		return borrowBookList;
	}
	public void setBorrowBookList(Book[] borrowBookList) {
		this.borrowBookList = borrowBookList;
	}
	@Override
	public void returnBook(Book b) {
		if(booksBorrowed > 0) {
			int i;
			for(i=0; i<booksBorrowed; i++) {
				if(borrowBookList[i].getId() == b.getId())
					break;
				else if(i == booksBorrowed) {
					System.out.println("Given book id doesn't match with any book id in borrowed book list.");
					return;
				}
			}
			System.out.println("Returning the book ........Writing into file..");
			try {
				Date date = new Date();
				File returnFile = new File("Return.txt");
				if(!returnFile.exists())
					returnFile.createNewFile();
				
				b.noOfCopy++;
				FileWriter fr = new FileWriter(returnFile,true);
				PrintWriter returnOutput = new PrintWriter(fr);
				returnOutput.print("ID : "+ID+" Name : "+name+" Email : "+email+" Address : "+address+" Contact : "
				+contactNo+"\nBook Id : "+b.getId()+" Author :"+b.getAuthorName()+" Title : "+b.getTitle()+"\nDate : "+date.toString()+"\n");
				
				borrowBookList[i] = borrowBookList[booksBorrowed-1];
				borrowBookList[booksBorrowed-1] = null;
				booksBorrowed--;
				fr.close();
				System.out.println("Successfully Written into file.");
			}
			catch(Exception ex) {
				System.out.println("Error! Couldn't write into file.");
			}
		}
		else 
			System.out.println("No books borrowed. So you can't return.");
	}
	@Override
	public void borrowBook(Book b) {
		if(booksBorrowed < 5) {
			System.out.println("Borrowing the book ........Writing into file..");
			try {
				Date date = new Date();
				File borrowFile = new File("Borrow.txt");
				if(!borrowFile.exists())
					borrowFile.createNewFile();
				
				b.noOfCopy--;
				FileWriter fr = new FileWriter(borrowFile,true);
				PrintWriter borrowOutput = new PrintWriter(fr);
				borrowOutput.print("ID : "+ID+" Name : "+name+" Email : "+email+" Address : "+address+" Contact : "
						+contactNo+"\nBook Id : "+b.getId()+" Author :"+b.getAuthorName()+" Title : "+b.getTitle()+"\nDate : "+date.toString()+"\n");
						
				fr.close();
				System.out.println("Successfully Written into file.");
				borrowBookList[booksBorrowed] = b;
				booksBorrowed++;
			}
			catch(Exception ex) {
				System.out.println("Error! Couldn't write into file.");
			}
		}
		else 
			System.out.println("No more books can be borrowed.");
	}
	public abstract void showInfo();
	
}
