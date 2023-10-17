package com.jsp.Controller;

import com.jsp.service.LibrarianService;

public class IssueBook {
	
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		boolean res = librarianService.issueBookById(2,2,1);
		System.out.println(res);
	}

}
