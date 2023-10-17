package com.jsp.Controller;

import com.jsp.service.AdminService;

public class AdminGetAllController {
	
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		adminService.getAllAdmins();
	}

}
