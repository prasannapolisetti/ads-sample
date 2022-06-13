package com.springbootrediscacheexample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrediscacheexample.service.StudentService;
import com.springbootrediscacheexample.student.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentService studentservice;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentservice.saveStudent(student);
	}
	
	@GetMapping("/getone/{studentid}")
	public Optional<Student> getoneStudent(@PathVariable Integer studentid) {
		return studentservice.getoneStudent(studentid);
	}
	
	@GetMapping("/getall")
	public List<Student> getallStudent() {
		return studentservice.getAllStudents();
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@RequestBody Student student,Integer studentid) {
		return studentservice.updateStudent(student, studentid);
	}
	
	@DeleteMapping("/studentdetails/{studentid}")
	public String  deleteStudent(@PathVariable Integer studentid) {
		studentservice.deleteStudent(studentid);
		return "student with id: "+studentid+"deleted";
	}
}
