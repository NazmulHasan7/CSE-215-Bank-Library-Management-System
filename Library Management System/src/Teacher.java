
public class Teacher extends Patron{
	private int officeRoomNo;

	public Teacher() {
		super();
	}
	public Teacher(int officeRoomNo) {
		super();
		this.officeRoomNo = officeRoomNo;
	}
	public Teacher(String iD, String name, String departmentName, String email, String contactNo, String address,
			int booksBorrowed, int officeRoomNo) {
		super(iD, name, departmentName, email, contactNo, address, booksBorrowed);
		this.officeRoomNo = officeRoomNo;
	}
	public void setOfficeRoomNo (int  officeRoomNo ) {
		this.officeRoomNo = officeRoomNo;
	}
	public int  getOfficeRoomNo() {
		return officeRoomNo;
	}
	@Override
	public void showInfo() {
		System.out.println("Teacher Information : ");
		System.out.print("Name : "+getName()+"\nID : "+getID()+"\nDepartment Name : "+getDepartmentName()+
				"\nEmail : "+getEmail()+"\nContact : "+getContactNo()+"\nAddress : "+getAddress()+"\nOffice No : "+officeRoomNo+"\n");
	}
}
