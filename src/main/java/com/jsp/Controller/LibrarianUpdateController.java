package com.jsp.Controller;

import com.jsp.service.LibrarianService;

public class LibrarianUpdateController {
	
	public static void main(String[] args) {
		LibrarianService librarianService = new LibrarianService();
		librarianService.updateLibrarianNameById(1, "lib1");
	}

}
