package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Dto.Librarian;

public class LibrarianDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vivek");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	
	//===================================================================================
	
	public Librarian saveLibrarian(Librarian librarian) {
		entityTransaction.begin();
		entityManager.persist(librarian);
		entityTransaction.commit();
		return librarian;
	}
	
	//to delete by id
	
	public Librarian deleteLibrarianById(int id) {
		Librarian librarian = entityManager.find(Librarian.class, id);
		
		if(librarian != null) {
			entityTransaction.begin();
			entityManager.persist(librarian);
			entityTransaction.commit();
		}else {
			System.out.println("Not Deleted");
		}
		return librarian;
	}
	
	//===================================================================================
	
	
	//to update name by id
	
	public Librarian updateLibrarianNameById(int id, String newname) {
		Librarian librarian = entityManager.find(Librarian.class, id);
		librarian.setName(newname);
		
		if(librarian != null) {
			entityTransaction.begin();
			entityManager.persist(librarian);
			entityTransaction.commit();
		}
		return librarian;
	}
	
	//=====================================================================================
	
	//to update mail by id
	public Librarian updateLibrarianMailById(int id, String newmail) {
		Librarian librarian = entityManager.find(Librarian.class, id);
		librarian.setMail(newmail);
		
		if(librarian != null) {
			entityTransaction.begin();
			entityManager.persist(librarian);
			entityTransaction.commit();
		}
		return librarian;	
	}
	
	//=======================================================================================
	
	//to get by id
	
	public Librarian getLibrarianById(int id) {
		Librarian librarian = entityManager.find(Librarian.class, id);
		System.out.println("=======================================");
		System.out.println(librarian.getId() + " " + "| ");
		System.out.println(librarian.getName() + " " + "| ");
		System.out.println(librarian.getMail() + " " + "| ");
		System.out.println(librarian.getStatus() + " " + "| ");
		System.out.println("========================================");
		return librarian;
	}
	
	//======================================================================================
	
	//to approve
	
	public boolean approve(Librarian librarian) {
		entityTransaction.begin();
		entityManager.persist(librarian);
		entityTransaction.commit();
		return true;
	}
	
	//to get all
	
	public List<Librarian> getAllLibrarians() {
		
		String sql = "SELECT l FROM Librarian l";
		Query query = entityManager.createQuery(sql);
		List<Librarian> librarian = query.getResultList();
		for(Librarian l : librarian) {
			System.out.println("=====================================");
			System.out.println(l.getId() + " " + "| ");
			System.out.println(l.getName() + " " + "| ");
			System.out.println(l.getMail() + " " + "| ");
			System.out.println(l.getStatus() + " " + "| ");
			System.out.println("======================================");
		}
		return librarian;
	}
	
	//===================================================================================
	
	public boolean approveReject(Librarian librarian) {
		entityTransaction.begin();
		entityManager.merge(librarian);
		entityTransaction.commit();
		return true;
	}

}
