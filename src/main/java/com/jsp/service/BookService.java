package com.jsp.service;

import java.util.List;

import com.jsp.Dao.BookDao;
import com.jsp.Dto.Book;

public class BookService {
	
	BookDao bookDao = new BookDao();

	//==========================================================================
	
	public Book saveBook(Book book) {
		book.setStatus("Avaliable");
		return bookDao.saveBook(book);
	}

	//============================================================================
	
	public Book deleteBookById(int id) {
		Book book = getBookById(id);
		if (book != null) {
			return bookDao.deleteBookById(id);
		}
		return null;
	}
	
	//===============================================================================

	public Book updateBookNameById(int id, String newname) {
		Book book = getBookById(id);
		if (book != null) {
			return bookDao.updateBookNameById(id, newname);
		}
		return null;
	}
	
	//===============================================================================

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}
	
	//==================================================================================

	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
	
	//==================================================================================

}
