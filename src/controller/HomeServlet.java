package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerModel;
import model.ProductModel;


public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher rd= null;
		
		String action=request.getParameter("action");
		
		System.out.println("action : " + action);
		int cid = Integer.parseInt(request.getAttribute("cid").toString());
		System.out.println("cid : " +cid);
		
		if(action.equals("view"))
		{
			ProductModel productModel=new ProductModel();
			request.setAttribute("product", productModel);
			request.setAttribute("action", "view");
			request.setAttribute("cid", cid);
			System.out.println("home : " + cid);
			rd=request.getRequestDispatcher("/Homepage.jsp");
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
