package com.luv2code.springdemo.entity;

public class Student {
	
	private String firstName;
	private String lastNname;
	
	public Student() {
		
	}

	public Student(String firstName, String lastNname) {
		this.firstName = firstName;
		this.lastNname = lastNname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNname() {
		return lastNname;
	}

	public void setLastNname(String lastNname) {
		this.lastNname = lastNname;
	}

}
