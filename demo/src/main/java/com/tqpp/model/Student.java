package com.tqpp.model;

public class Student {

	private int sid;
	private String studentname;
	private String qualification;
	private String placed;
	public Student(int sid, String studentname, String qualification, String placed) {
		super();
		this.sid = sid;
		this.studentname = studentname;
		this.qualification = qualification;
		this.placed = placed;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getPlaced() {
		return placed;
	}
	public void setPlaced(String placed) {
		this.placed = placed;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", studentname=" + studentname + ", qualification=" + qualification + ", placed="
				+ placed + "]";
	}



}
