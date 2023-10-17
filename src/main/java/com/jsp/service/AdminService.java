package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.Dao.AdminDao;
import com.jsp.Dao.LibrarianDao;
import com.jsp.Dto.Admin;
import com.jsp.Dto.Librarian;

public class AdminService {

	AdminDao adminDao = new AdminDao();
	LibrarianDao librarianDao = new LibrarianDao();
	
	//========================================================================
	
	public boolean validateAdmin(int id, String loginusername, String loginpassword) {
		Admin admin = adminDao.getAdminById(id);
		if(admin.getUsername().equals(loginusername) && admin.getPassword().equals(loginpassword)) {
			return true;
		}else {
			return false;
		}
	}
	
	//==========================================================================
	
	public void viewUnauthorisedLibrarians() {
		
	}
	
	//============================================================================
	
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}
	
	//============================================================================
	
	public Admin deleteAdminById(int id) {
		return adminDao.deleteAdminById(id);
	}
	
	//=============================================================================
	
	public Admin updateNameByIdPass(int id, String newname) {
		return adminDao.updateNameByIdPass(id, newname);
	}
	
	//=============================================================================
	
	public Admin updateNameById(int id, String newname) {
		Admin admin = getAdminById(id);
		if (admin != null) {
			return adminDao.updateNameById(id, newname);
		}
		return null;
	}
	
	//===================================================================================
	
	public Admin updateUsernameByIdPass(int id, String username, String password, String newusername) {
		if(validateAdmin(id, username, password) == true) {
			return adminDao.updateUsernameByIdPass(id, newusername);
		}else {
			return null;
		}
	}
	
	//==============================================================================
	
	public Admin updatePasswordByIdPass(int id, String usrename, String password, String newpassword) {
		if(validateAdmin(id, usrename, password) == true) {
			return adminDao.updatePasswordByIdPass(id, newpassword);
		}else {
			return null;
		}
	}
	
	//==============================================================================
	
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}
	
	//================================================================================
	
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}
	
	//===========================================================================
	
	public boolean approveLibrarianById(int libid, int adminid) {
		Librarian librarian = librarianDao.getLibrarianById(libid);
		Admin admin = adminDao.getAdminById(adminid);
		if(librarian != null && admin != null) {
			librarian.setStatus("Approved");
			librarian.setAdmin(admin);
			return librarianDao.approve(librarian);
		}
		
		return false;
	}
	
	//===================================================================================
	
	public boolean rejectLibrarianById(int libid, int adminid) {
		Librarian librarian = librarianDao.getLibrarianById(libid);
		Admin admin = adminDao.getAdminById(adminid);
		if (librarian != null && admin != null) {
			librarian.setStatus("Rejected");
			librarian.setAdmin(admin);
			return librarianDao.approveReject(librarian);
		}
		return false;
	}
	
	//=======================================================================================
	
	public List<Librarian> viewAllUnapprovedLibrarians() {
		LibrarianService librarianService = new LibrarianService();
		List<Librarian> librarians = librarianService.getAllLibrarians();
		List<Librarian> unapprovedLibs = new ArrayList<Librarian>();
		for (Librarian librarian : librarians) {
			if (librarian.getStatus().equals("Unapproved")) {
				unapprovedLibs.add(librarian);
			}
		}
		return unapprovedLibs;
	}

}
