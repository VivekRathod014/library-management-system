package com.jsp.Controller;

import com.jsp.service.LibrarianService;

public class LibrarianDeleteController {
	public static void main(String[] args) {
		
		LibrarianService librarianService = new LibrarianService();
		librarianService.deleteLibrarianById(1);
	}

}
