package com.gl.student.registration.dao;

import java.util.List;

import com.gl.student.registration.entity.Student;

public interface StudentRegistrationDao{
	public void save(Student theStudent);
	public List<Student> finAll();

}
