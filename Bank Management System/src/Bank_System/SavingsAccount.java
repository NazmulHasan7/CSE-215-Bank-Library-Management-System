package Bank_System;

public class SavingsAccount extends Account {

	private double interestRate;

	//Default Constructor
	public SavingsAccount(double interestRate) {
		super();
		this.interestRate = interestRate;
	}
	//Constructor with accountNumber, balance and tenure year
	public SavingsAccount(int accountNumber, double balance, double interestRate) {
		super(accountNumber, balance);
		this.interestRate = interestRate;
	}
	//Getter and Setters
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	//Since FixedAccount inherits Abstract class Account. So, we have to implement the showInfo method
		@Override
		public void showInfo() {
			System.out.println("\n\n\nAccount Information\n\n\n\n___________________\n");
			System.out.print("Account Type      : Savings Account.\n");
			System.out.print("Account number : " +getAccountNumber()+"\n");
			System.out.print("Account Balance : " +getBalance()+"\n");
			System.out.print("Interest Rate       : " +interestRate+"________________________\n");
		}
		
}
