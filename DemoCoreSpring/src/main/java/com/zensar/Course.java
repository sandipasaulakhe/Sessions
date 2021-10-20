package com.zensar;

import org.springframework.stereotype.Component;

@Component
public class Course {
private int cid;
private String coursename;
private int fees;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}


public class Course(int cid, String coursename, int fees) {
	super();
	System.out.println("in 3 para constr of course");
	this.cid = cid;
	this.coursename = coursename;
	this.fees = fees;
}
public Course() {
	super();
	System.out.println("in default constructor of course");
}
@Override
public String toString() {
	return "Course [cid=" + cid + ", coursename=" + coursename + ", fees=" + fees + "]";
}


}
 
