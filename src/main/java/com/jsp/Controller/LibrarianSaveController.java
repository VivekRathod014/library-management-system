package com.jsp.Controller;

import com.jsp.Dto.Librarian;
import com.jsp.service.LibrarianService;

public class LibrarianSaveController {
	
	public static void main(String[] args) {
		
		LibrarianService librarianService = new LibrarianService();
		Librarian librarian1 = new Librarian();
		
		librarian1.setName("Tushar");
		librarian1.setMail("Tushar@gmail.com");
		librarian1.setStatus("approved");
		
		Librarian librarian2 = new Librarian();
		librarian2.setName("Prakash");
		librarian2.setMail("Prakash@gmail.com");
		librarian2.setStatus("approved");
		
	    librarianService.saveLibrarian(librarian1);
	    librarianService.saveLibrarian(librarian2);
	}

}
