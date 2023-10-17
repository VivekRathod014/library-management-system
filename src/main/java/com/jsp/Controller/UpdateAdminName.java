package com.jsp.Controller;

import com.jsp.service.AdminService;

public class UpdateAdminName {
	
	public static void main(String[] args) {

		AdminService adminService = new AdminService();

		if (adminService.updateNameById(2, "vikram") != null) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
	}

}
