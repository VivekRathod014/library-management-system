package com.jsp.Controller;

import com.jsp.service.StudentService;

public class StudentUpdateName {
	
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		if (studentService.updateStudentNameById(1, "Jay") != null) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
	}

}
