package com.springbootrediscacheexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootrediscacheexample.student.Student;


public interface StudentService {
	
	public Student saveStudent(Student student);
	public Student updateStudent(Student student,Integer studentid);
	public void deleteStudent(Integer studentid);
	public Optional<Student> getoneStudent(Integer studentid);
	public List< Student> getAllStudents();
	
	
}
