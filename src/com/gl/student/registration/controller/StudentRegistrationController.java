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

	@RequestMapping("/")
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
		
		if(studentId!=0)
		{
			theStudent=studentService.findById(studentId);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}

		else
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
	
	@RequestMapping("/student/search")
	public String search(@RequestParam("name") String name,
			@RequestParam("department") String department,
			Model theModel) {

		// check names, if both are empty then just give list of all Books

		if (name.trim().isEmpty() && department.trim().isEmpty()) {
			return "redirect:/student/list";
		}
		else {
			// else, search by first name and last name
			List<Student> students =
					studentService.searchBy(name, department);

			// add to the spring model
			theModel.addAttribute("Students", students);

			// send to list-Books
			return "list-students";
		}

	}
	
	@RequestMapping("/student/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int studentId,
			Model theModel) {

		// get the Book from the service
		Student theStudent = studentService.findById(studentId);


		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "student-registration-form";			
	}
	
	@RequestMapping("/student/delete")
	public String delete(@RequestParam("studentId") int studentId) {

		// delete the Book
		studentService.deleteById(studentId);

		// redirect to /Books/list
		return "redirect:/student/list";

	}


}
