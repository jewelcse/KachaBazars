package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBData;
import model.AreaModel;
import model.CategoryModel;

public class AreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBData db = new DBData();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		String action = request.getParameter("action").toString();
		System.out.println(action);
		
		if (action.equals("view")) {
			List<AreaModel> areaModels = db.getAllAreas();
			request.setAttribute("areas", areaModels);
			rd = request.getRequestDispatcher("/Area.jsp");
		}
		else if (action.equals("new")) {
			AreaModel areaModel = new AreaModel();
			request.setAttribute("areas", areaModel);
			request.setAttribute("action", "new");
			
			rd = request.getRequestDispatcher("/newarea.jsp");
		}
		else if (action.equals("viewdiv")) {
			int divId = Integer.parseInt(request.getParameter("divisionId"));
			request.setAttribute("divId", divId);
			request.setAttribute("action", "viewdiv");
			rd = request.getRequestDispatcher("/view_district.jsp");
		}
		else if (action.equals("viewdis")) {
			int disId = Integer.parseInt(request.getParameter("disId"));
			System.out.println(disId);
			
			request.setAttribute("disId", disId);
			request.setAttribute("action", "viewdis");
			rd = request.getRequestDispatcher("/view_upazilla.jsp"); 
		}
		else if (action.equals("viewupa")) {
			int upaId = Integer.parseInt(request.getParameter("upaId"));
			
			request.setAttribute("upaId", upaId);
			request.setAttribute("action", "viewupa");
			rd = request.getRequestDispatcher("/view_unions.jsp"); 
		}
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = null;
		String action = request.getParameter("action").toString();
		
		if (action.equals("new")) {
			AreaModel areaModel = new AreaModel();
			
			System.out.println(request.getParameter("areaName").toString());
			db.saveArea(areaModel);
		}
	}

}
