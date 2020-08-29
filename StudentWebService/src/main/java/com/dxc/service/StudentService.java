package com.dxc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.beans.Student;

@RestController
public class StudentService {

	ArrayList<Student> students = new ArrayList<>();
	
	public StudentService() {
		students.add(new Student(101,"Sai","Sai@gmail.com","54135675"));
		students.add(new Student(102,"ram","ram@gmail.com","54135685"));
		students.add(new Student(103,"hari","hari@gmail.com","54139675"));
	}
	
	@RequestMapping(value="/student/{id}" , method=RequestMethod.GET)
	public Student getStudent(@PathVariable ("id") int id){
		System.out.println("INSIDE OF GETSTUDENT(single object)");
		Map<Integer , Student> studMap = new HashMap<>();
		for(Student student : students) {
			studMap.put(student.getId(), student);
		}
		return studMap.get(id);
	}
	
	@RequestMapping(value="/students" , method=RequestMethod.GET)
	public StudentList getStudents(){
		System.out.println("INSIDE OF GETSTUDENT(all object)");
		return getStudentList();
	}
	
	public StudentList getStudentList() {
		StudentList studentList = new StudentList(students);
		return studentList;
	}
	
	@RequestMapping(value="/students" , method=RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		System.out.println("INSIDE OF ADDSTUDENT");
		if(students.add(student)) {
			return student;
		}
		return null;
	}
	
	@RequestMapping(value="/students" , method=RequestMethod.PUT)
	public Student editStudent(@RequestBody Student stud) {
		System.out.println("INSIDE OF EDITSTUDENT");
		Map<Integer , Student> studMap = new HashMap<>();
		students.forEach(student->studMap.put(student.getId(), student));
	    if(studMap.replace(stud.getId(), 
	    		           studMap.get(stud.getId()), 
	    		           stud)){
	    	
	    	Set<Integer> idSet = studMap.keySet();
	    	students = new ArrayList<>();
	    	for(int id : idSet) {
	    		students.add(studMap.get(id));
	    	}
	    	
	    	return stud;
	    }
		return null;
		
	}
}
