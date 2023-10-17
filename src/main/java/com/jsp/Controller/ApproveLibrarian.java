package com.jsp.Controller;

import com.jsp.service.AdminService;

public class ApproveLibrarian {
	public static void main(String[] args) {
		AdminService adminService = new AdminService();
		boolean res = adminService.approveLibrarianById(1, 1);
		res = adminService.approveLibrarianById(2, 1);
		res = adminService.approveLibrarianById(3, 1);
		System.out.println(res);
	}

}
