package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.dialect.RDMSOS2200Dialect;

import dao.DBData;
import model.ProductModel;


public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DBData db=new DBData();
	RequestDispatcher rd=null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		System.out.println(action);
		
		int page=1;
		int recordPerPage=5;
		
		if(request.getParameter("page")!=null)
		{
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		List<ProductModel> listOfProducts=db.getAllProductLimitedTo((page-1)*recordPerPage,recordPerPage);
		//int noOfRecords=db.getAllRecords();
		
		//System.out.println("No Of Records  "+noOfRecords);
		
		
		int noOfPages =8;// (int) Math.ceil(noOfRecords * 1.0 / recordPerPage);
        request.setAttribute("employeeList", listOfProducts);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        
		rd=request.getRequestDispatcher("/product_test.jsp");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
