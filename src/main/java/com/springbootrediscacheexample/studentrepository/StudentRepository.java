package com.springbootrediscacheexample.studentrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootrediscacheexample.student.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	

}
