package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBData;
import model.AdminModel;
import model.CustomerModel;


public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBData db = new DBData();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");
		
		if (action.equals("adminlogout")) {
			
			session.removeAttribute("adminlogin");
			session.removeAttribute("admin");
						
			request.getRequestDispatcher("admin-login.jsp").forward(request, response);
			
		}
		else if (action.equalsIgnoreCase("viewprofile")) {
			
			if (session.getAttribute("admin") != null) {
				
				AdminModel adminModel = (AdminModel) session.getAttribute("admin");
								
				request.setAttribute("admin", adminModel);
				
				request.getRequestDispatcher("/admininfo.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("adminlogin")) {
			
			String name, password;
			
			name = request.getParameter("adminName");
			password = request.getParameter("adminPassword");
			
			AdminModel adminModel =db.getAdminPasswordByName(name);
			
			if(adminModel==null)
			{
				request.setAttribute("message", "Account id Invalid...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
			else if (name.equalsIgnoreCase(adminModel.getAdminName()) && password.equalsIgnoreCase(adminModel.getAdminPassword())) {
				int aid = adminModel.getAdminId();
				HttpSession session=request.getSession();
				session.setAttribute("name", adminModel.getAdminName());
				session.setAttribute("admin", adminModel);
				session.setAttribute("aid", aid);
				session.setAttribute("adminlogin", "true");
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			
			}
			
			else {
				request.setAttribute("message", "Account id or wrong password...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/admin-login.jsp").forward(request, response);
			}
			
		}
		
	}

}
