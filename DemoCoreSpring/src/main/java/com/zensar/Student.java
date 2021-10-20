package com.zensar;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("s1")
@Scope("prototype")

public class Student {
private String sid;
private String sname;
private int per;
@Autowired
private Course course;
private List<String> hobbies;
private Map<String,Long> map;
@Autowired
@Qualifier("iphone")
private Mobile mobile;

public Student() {
	// TODO Auto-generated constructor stub
	System.out.println("in def of stud");
}


@Override
public String toString() {
	return "Student [sid=" + sid + ", sname=" + sname + ", per=" + per + ", course=" + course + ", hobbies=" + hobbies
			+ ", map=" + map + ", mobile=" + mobile + "]";
}

}


