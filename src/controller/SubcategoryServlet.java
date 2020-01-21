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
import model.CategoryModel;
import model.SubcategoryModel;



public class SubcategoryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DBData db = new DBData();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String action = request.getParameter("action");

		
		if (action.equals("new")) {
			SubcategoryModel categoryModel = new SubcategoryModel();
			request.setAttribute("subcategories", categoryModel);
			request.setAttribute("action", "new");
			
			rd = request.getRequestDispatcher("/newsubcategory.jsp");
			System.out.println("In new page..");
			
		}
		else if (action.equals("view")) {
			request.setAttribute("action", "view");
			rd = request.getRequestDispatcher("/subcategory.jsp");
		}
		else if (action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id").toString());
			SubcategoryModel subcategoryModel = new SubcategoryModel();
			subcategoryModel.setSubcategoryId(id);
			
			db.deleteSubcategoryById(subcategoryModel);
			List<SubcategoryModel> subcategoryModels = db.getAllSubcategories();
			request.setAttribute("subcategries", subcategoryModel);
			rd = request.getRequestDispatcher("/Category.jsp");	
		}
		System.out.println("Get Method..."+ action);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = null;
		String action = request.getParameter("action").toString();
		System.out.println(action);
		if (action.equals("new")) {
			SubcategoryModel subcategory = new SubcategoryModel();
			CategoryModel categoryModel=new CategoryModel();
			
			subcategory.setSubcategoryName(request.getParameter("subcategory_name").toString());
			subcategory.setSubcategoryDescription(request.getParameter("subcategory_description").toString());
			subcategory.setGovtPrice(request.getParameter("subcategory_govt_price").toString());

			int id;
			id = Integer.parseInt(request.getParameter("dropdownCategory"));

			categoryModel = db.getCategoryById(id);
			subcategory.setCategoryInformation(categoryModel);
			
			db.saveSubcategory(subcategory);

			
			rd = request.getRequestDispatcher("/subcategory.jsp");
			System.out.println();
		}
		rd.forward(request, response);
	}

}
