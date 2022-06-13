package com.springbootrediscacheexample.servicetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootrediscacheexample.student.Student;
import com.springbootrediscacheexample.studentrepository.StudentRepository;
import com.springbootrediscacheexample.studentserviceimplimentation.StudentServiceImpl;

@SpringBootTest
public class StudentServiceTest {

	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	
	@Mock
	StudentRepository studentRepository;
	

@Mock
Student student1;

@BeforeEach
public void initEach() {
	
System.out.println("before each method  ");
}

@Test
public void getonestudent() {
	

Optional<Student> studentobj=Optional.ofNullable(student1);
	Mockito.when(studentRepository.findById(1)).thenReturn(studentobj);
	Optional<Student> response=studentServiceImpl.getoneStudent(1); 
	assertEquals(studentobj,response);

}
	@Test
	public void getAllStudents() {
		List<Student> list=new ArrayList<>();
		Student studen1=new Student(1,"prasanna",5000);
		Student student2=new Student(2,"tulasi",6000);
		Student student3=new Student(3,"uma",6500);
		
		list.add(studen1);
		list.add(student2);
		list.add(student3);
		
		Mockito.when(studentRepository.findAll()).thenReturn(list);
		List<Student> student=studentServiceImpl.getAllStudents();
		assertEquals(3,student.size());
	}
	
	@Test
	public void deleteStudent() {
		Student student=new Student(1,"prasanna",5000);
		studentRepository.deleteById(1);
		 studentServiceImpl.deleteStudent(student.getStudentid());
	assertEquals(student ,student.getStudentid());
}
	@Test 
	public void updateStudent() {
		Student student=new Student(1,"prasanna",5000);
		student.setStudentname("sai");
		Mockito.when(studentRepository.save(Mockito.any())).thenReturn(student);
		Student response=studentServiceImpl.updateStudent(student, 1);
		assertEquals(1,student.getStudentname());
		
	}
	
	@Test
	public void saveStudent() {
		Student student=new Student(1,"tulasi",6000);
	Mockito.when(studentRepository.save(student)).thenReturn(student);
	Student response=studentServiceImpl.saveStudent(student);
	assertEquals(student,response);
	}
	
}
