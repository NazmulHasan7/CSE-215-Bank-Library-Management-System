package Bank_System;

public abstract class Account implements ITransactions {
	
	private int accountNumber;
	private double balance;
	
	//Default Constructor
	//Since it's an Abstract class so, all constructors should be protected
	protected Account() {
		super();
		this.accountNumber = 0;
		this.balance = 0;
	}
    //Constructor with accountNumber and balance
    //Since it's an Abstract class so, all constructors should be protected 
	protected Account(int accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	//Getter and Setters
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	//Implementing methods of ITransaction interface
	@Override
	public void deposit(double amount) {
		if(amount > 0)
		    balance += amount;
		else
			System.out.println("Invalid amount");
	}
	@Override
	public void withdraw(double amount) {
		if(amount > 0 && amount < balance)
		    balance -= amount;
		else
			System.out.println("Invalid amount");
	}
	@Override
	public void transfer(Account a, double amount) {
		if(amount > 0 && amount < balance) {
			withdraw(amount);
			a.deposit(amount);
		}
		else
			System.out.println("Invalid amount");
	}
	//An abstract method to showInfo
	public abstract void showInfo();
	
}
