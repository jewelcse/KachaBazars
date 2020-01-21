package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import dao.DBData;
import model.CustomerModel;


public class BrowseServlet extends HttpServlet {
	
	
	HttpSession session;
	RequestDispatcher rd = null;
	DBData db = new DBData();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.equals("ourshop")) {
			session = request.getSession();
			if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				CustomerModel customerModel = db.getCustomerById(cid);
				request.setAttribute("customer", customerModel);
			}
			
			
			rd = request.getRequestDispatcher("/browse.jsp");
		}
	rd.forward(request, response);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
