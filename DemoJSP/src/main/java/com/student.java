package com;

public class Student {
private int sid;
private String name;
private String qualification;
private String placed;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public Student(int sid, String name, String qualification, String placed) {
	super();
	this.sid = sid;
	this.name = name;
	this.qualification = qualification;
	this.placed = placed;
}
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [sid=" + sid + ", name=" + name + ", qualification=" + qualification + ", placed=" + placed + "]";
}


}
