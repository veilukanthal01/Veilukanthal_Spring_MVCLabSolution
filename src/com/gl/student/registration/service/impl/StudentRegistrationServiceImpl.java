package com.gl.student.registration.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.student.registration.dao.StudentRegistrationDao;
import com.gl.student.registration.entity.Student;
import com.gl.student.registration.service.StudentRegistrationService;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService{
	
	@Autowired
	StudentRegistrationDao studentRegistrationDao;

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentRegistrationDao.save(theStudent);
	}

	@Override
	public List<Student> finAll() {
		// TODO Auto-generated method stub
		return studentRegistrationDao.finAll();
	}
	

}
