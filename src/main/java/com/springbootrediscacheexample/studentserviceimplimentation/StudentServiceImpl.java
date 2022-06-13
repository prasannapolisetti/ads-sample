package com.springbootrediscacheexample.studentserviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.springbootrediscacheexample.exception.StudentNotFoundException;
import com.springbootrediscacheexample.service.StudentService;
import com.springbootrediscacheexample.student.Student;
import com.springbootrediscacheexample.studentrepository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}
	

	@Override
	@CacheEvict(value="Student",key="#studentid")
	public void deleteStudent(Integer studentid) {
		
		Student response=studentRepository.findById(studentid).orElseThrow(()-> new StudentNotFoundException("student not found"));
		studentRepository.delete(response);
	}

	@Override
	@Cacheable(value="Student",key="#studentid")
	public Optional<Student> getoneStudent(Integer studentid) {
		Optional<Student> response=studentRepository.findById(studentid);//.orElseThrow(()-> new StudentNotFoundException("student not found"));
		return response;
	}

	@Override
	@Cacheable(value="Student")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	@CachePut(value="student",key="studentid")
	public Student updateStudent(Student student,Integer studentid) {
		
		Student response=studentRepository.findById(studentid).orElseThrow(()-> new StudentNotFoundException("student not found"));
		response.setStudentname(student.getStudentname());
		response.setStudentfee(student.getStudentfee());
		
		return studentRepository.save(student);
	}




}
