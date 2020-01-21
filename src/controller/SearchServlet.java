package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDao;
import model.ProductModel;
import model.SellersProduct;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	SearchDao sd = new SearchDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("search")) {
			
			String keyword = request.getParameter("keyword");
			int catId = Integer.parseInt(request.getParameter("searchtable"));
			
			List<ProductModel> productList1 = sd.getProductByKeywordAndCategoryId(keyword, catId);			
			List<SellersProduct> productList = sd.getSellerProductByKeywordAndCategoryId(keyword, catId);
			
			request.setAttribute("productList", productList);
			request.setAttribute("productList1", productList1);
			request.setAttribute("name", "Search result for "+ keyword);

			request.getRequestDispatcher("/explore.jsp").forward(request, response);
			
		}
	}

}
