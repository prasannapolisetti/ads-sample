package com.springbootrediscacheexample.student;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student implements Serializable {
	
	private static final long serialVersionUID = -4683991213737928257L;
	@Id
	@GeneratedValue
	private Integer studentid;
	private String studentname;
	private double studentfee;
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public double getStudentfee() {
		return studentfee;
	}
	public void setStudentfee(double studentfee) {
		this.studentfee = studentfee;
	}
	public Student(Integer studentid, String studentname, double studentfee) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentfee = studentfee;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
