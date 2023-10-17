package com.jsp.Controller;

import com.jsp.Dto.Librarian;
import com.jsp.service.LibrarianService;

public class SaveAdminLibrarian {
	
	public static void main(String[] args) {
		
		LibrarianService librarianService = new LibrarianService();
		Librarian librarian = new Librarian();
		
		librarian.setName("xyz");
		librarian.setMail("xyz@gmail.com");
		librarian.setStatus("approved");
		
		librarianService.saveLibrarian(librarian);
	}

}
