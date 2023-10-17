package com.jsp.Controller;

import com.jsp.service.LibrarianService;

public class LibrarianGetController {
	public static void main(String[] args) {
		
		LibrarianService librarianService = new LibrarianService();
		librarianService.getLibrarianById(1);
	}

}
