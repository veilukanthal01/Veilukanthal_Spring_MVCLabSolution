package com.gl.student.registration.service;

import java.util.List;

import com.gl.student.registration.entity.Student;

public interface StudentRegistrationService {
	public void save(Student theStudent);
	public List<Student> finAll();

}
