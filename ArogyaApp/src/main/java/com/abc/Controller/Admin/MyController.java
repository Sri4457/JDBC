package com.abc.Controller.Admin;

import java.util.Scanner;

import com.abc.Dao.AarogyaMethodsImple;
import com.abc.Dao.CheckingParameters;
import com.abc.Model.Patient;

public class MyController {

	static Scanner sc=new Scanner(System.in);
	CheckingParameters c=new CheckingParameters();
	AarogyaMethodsImple dao=new AarogyaMethodsImple();
	
	static long choicesEmployee() {
		System.out.println("Press 1 to view list of all available members");
		System.out.println("Press 2 to search member by Aadhar card");
		System.out.println("Press 3 to search member from a particular city");
		System.out.println("Press 4 to search member from a particular age group");
		System.out.println("Press 0 to exit");
		long option = sc.nextLong();
		return option;
	}
	static long choicesAdmin() 
	{
		System.out.println("Press 1 for adding new member");
		System.out.println("Press 2 to mark recovery of a member");
		System.out.println("Press 3 to delete data of a member");
		System.out.println("Press 0 to exit");
		// create scanner class to take input
		long option = sc.nextLong();
		return option;
	}
	
		
	public static void main(String[] args) {
		MyController obj=new MyController();
		while(true){
	    	System.out.println("Enter The Role ");
			System.out.println("1. Admin");
			System.out.println("2. Employee");
			System.out.println("3. Exit");
			int opt=sc.nextInt();
	  		if(opt==1)
	  		{
	  			while (true) {
	  				long option = choicesAdmin();
	  				if (option < 0 || option > 3) {
	  				System.out.println("Please Enter Valid Option");
	  				}
	  				// take the input and add in the arrayList
	  				else if (option == 1) {
	  				obj.addMember();
	  				}
	  				else if (option == 2) {
	  				obj.markRecoverMember();
	  				}
	  				else if (option == 3) {
	  				obj.deleteMember();
	  				}
	  				
	  				else{
	  					System.out.println();
	  				break;
	  				}
				}
			}
			else if(opt==2){
				while (true) {
					long option = choicesEmployee();
					if (option < 0 || option > 4) {
					System.out.println("Please Enter Valid Option");
					}
					// take the input and add in the arrayList
					else if (option == 1) {
					obj.viewAllMembers();
					}
					else if (option == 2) {
					obj.viewByAadharCard();
					}
					else if (option == 3) {
					obj.viewByCity();
					}
					else if (option == 4) {
						obj.viewByAge();
						}	
					else {
						System.out.println();
					break;
					}
				}
			}
	      else{
	      System.out.println("***************Thank You*******************");
	      break;
	      }
		}

	}
	private void viewByAge() {
		System.out.println("Enter Age1");
		int a=sc.nextInt();
		System.out.println("Enter Age2");
		int b=sc.nextInt();
		for(Patient p:dao.viewByAge(a, b))
		{
			dao.display(p);
		}
		
	}
	private void viewByCity() {
		sc.nextLine();
		System.out.println("Enter city");
		String city=sc.nextLine();
		for(Patient p:dao.viewByCity(city))
		{
			dao.display(p);
		}
		
	}
	private void viewByAadharCard() {
		sc.nextLine();
		System.out.println("Enter Aadhar Card Number which is of length 10");
		String aadhar_card_number=sc.nextLine();
		Patient rs=dao.viewByAadharCard(aadhar_card_number);
		System.out.println("The Id : "+rs.getid());
		System.out.println("The Member Name : "+rs.getName());
		System.out.println("The Member Aadhar card number : "+rs.getAadhar_card_number());
		System.out.println("The Member Gender : "+rs.getGender());
		System.out.println("The Member age : "+rs.getAge());
		System.out.println("The Member city : "+rs.getCity());
		System.out.println("The Member address : "+rs.getAddress());
		System.out.println("The Member contact number : "+rs.getContact_number());
		System.out.println("The Member guardian name : "+rs.getGuardian_name());
		System.out.println("The Member guardian address : "+rs.getGuardian_address());
		System.out.println("The Member guardian contact number : "+rs.getGuardian_contact_number());
		System.out.println("The Status of the Patient: "+rs.getStatus());
		System.out.println("The Time when member admitted  : "+rs.getDate_of_admission());
		System.out.println("=========================================================");
	}
	private void viewAllMembers() {
		for(Patient p:dao.viewAllMembers())
		{
			dao.display(p);
		}
		
	}
	private void deleteMember() {
		sc.nextLine();
		System.out.println("Enter Aadhar Card Number which is of length 10");
		String aadhar_card_number=sc.nextLine();
		if(dao.deleteMember(aadhar_card_number))
		{
			System.out.println("Done");
		}
		else {
			System.out.println("No");
		}
		
		
	}
	private void markRecoverMember() {
		sc.nextLine();
		System.out.println("Enter Aadhar Card Number which is of length 10");
		String aadhar_card_number=sc.nextLine();
		if(dao.markRecoverMember(aadhar_card_number))
		{
			System.out.println("Done");
		}
		else {
			System.out.println("No");
		}
		
	}
	private void addMember() {
		sc.nextLine();
		System.out.println("Enter Aadhar Card Number which is of length 10");
		String aadhar_card_number=sc.nextLine();
		System.out.println("Enter name ");
		String name=sc.nextLine();
		System.out.println("Enter Gender");
		String gender=sc.nextLine();
		System.out.println("Enter City");
		String city=sc.nextLine();
		System.out.println("Enter Address");
		String address=sc.nextLine();
		System.out.println("Enter Gaurdian Name");
		String guardian_name=sc.nextLine();
		System.out.println("Enter Gaurdian Addres");
		String guardian_address=sc.nextLine();
		System.out.println("Enter Contact Number");
		String contact_number=sc.nextLine();
		System.out.println("Enter Gaurdian Contact Number");
		String guardian_contact_number=sc.nextLine();
		System.out.println("Enter the age");
		int age=sc.nextInt();
		Patient p=new Patient(name,gender,aadhar_card_number,city,address,guardian_name,guardian_address,contact_number,guardian_contact_number,age);
		if(c.checkAadhar(aadhar_card_number) && c.checkMobile(contact_number) &&c.checkMobile(guardian_contact_number))
		{
			dao.addMember(p);
		}
		
	}

}
