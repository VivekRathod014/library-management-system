package com.jsp.Controller;

import com.jsp.service.StudentService;

public class StudentUpdate {
	
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		if (studentService.updateStudentMailById(1, "jay@mail.com") != null) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
	}

}
