package com.jsp.service;

import java.util.List;

import com.jsp.Dao.BookDao;
import com.jsp.Dao.LibrarianDao;
import com.jsp.Dao.StudentDao;
import com.jsp.Dto.Book;
import com.jsp.Dto.Librarian;
import com.jsp.Dto.Student;

public class LibrarianService {

	LibrarianDao librarianDao = new LibrarianDao();
	BookDao bookDao = new BookDao();
	StudentDao studentDao = new StudentDao();

	// ======================================================================

	public Librarian saveLibrarian(Librarian librarian) {
		librarian.setStatus("Unapproved");
		return librarianDao.saveLibrarian(librarian);
	}

	// =======================================================================

	public Librarian deleteLibrarianById(int id) {
		Librarian librarian = getLibrarianById(id);
		if (librarian != null) {
			return librarianDao.deleteLibrarianById(id);
		}
		return null;
	}

	// ===================================================================================

	public Librarian updateLibrarianNameById(int id, String newname) {
		Librarian librarian = getLibrarianById(id);
		if (librarian != null) {
			return librarianDao.updateLibrarianNameById(id, newname);
		}
		return null;
	}

	// ====================================================================================

	public Librarian updateLibrarianMailById(int id, String newmail) {
		Librarian librarian = getLibrarianById(id);
		if (librarian != null) {
			return librarianDao.updateLibrarianMailById(id, newmail);
		}
		return null;
	}

	// ====================================================================================

	public Librarian getLibrarianById(int id) {
		return librarianDao.getLibrarianById(id);
	}

	// =================================================================================

	public List<Librarian> getAllLibrarians() {
		return librarianDao.getAllLibrarians();
	}

	// ===================================================================================

	public Boolean addBook(Book book) {
		BookDao bookDao = new BookDao();
		bookDao.saveBook(book);
		return true;
	}

	// ===================================================================================

	public Boolean removeBookById(int bookid) {
		BookDao bookDao = new BookDao();
		bookDao.deleteBookById(bookid);
		return true;
	}

	// ===================================================================================

	public boolean issueBookById(int bookid, int libid, int studid) {
		Book book = bookDao.getBookById(bookid);
		Librarian librarian = librarianDao.getLibrarianById(libid);
		
		if (librarian.getStatus().equals("Approved"))   {
			System.out.println(librarian.getStatus());
			System.out.println(book.getStatus().equals("Available"));
			
			if (book.getStatus().equals("Avaliable")) {
				System.out.println(book.getStatus());
				
				Student student = studentDao.getStudentById(studid);
				
				if (librarian != null && student != null && book != null) {
					book.setStatus("Issued");
					book.setStudent(student);
					book.setLibrarian(librarian);
					
					boolean issued = bookDao.issue(book);
					if(issued) {
						System.out.println("Book issued Successfully");
					}else {
						System.out.println("Failed to issue the book");
					}
					return issued;
				}else {
					System.out.println("Student or librarian not found");
				}
			} else {
				System.out.println("Book is not available");
			}
		} else {
			System.out.println("Librarian is unauthorised");
		}
		return false;
	}

	// =====================================================================================

//	public boolean issueBookById(int bookid, int libid, int studid) {
//		Book book = bookDao.getBookById(bookid);
//		Librarian librarian = librarianDao.getLibrarianById(libid);
//
//		if (librarian.getStatus().equalsIgnoreCase("Approved")) {
//			System.out.println(librarian.getStatus());
//			System.out.println(book.getStatus().equals("Available"));
//			if (book.getStatus().equals("Available")) {
//				
//				System.out.println(book.getStatus());
//				Student student = studentDao.getStudentById(studid);
//				
//				if (student != null && librarian != null && book!=null) {
//					book.setStatus("Issued");
//					book.setStudent(student);
//					book.setLibrarian(librarian);
//
//					boolean issued = bookDao.issue(book);
//					if (issued) {
//						System.out.println("Book issued successfully.");
//					} else {
//						System.out.println("Failed to issue the book.");
//					}
//					return issued;
//				} else {
//					System.out.println("Student or librarian not found.");
//				}
//			} else {
//				System.out.println("Book is not available.");
//			}
//		} else {
//			System.out.println("Librarian is Unauthorised");
//		}
//		return false;
//	}

	// ========================================================================================

	public boolean returnBookById(int bookid) {
		Book book = bookDao.getBookById(bookid);
		if (book != null && book.getStatus().equals("Issued")) {
			Student student = book.getStudent();
			Librarian librarian = book.getLibrarian();

			if (student != null && librarian != null) {
				book.setStatus("Available");
				book.setStudent(null);
				book.setLibrarian(null);
				return bookDao.returnBook(book);
			}
			return true;
		}
		return false;
	}
}
