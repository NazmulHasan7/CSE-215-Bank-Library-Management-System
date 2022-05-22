package Bank_System;

import java.util.Scanner;

public class Start {

	private static Scanner input;
	private static Scanner input2;
	private static Scanner input3;
	private static Scanner input4;
	private static Scanner input5;

	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println("->->->->->->MENU<-<-<-<-<-<-\n"
				+"1. Employee Management \n2. Customer Management\n"
				+"3. Customer Account Management \n4. Account Transactions\n"
				+"5. Exit ");
		input2 = new Scanner(System.in);
		do {
			try {
				System.out.print("Your choice ? ");
				int choice = input2.nextInt();
				
				if(choice <1 || choice > 5)
					throw new Exception();
				
				switch(choice) {
				    case 1 : EmployeeManagement(); break;
				    case 2 : CustomerManagement(); break;
				    case 3 : CustomerAccountManagement(); break;
				    case 4 : AccountTransactions(); break;
				    default : System.out.println("THANKS FOR USING"); return;
				}
			}
			catch(Exception ex) {
				System.out.println("Wrong input! Try again....");
			}
		}while(input2.nextInt()!= 5);
	}
	
	private static void AccountTransactions() {
		System.out.println("->->->->->->ACCOUNT TRANSACTION<-<-<-<-<-<-\n"
				+"1. Deposit Money \n2. Withdraw Money\n"
				+"3. Transfer Money \n4. Back");
		input3 = new Scanner(System.in);
		Customer c = new Customer();
		do {
			try {
				System.out.print("Your choice ? ");
				int choice = input3.nextInt();
				
				if(choice <1 || choice > 4)
					throw new Exception();
				
				switch(choice) {
				    case 1 : System.out.print("Enter account number : ");
				                 int accNum = input3.nextInt();
				                 Account Da = c.getAccount(accNum);
				                 System.out.print("Enter amount to deposit : ");
				                 double Damount = input3.nextDouble();
				                 Da.deposit(Damount);
				                 break;
				    case 2 : System.out.print("Enter account number : ");
	                             accNum = input3.nextInt();
	                             Account Wa = c.getAccount(accNum);
	                            System.out.print("Enter amount to withdraw : ");
	                            double Wamount = input3.nextDouble();
	                            Wa.withdraw(Wamount);
	                            break; 
				    case 3 : System.out.print("Enter your account number : ");
                                accNum = input3.nextInt();
                                System.out.print("Enter account number  where to transfer : ");
                                int accNum2 = input3.nextInt();
                                Account Ta1 = c.getAccount(accNum);
                                Account Ta2 = c.getAccount(accNum2);
                                System.out.print("Enter amount to Transfer : ");
                                double Tamount = input3.nextDouble();
                               
                                Ta1.transfer(Ta2, Tamount);
                                break; 
				    default : mainMenu();
				}
			}
			catch(Exception ex) {
				System.out.println("Wrong input! Try again....");
			}
		}while(input3.nextInt()!= 4);
		
	}
	
	private static void CustomerAccountManagement() {
		System.out.println("->->->->->->CUSTOMER ACCOUNT MANAGEMENT<-<-<-<-<-<-\n"
				+"1. Insert New Account \n2. Get Existing Account by Id\n"
				+"3. Show All Account \n4. Back");
		
		input = new Scanner(System.in);
		Customer c = new Customer();
		do {
			try {
				System.out.print("Your choice ? ");
				int choice = input.nextInt();
				
				if(choice <1 || choice > 4)
					throw new Exception();
				
				switch(choice) {
				    case 1 : System.out.println("Enter Name : NID  : ");
				                String name = input.nextLine();
				                int id = input.nextInt();
				                c.setName(name);
				                c.setNid(id);
				        		boolean takeInput = true; 
				        		
				        		while(!takeInput) {
				        			try {
				        				System.out.println("Choose your Account type : \n1)Savings Account 2)Fixed Account");
				        				int accType = input.nextInt();
				        				
				        				if(accType !=1 && accType !=2)
				        					throw new Exception();
				        				
				        				if(accType == 1) {
				        					Account a = new SavingsAccount(7.00);
				        					c.insertAccount(a);
				        				}
				        				else {
				        					Account a = new FixedAccount(3);
				        					c.insertAccount(a);
				        					
				        				}
				        				takeInput = false;
				        			}
				        			catch(Exception ex) {
				        				System.out.println("Please select between 1 and 2.Try again.");
				        			}
				        		}
				    	         break;
				    case 2 : System.out.println("Enter account number to Search : ");
				                int accountNumber = input.nextInt(); 
				                Account a = c.getAccount(accountNumber);
				                System.out.println("Account info : "+a.toString()); 
				                 break;
				    case 3 : c.showAllAccounts(); 
				                 break;
				    default : mainMenu();
				}
			}
			catch(Exception ex) {
				System.out.println("Wrong input! Try again....");
			}
		}while(input.nextInt()!= 4);
	}
	
	private static void CustomerManagement() {
		System.out.println("->->->->->->CUSTOMER MANAGEMENT<-<-<-<-<-<-\n"
				+"1. Insert New Customer \n2. Get Existing Customer by Id\n"
				+"3. Show All Customer \n4. Back");
		input5 = new Scanner(System.in);
		do {
			try {
				System.out.print("Your choice ? ");
				int choice = input5.nextInt();
				
				if(choice <1 || choice > 4)
					throw new Exception();
				
				Bank b = new Bank();
				switch(choice) {
				    case 1 : System.out.println("Enter Name : NID  : ");
				                Customer cus = new Customer(input5.nextLine(),input5.nextInt());
				                Account acc = null;
				                cus.insertAccount(acc);
				    	         b.insertCustomer(cus);
				    	         break;
				    case 2 : System.out.println("Enter customer NID to Search : ");
				                Customer cUs = b.getCustomer(input5.nextInt());
				                System.out.println("Emplyoee info : "+cUs.toString()); 
				                 break;
				    case 3 : b.showAllCustomers(); 
				                 break;
				    default : mainMenu();
				}
			}
			catch(Exception ex) {
				System.out.println("Wrong input! Try again....");
			}
		}while(input5.nextInt()!= 4);
	}
	
	private static void EmployeeManagement() {
		System.out.println("->->->->->->EMPLOYEE MANAGEMENT<-<-<-<-<-<-\n"
				+"1. Insert New Employee \n2. Get Existing Employee by Id\n"
				+"3. Show All Employees \n4. Back");
		input4 = new Scanner(System.in);
		do {
			try {
				System.out.print("Your choice ? ");
				int choice = input4.nextInt();
				
				if(choice <1 || choice > 4)
					throw new Exception();
				
				Bank b = new Bank();
				switch(choice) {
				    case 1 : System.out.println("Enter Name : ID : Salary : ");
				    	         Employee emp = new Employee(input4.nextLine(),input4.nextInt(),input4.nextDouble());       
				    	         b.insertEmployee(emp);
				    	         break;
				    case 2 : System.out.println("Enter employee ID to Search : ");
				                 Employee eMp = b.getEmployee(input4.nextInt());
				                System.out.println("Emplyoee info : "+eMp.toString()); 
				                 break;
				    case 3 : b.showAllEmployees(); 
				                 break;
				    default : mainMenu();
				}
			}
			catch(Exception ex) {
				System.out.println("Wrong input! Try again....");
			}
		}while(input4.nextInt()!= 4);
	}

}
