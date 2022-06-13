package com.springbootrediscacheexample.controllertest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import com.springbootrediscacheexample.controller.StudentController;
import com.springbootrediscacheexample.service.StudentService;
import com.springbootrediscacheexample.student.Student;

@SpringBootTest
public class StudentControllerTest {

	@InjectMocks
	StudentController studentController;
	
	@Mock
	StudentService studentService;
	
	@Mock
	Student student; 
	
	@Test
	void saveStudent() 
	{ 
		
		Mockito.when(studentService.saveStudent(Mockito.any(Student.class))).thenReturn(student);
		
		Student response = studentController.saveStudent(studentData());
		
		assertEquals(student, response);
		
	}
	
	public Student studentData()
	{
		Student student = new Student();
		
		student.setStudentid(111);
		student.setStudentname("Prasanna");
		student.setStudentfee(5000);
		
		return student;
	}
	
//	@Test
//	void updateStudent() {
//		Mockito.when(studentService.updateStudent(Mockito.anyInt(),Mockito.any(Student.class))).thenReturn(student);
//		
//		Student response=studentController.updateStudent(studentData());
//	
//		assertEquals(student, response);
//	}
	
	@Test
	void delete() {
		studentService.deleteStudent(111);
		assertEquals(111,studentController.deleteStudent(student.getStudentid()));
	}
	
	@Test
	void getAllStudent() {
		
		List<Student> list=new ArrayList<>();
		Student studen1=new Student(1,"prasanna",5000);
		Student student2=new Student(2,"tulasi",6000);
		Student student3=new Student(3,"uma",6500);
		
		list.add(studen1);
		list.add(student2);
		list.add(student3);
		
		Mockito.when(studentService.getAllStudents()).thenReturn(list);
		List<Student> response=studentController.getallStudent();
		assertEquals(list,response);
	}
	@Test
	void getOneStudent() {
		Mockito.when(studentService.getoneStudent(Mockito.anyInt())).thenReturn(null);
		Optional<Student> response=studentController.getoneStudent(student.getStudentid());
		assertEquals(111,response);
	}
}
