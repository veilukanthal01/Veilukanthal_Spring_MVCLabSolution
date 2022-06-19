package com.gl.student.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.student.registration.entity.Student;
import com.gl.student.registration.service.StudentRegistrationService;

@Controller
public class StudentRegistrationController {

	@Autowired
	StudentRegistrationService studentService;

	@RequestMapping("/student")
	public String hello() {
		return "main-menu";
	}

	@RequestMapping("/student/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "student-registration-form";
	}

	@PostMapping("/student/save")
	public String saveBook(@RequestParam("studentId") int studentId, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(studentId);
		Student theStudent;

		theStudent = new Student(name, department, country);
		// save the Student
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/student/list";

	}

	@RequestMapping("/student/list")
	public String listBooks(Model theModel) {

		// get Books from db
		List<Student> students = studentService.finAll();

		// add to the spring model
		theModel.addAttribute("Students", students);

		return "list-students";
	}

}
