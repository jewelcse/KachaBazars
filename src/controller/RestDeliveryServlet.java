package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ietf.jgss.Oid;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.DBData;
import dao.OrderDao;
import model.DeliveryPersonModel;
import model.OrdersModel;


public class RestDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	
	OrderDao od = new OrderDao();
	DBData db = new DBData();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		if (action == null) {
			System.out.println("No action is GIVEN");
		}
		else if (action.equals("getneworders")) {
			
			int delId = Integer.parseInt(request.getParameter("delId"));
			
			ArrayList<OrdersModel> ordersModels = od.getNewOrdersForDeliveryManByDelId(delId);
			JSONArray jsonArray = new JSONArray();
		
			
			Iterator<OrdersModel> it = ordersModels.iterator();
			
			while (it.hasNext()) {
				Object type = (Object) it.next();

				OrdersModel sub =  (OrdersModel) type;
				
				JSONObject JO = new JSONObject();

				
				try {
					JO.put("orderId", sub.getOrderId());
					JO.put("name", sub.getCareOfContact());
					JO.put("customer", sub.getCustomerModel().getCustomerId());
					JO.put("customerName", sub.getCustomerModel().getCustomerFirstName() + " " + sub.getCustomerModel().getCustomerLastName());
					JO.put("date", sub.getExpectedDeliveryDate());
					JO.put("quantity", sub.getOrderQuantity());
					JO.put("status", sub.getOrderStatus());
					JO.put("orderVillage", sub.getOrderVillage());
					JO.put("orderSteet", sub.getOrderStreet());
					JO.put("productName", sub.getProductModel().getProductName());
					JO.put("productId", sub.getProductModel().getProductId());
					JO.put("orderPhone", sub.getPhoneNumber());
					JO.put("division", sub.getDivisionModel().getDivisionName());
					JO.put("district", sub.getDistrictModel().getDistrictName());
					JO.put("upazilla", sub.getUpazillaModel().getUpazillaName());
					JO.put("union", sub.getUnionModel().getUnionBanglaName());
					JO.put("orderingDate", sub.getOrderDate());
					
					jsonArray.put(JO);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
			
			PrintWriter printWriter = response.getWriter();
			printWriter.write(jsonArray.toString());
			
			System.out.println(jsonArray.toString());
						
		}
		else if (action.equals("markAsComplete")) {
			

			int oid = Integer.parseInt(request.getParameter("orderId"));
			OrdersModel ordersModel = db.getOrderById(oid);
			ordersModel.setOrderStatus("completed");
			ordersModel.setOrderId(oid);
			
			db.updateOrder(ordersModel);
			
			JSONArray jsonArray = new JSONArray();
			PrintWriter pw = response.getWriter();
			
			pw.write(jsonArray.toString());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		if (action == null) {
			System.out.println("No action is GIVEN");
		}
		else if (action.equals("deliLogin")) {
			
			String phone, pass;
			
			phone = request.getParameter("phone");
			pass = request.getParameter("pass");
			

			DeliveryPersonModel deliveryPersonModel = new DeliveryPersonModel();
			deliveryPersonModel = od.getDeliveryPersonPasswordByPhone(phone);
			
			System.out.println(deliveryPersonModel);
			
			if(deliveryPersonModel==null)
			{
				request.setAttribute("message", "Account id Invalid...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/CustomerLogin.jsp").forward(request, response);
			}
			else if (phone.equals(deliveryPersonModel.getDeliveryPersonPhone()) && pass.equals(deliveryPersonModel.getDeliveryPersonPassword())) {
				
				JSONArray jsonArray = new JSONArray();
				JSONObject jsonObject = new JSONObject();
				
				try {
					jsonObject.put("delId", deliveryPersonModel.getDeliveryPersonId());
					jsonObject.put("delName", deliveryPersonModel.getDeliveryPersonFirstName() + " " + deliveryPersonModel.getDeliveryPersonLastName());
					jsonArray.put(jsonObject);
					PrintWriter pw = response.getWriter();
					pw.write(jsonArray.toString());
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			else {
				request.setAttribute("message", "Account id or wrong password...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/CustomerLogin.jsp").forward(request, response);
			}
		}
	}
}
