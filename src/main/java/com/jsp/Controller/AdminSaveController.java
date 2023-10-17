package com.jsp.Controller;

import com.jsp.Dto.Admin;
import com.jsp.service.AdminService;

public class AdminSaveController {
	
	public static void main(String[] args) {
		
		AdminService adminService = new AdminService();
		Admin admin = new Admin();
		
		admin.setName("jay");
		admin.setUsername("abcd");
		admin.setPassword("pqrs");
		adminService.saveAdmin(admin);
	}

}
