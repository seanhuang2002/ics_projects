package com.codename1.demos.signin.Signin;

public class Entry {
	Student student = new Student(null,null,null);
	String contestName;
	int mark;
	public Entry(Student student, String contestName, int mark) 
	{
		this.student=student;
		this.contestName=contestName;
		this.mark=mark;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getContestName() {
		return contestName;
	}
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	

}
