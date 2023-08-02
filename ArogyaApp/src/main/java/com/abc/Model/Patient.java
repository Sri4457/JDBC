package com.abc.Model;

import java.sql.Date;

public class Patient {

	String name, gender, aadhar_card_number, city, address, guardian_name, guardian_address, status;
	  Date date_of_admission;
	  String contact_number, guardian_contact_number;
	  int age;
	  int id;
	  
	
	public Patient(String name, String gender, String aadhar_card_number, String city, String address,
			String guardian_name, String guardian_address, 
			String contact_number, String guardian_contact_number, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.aadhar_card_number = aadhar_card_number;
		this.city = city;
		this.address = address;
		this.guardian_name = guardian_name;
		this.guardian_address = guardian_address;
		this.contact_number = contact_number;
		this.guardian_contact_number = guardian_contact_number;
		this.age = age;
	}
	public Patient() {
		
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getid() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAadhar_card_number() {
		return aadhar_card_number;
	}
	public void setAadhar_card_number(String aadhar_card_number) {
		this.aadhar_card_number = aadhar_card_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGuardian_name() {
		return guardian_name;
	}
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}
	public String getGuardian_address() {
		return guardian_address;
	}
	public void setGuardian_address(String guardian_address) {
		this.guardian_address = guardian_address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDate_of_admission() {
		return date_of_admission;
	}
	public void setDate_of_admission(Date date_of_admission) {
		this.date_of_admission = date_of_admission;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getGuardian_contact_number() {
		return guardian_contact_number;
	}
	public void setGuardian_contact_number(String guardian_contact_number) {
		this.guardian_contact_number = guardian_contact_number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	  
}
