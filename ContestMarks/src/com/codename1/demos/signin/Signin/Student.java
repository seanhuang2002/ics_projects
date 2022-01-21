package com.codename1.demos.signin.Signin;

public class Student {
	private String name;
	private String gradeYear;
	private String email;
	public Student(String name, String gradeYear, String email)
	{
		this.name=name;
		this.gradeYear=gradeYear;
		this.email=email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGradeYear() {
		return gradeYear;
	}
	public void setGradeYear(String gradeYear) {
		this.gradeYear = gradeYear;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
