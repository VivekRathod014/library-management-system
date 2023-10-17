package com.jsp.Controller;

import com.jsp.service.LibrarianService;

public class LibrarianGetAllController {
	public static void main(String[] args) {
		
		LibrarianService librarianService = new LibrarianService();
		librarianService.getAllLibrarians();
	}

}
