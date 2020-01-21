package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.annotations.Until;

import dao.AreaDao;
import dao.DBData;
import javassist.runtime.Inner;
import model.AreaModel;
import model.CustomerModel;
import model.SellersProduct;
import model.UnionModel;


public class TestUiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	RequestDispatcher rd = null;
	DBData db = new DBData();
	AreaDao ad = new AreaDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action.equals("view")) {
			request.setAttribute("action", "view");
			int cid = Integer.parseInt(session.getAttribute("cid").toString());
			System.out.println("cust ID " + cid);
			CustomerModel customerModel = db.getCustomerById(cid);
			int uniId = customerModel.getUnionModel().getUnionId();
			int upaId = customerModel.getUpazillaModel().getUpazillaId();
			int disId = customerModel.getDistrictModel().getDistrictId();
			int divId = customerModel.getDivisionmodel().getDivisionId();
			
			List<SellersProduct> sellersProductsUnion = db.getProductByUnion(uniId);
			List<SellersProduct> sellersProductsUpazilla = db.getProductByUpazilla(upaId);
			List<SellersProduct> sellersProductsDistrict = db.getProductByDistrict(disId);
			List<SellersProduct> sellersProductsDivision = db.getProductByDivision(divId);
			
			request.setAttribute("Unionproducts", sellersProductsUnion);
			request.setAttribute("Upazillaproduct", sellersProductsUpazilla);
			request.setAttribute("Districtproduct", sellersProductsDistrict);
			request.setAttribute("Divisionproduct", sellersProductsDivision);
			
			request.getRequestDispatcher("/test_ui.jsp").forward(request, response);
		}
		else if (action.equals("all")) {
			List<SellersProduct> sellersProducts = db.getAllSellerProductrs();
			request.setAttribute("sellerproduct", sellersProducts);
			request.getRequestDispatcher("seller_products.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	}

}
