package com.jsp.Controller;

import com.jsp.service.AdminService;

public class AdminLogin {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		
		boolean res = adminService.validateAdmin(1, "vivek", "abcd");
		
		if(res) {
			System.out.println("Login successfull");
		}else {
			System.out.println("Invalid credentials");
		}
	}

}
