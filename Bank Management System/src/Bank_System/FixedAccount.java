package Bank_System;

public class FixedAccount extends Account {
	
	private int tenureYear;
    
	//Default Constructor
	public FixedAccount(int tenureYear) {
		super();
		this.tenureYear = tenureYear;
	}
    //Constructor with accountNumber, balance and tenure year
	public FixedAccount(int accountNumber, double balance, int tenureYear) {
		super(accountNumber, balance);
		this.tenureYear = tenureYear;
	}
	//Getter and Setters
	public int getTenureYear() {
		return tenureYear;
	}
	public void setTenureYear(int tenureYear) {
		this.tenureYear = tenureYear;
	}
	//Since FixedAccount inherits Abstract class Account. So, we have to implement the showInfo method
	@Override
	public void showInfo() {
		System.out.println("\n\n\nAccount Information\n\n\n\n___________________\n");
		System.out.print("Account Type      : Fixed Account.\n");
		System.out.print("Account number : " +getAccountNumber()+"\n");
		System.out.print("Account Balance : " +getBalance()+"\n");
		System.out.print("Tenure year        : " +tenureYear+"________________________\n");
	}

}
