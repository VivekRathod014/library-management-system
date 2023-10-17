package com.jsp.Controller;

import com.jsp.service.AdminService;

public class AdminGetController {
	public static void main(String[] args) {
		
		AdminService adminService = new AdminService();
		adminService.getAdminById(0);
	}

}
