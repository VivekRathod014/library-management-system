package com.jsp.Controller;

import com.jsp.Dto.Book;
import com.jsp.service.BookService;

public class BookSave {
	
	public static void main(String[] args) {
		BookService bookService = new BookService();
		Book book = new Book();
		book.setName("Book1");
		book.setStatus("Issued");
		bookService.saveBook(book);
		
		
		Book book1 = new Book();
		book1.setName("Book2");
		book.setStatus("Not Issued");
		bookService.saveBook(book1);
	}

}
