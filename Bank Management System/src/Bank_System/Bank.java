package Bank_System;

import java.util.*;
import java.io.*;

public class Bank implements EmployeeOperations, CustomerOperations {
	
	private Customer customers[ ];
	private Employee employees[ ];
	private int numberOfCustomers;
	private int numberOfEmployees;
	//Constructor
	public Bank() {
		super();
		customers = new Customer[50];
		employees = new Employee[50];
		try {
			Scanner EfileInput = new Scanner("Employee File.txt");
			while(EfileInput.hasNext()) {
				employees[numberOfEmployees] = new Employee(EfileInput.next(),EfileInput.nextInt(),EfileInput.nextDouble());
				numberOfEmployees++;
			}
			Scanner CfileInput = new Scanner("Customer File.txt");
			while(EfileInput.hasNext()) {
				employees[numberOfEmployees] = new Employee(CfileInput.next(),CfileInput.nextInt(),CfileInput.nextDouble());
				numberOfEmployees++;
			}
		}
		catch(Exception ex) {
			System.out.println("File Missing");
		}
	}
   //Setters
	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}
	
	//Implementing EmployeeOperations interface
	@Override
	public void insertEmployee(Employee e) {
		try {
			File employeeFile = new File("Employee File.txt");
			
			if(!employeeFile.exists()) 
				employeeFile.createNewFile();
			
			FileWriter fileWriter = new FileWriter(employeeFile, true); //Set true for append mode
		    PrintWriter printWriter = new PrintWriter(fileWriter);
		    
		    printWriter.println("Name : "+e.getName()+"\nEmpId : "+e.getEmpId()+"\nSalary : "+e.getSalary()+"\n"); 
		    
		    printWriter.close();
			fileWriter.close();
			System.out.println("Employee information inserted Successfully.");
		}
		catch(IOException ex) {
			System.out.println("Couldn't open the file!!!!");
		}
	}
	@Override
	public Employee getEmployee(int empId) {
		for(int i=0; i<numberOfEmployees; i++) {
			if(empId == employees[i].getEmpId()) {
				return employees[i];
			}
		}
		System.out.println("Sorry!  Couldn't find any Employee of ID " +empId+ "\n");
		return null;
	}
	@Override
	public void showAllEmployees() {
		System.out.println("All the Employees are : \n");
		for(int i=0; i<numberOfEmployees; i++) {
			     if(employees[i]!= null) {
			    	 System.out.println("Index : "+(i+1)+" Employee Name : "+employees[i].getName()+" ID : "+employees[i].getEmpId()+"Salary : "+employees[i].getSalary()+"\n");
			    	 System.out.println();
			}
		}
	}
	//Implementing CustomerOperations interface
		@Override
		public void insertCustomer(Customer c) {
			try {
				File customerFile = new File("Customer File.txt");
				
				if(!customerFile.exists()) 
					customerFile.createNewFile();
				
				FileWriter fileWriter = new FileWriter(customerFile, true); //Set true for append mode
			    PrintWriter printWriter = new PrintWriter(fileWriter);
			    
	
			    printWriter.println("Name : " +c.getName()+"\nNID : "+c.getNid()+"\nAccounts :  "+c.getAccounts().toString());
			    
			    printWriter.close();
				fileWriter.close();
				System.out.println("Customer information inserted Successfully.");
			}
			catch(IOException ex) {
				System.out.println("Couldn't open the file!!!!");
			}
		}
		@Override
		public Customer getCustomer(int nid) {
			for(int i=0; i<numberOfCustomers; i++) {
				if(nid == customers[i].getNid()) {
					return customers[i];
				}
			}
			System.out.println("Sorry!  Couldn't find any Customer of NID " +nid+ "\n");
			return null;
		}
		@Override
		public void showAllCustomers() {
			System.out.println("All the Customers : \n");
			for(int i=0; i<numberOfCustomers; i++) {
				     if(customers[i]!= null) {
				    	 System.out.println("Index : "+(i+1)+" Customer Name : "+customers[i].getName()+" NID : "+customers[i].getNid()+"\n");
				    	 System.out.println();
				}
			}
		}
		
}

