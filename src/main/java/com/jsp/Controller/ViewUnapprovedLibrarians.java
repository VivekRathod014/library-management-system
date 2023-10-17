package com.jsp.Controller;

import java.util.List;

import com.jsp.Dto.Librarian;
import com.jsp.service.AdminService;

public class ViewUnapprovedLibrarians {
	
		public static void main(String[] args) {

			AdminService adminService = new AdminService();
			List<Librarian> librarians =  adminService.viewAllUnapprovedLibrarians();
			
			for (Librarian l : librarians) {
					System.out.println("=========================");
					System.out.print(l.getId() + " " + "| ");
					System.out.print(l.getName() + " " + "| ");
					System.out.print(l.getMail() + " " + "| ");
					System.out.println(l.getStatus() + " " + "| ");
					System.out.println("=========================");

}
			
		}
}
