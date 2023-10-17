package com.jsp.Controller;

import com.jsp.service.AdminService;

public class AdminDeleteController {
	
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		adminService.deleteAdminById(0);
	}

}
