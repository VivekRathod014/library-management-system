package com.jsp.Controller;

import com.jsp.service.BookService;

public class BookUpdate {
	
	public static void main(String[] args) {
		BookService bookService = new BookService();
		if (bookService.updateBookNameById(1, "Not Available") != null) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
	}

}
