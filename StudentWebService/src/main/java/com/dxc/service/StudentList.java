package com.dxc.service;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.dxc.beans.Student;

@XmlRootElement(name="student")
public class StudentList {
	
	List<Student> students;

	public StudentList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentList(List<Student> students) {
		super();
		this.students= students;
	}

	public List<Student> getStudents(){
		return students;
		
	}
	
	@XmlElement(name="student")
	public void setStudents(List<Student> students) {
		this.students= students;
	}
}
