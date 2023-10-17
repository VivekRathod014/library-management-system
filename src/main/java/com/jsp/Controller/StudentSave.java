package com.jsp.Controller;

import com.jsp.Dto.Student;
import com.jsp.service.StudentService;

public class StudentSave {
	
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		Student student = new Student();

		student.setName("vikram");
		student.setMail("vikram@gmail.com");
		
		Student student1 = new Student();
		student1.setName("Prafull");
		student1.setMail("Praful@gmail.com");

		studentService.saveStudent(student);
		studentService.saveStudent(student1);
		
		
	}

}
