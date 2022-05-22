package Bank_System;
public class Customer implements AccountOperations {
	
	private String name;
	private int nid;
	private Account accounts[ ];
	private int numberOfAccounts = 0;
	
	public Customer() {
		super();
		name = null;
		nid = 0;
		accounts = new Account[10];
	}
	public Customer(String name, int nid) {
		super();
		this.name = name;
		this.nid = nid;
	}
	public Customer(String name, int nid, Account[] accounts) {
		super();
		this.name = name;
		this.nid = nid;
		this.accounts = accounts;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	@Override
	public void insertAccount(Account a) {
		accounts[numberOfAccounts] = a;
		numberOfAccounts++;
	}
	@Override
	public Account getAccount(int accountNumber) {
		for(int i=0; i<numberOfAccounts; i++) {
			if(accounts[i].getAccountNumber() == accountNumber) {
				return accounts[i];
			}
		}
		System.out.println("No account is found with the given account number.");
		return null;
	}
	@Override
	public void showAllAccounts() {
		for(int i=0; i<numberOfAccounts; i++) {
			accounts[i].showInfo();
			System.out.println();
			}
		}	
	}
