package com.gl.student.registration.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.student.registration.dao.StudentRegistrationDao;
import com.gl.student.registration.entity.Student;

@Repository
public class StudentRegistrationDaoImpl implements StudentRegistrationDao{


	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	StudentRegistrationDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}


	}

	@Override
	public void save(Student theStudent) {
		
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theStudent);


		tx.commit();
		
	}

	@Override
	public List<Student> finAll() {
//		}
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Student> students=session.createQuery("from Student").list();

		tx.commit();


		return students;
	}
}
