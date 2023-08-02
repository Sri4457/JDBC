package com.abc.Dao;

import java.util.ArrayList;

import com.abc.Model.Patient;

public interface AarogyaMethods {

	public boolean addMember(Patient p);
	  public ArrayList<Patient> viewAllMembers();
	  public Patient viewByAadharCard(String acm);
	  public ArrayList<Patient> viewByCity(String city);
	  public ArrayList<Patient> viewByAge(int a,int b);
	  public boolean markRecoverMember(String a);
	  public boolean deleteMember(String a);
}
