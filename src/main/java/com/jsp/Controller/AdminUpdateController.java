package com.jsp.Controller;

import com.jsp.service.AdminService;

public class AdminUpdateController {
	
	public static void main(String[] args) {
		
		AdminService adminService = new AdminService();
		adminService.updateUsernameByIdPass(1, "mno", "pqr", "username");
	}

}
