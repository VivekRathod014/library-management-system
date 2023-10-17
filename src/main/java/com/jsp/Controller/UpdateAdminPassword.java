package com.jsp.Controller;

import com.jsp.service.AdminService;

public class UpdateAdminPassword {
	
	public static void main(String[] args) {

		AdminService adminService=new AdminService();
		
		if (adminService.updatePasswordByIdPass(2, "password", "password", "password1") != null) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
	}

}
