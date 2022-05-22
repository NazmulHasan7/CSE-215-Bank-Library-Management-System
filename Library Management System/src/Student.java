
public class Student extends Patron{
	private String guardianName;
	private String guardianContactNo;
	
	public Student() {
		super();
	}
	public Student(String guardianName, String guardianContactNo) {
		super();
		this.guardianName = guardianName;
		this.guardianContactNo = guardianContactNo;
	}
	public Student(String iD, String name, String departmentName, String email, String contactNo, String address,
			int booksBorrowed, String guardianName, String guardianContactNo) {
		super(iD, name, departmentName, email, contactNo, address, booksBorrowed);
		this.guardianName = guardianName;
		this.guardianContactNo = guardianContactNo;
	}
	public String getGuardianName() {
		return guardianName;
	}
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	public String getGuardianContactNo() {
		return guardianContactNo;
	}
	public void setGuardianContactNo(String guardianContactNo) {
		this.guardianContactNo = guardianContactNo;
	}
	@Override
	public void showInfo() {
		System.out.println("Student Information : ");
		System.out.print("Name : "+getName()+"\nID : "+getID()+"\nDepartment Name : "+getDepartmentName()+
				"\nEmail : "+getEmail()+"\nContact : "+getContactNo()+"\nAddress : "+getAddress()+"\nGuardian Name :"
				+guardianName+"\nGuardian Contact No : "+guardianContactNo+"\n");
	}
}
