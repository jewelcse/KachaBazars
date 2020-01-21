package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBData;
import model.CartDetailsModel;
import model.OrdersModel;
import model.ProductModel;


public class DemandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DBData db = new DBData();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=null;

		int intArray[];
		intArray = new int[2000];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = 0;
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String date = request.getParameter("date");
		
		String action=request.getParameter("action");
		
		if (action.equals("view")) {
			request.getRequestDispatcher("/view_demand.jsp").forward(request, response);
		}
		
		if (action.equals("demand")) {
	//		System.out.println("line 43" + action);
			List<OrdersModel> ordersModels = db.getDemandsByDate(date);
			Iterator<OrdersModel> it = ordersModels.iterator();
			List<ProductModel> productModels = new ArrayList<ProductModel>();
			
			while (it.hasNext()) {
				Object type = (Object) it.next();
				OrdersModel sub =  (OrdersModel) type;
			//	System.out.println(sub.getProductModel().getProductId());
			//	System.out.println(intArray[sub.getProductModel().getProductId()]+ " = "+ intArray[sub.getProductModel().getProductId()] +" + " + sub.getOrderQuantity());

				
				intArray[sub.getProductModel().getProductId()] = (int) (intArray[sub.getProductModel().getProductId()] + sub.getOrderQuantity());
			//	System.out.println("result : " + intArray[sub.getProductModel().getProductId()]);
			}
			
			
			List<ProductModel> productModels2 = new ArrayList<ProductModel>();
			for (int i = 0; i < intArray.length; i++) {
				if (intArray[i] != 0 ) {
					ProductModel productModel = db.getProductById(i);
					productModel.setProductQuantity(intArray[i]);
					productModels2.add(productModel);
				}
			}
						
			request.setAttribute("products", productModels2);
			request.setAttribute("date", date);
			request.setAttribute("action", "demand");
			request.setAttribute("demands", intArray);
			request.getRequestDispatcher("/view_demand.jsp").forward(request, response);
			
		}
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
