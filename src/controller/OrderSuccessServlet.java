package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBData;
import dao.OrderDao;
import model.OrderSellerProductModel;
import model.OrdersModel;
import sslcommerz.TransactionResponseValidator;


public class OrderSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	OrderDao od = new OrderDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map<String, String[]> map = request.getParameterMap();
		Map<String, String> map2 = new HashMap<String, String>();
	
		String[] act = map.get("action");
		if ((act[0]).equalsIgnoreCase("inventoryorder")) {
			TransactionResponseValidator transactionResponseValidator = new TransactionResponseValidator();
			//		transactionResponseValidator.receiveSuccessResponse(map);
			int line = 1;
			for (String var : map.keySet()) {
			//	System.out.println(map.get(var).length);
				String[] array = map.get(var);
				for (String string : array) {
					System.out.println("line "+ line++ + " -> " +var + " : " +string + "\n\n");	
					map2.put(var, string);
				}	
			}	
			try {
				if (transactionResponseValidator.receiveSuccessResponse(map2)) {
					
					String tranId = map2.get("tran_id");
					System.out.println(tranId + "dsbfdjksbf");
					
					OrdersModel ordersModel = od.getOrderByTransactionId(tranId);
					
					ordersModel.setPaymentStatus(true);
					
					db.updateOrder(ordersModel);
					
					request.getRequestDispatcher("/Homepage.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ((act[0]).equalsIgnoreCase("cartorder")) {
			
			TransactionResponseValidator transactionResponseValidator = new TransactionResponseValidator();
			//		transactionResponseValidator.receiveSuccessResponse(map);
			int line = 1;
			for (String var : map.keySet()) {
			//	System.out.println(map.get(var).length);
				String[] array = map.get(var);
				for (String string : array) {
					System.out.println("line "+ line++ + " -> " +var + " : " +string + "\n\n");	
					map2.put(var, string);
				}	
			}	
			try {
				if (transactionResponseValidator.receiveSuccessResponse(map2)) {
					
					String tranId = map2.get("tran_id");
					System.out.println(tranId + "dsbfdjksbf");
					
					OrdersModel ordersModel = od.getOrderByTransactionId(tranId);
					
					ordersModel.setPaymentStatus(true);
					
					
					
					List<OrdersModel> ordersModels = od.getCartOrderListByTransactionId(tranId);
					
					Iterator<OrdersModel> it = ordersModels.iterator();
					
					while (it.hasNext()) {
						Object type = (Object) it.next();

						OrdersModel sub =  (OrdersModel) type;
						
						sub.setPaymentStatus(true);
						
						db.updateOrder(sub);

					}
					
					
					request.getRequestDispatcher("Homepage.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if ((act[0]).equalsIgnoreCase("sellerproduct")) {
			
			TransactionResponseValidator transactionResponseValidator = new TransactionResponseValidator();
			//		transactionResponseValidator.receiveSuccessResponse(map);
			int line = 1;
			for (String var : map.keySet()) {
			//	System.out.println(map.get(var).length);
				String[] array = map.get(var);
				for (String string : array) {
					System.out.println("line "+ line++ + " -> " +var + " : " +string + "\n\n");	
					map2.put(var, string);
				}	
			}	
			try {
				if (transactionResponseValidator.receiveSuccessResponse(map2)) {
					
					String tranId = map2.get("tran_id");
					System.out.println(tranId + " Tran ID");
					
					OrderSellerProductModel ordersModel = od.getOrderSellerProductByTransactionId(tranId);
					
					ordersModel.setPaymentStatus(true);
					
					db.updateOrderSellerProduct(ordersModel);
					
					request.getRequestDispatcher("Homepage.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
