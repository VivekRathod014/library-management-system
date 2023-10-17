package com.jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.Dto.Admin;

public class AdminDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vivek");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public Admin saveAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}
	
	public Admin deleteAdminById(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		
		if(admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
		} else {
			System.out.println("Not Deleted");
		}
		return admin;
	}
	
	public Admin updateNameByIdPass(int id, String newname) {
		Admin admin = entityManager.find(Admin.class, id);
		admin.setName(newname);
		
		if(admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();	
		}
		return admin;
	}
	
	
	public Admin updateNameById(int id, String newname) {
		Admin admin = entityManager.find(Admin.class, id);
		admin.setName(newname);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}
	
	public Admin updateUsernameByIdPass(int id, String newusername) {
		Admin admin = entityManager.find(Admin.class, id);
		admin.setUsername(newusername);
		
		if(admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
		}
		return admin;
	}
	
	public Admin updatePasswordByIdPass(int id, String newpassword) {
		Admin admin = entityManager.find(Admin.class, id);
		admin.setPassword(newpassword);
		
		if(admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
		}
		return admin;
	}
	
	public Admin getAdminById(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		System.out.println("========================");
		System.out.println(admin.getId() + " " + "| ");
		System.out.println(admin.getName() + " " + "| ");
		System.out.println(admin.getUsername() + " " + "| ");
		System.out.println(admin.getPassword() + " " + "| ");
		System.out.println("=========================");
		return admin;
	}
	
	public List<Admin> getAllAdmins() {
		String sql = "SELECT a FROM Admin a";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		for(Admin a : admins) {
			System.out.println("=======================");
			System.out.println(a.getId() + " " + "| ");
			System.out.println(a.getName() + " " + "| ");
			System.out.println(a.getUsername() + " " + "| ");
			System.out.println(a.getPassword() + " " + "| ");
			System.out.println("========================");
		}
		return admins;
	}
}
