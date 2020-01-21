package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AreaDao;
import dao.DBData;
import model.CustomerModel;
import model.DistrictModel;
import model.DivisionModel;
import model.OrderSellerProductModel;
import model.OrdersModel;
import model.ProductModel;
import model.SellersProduct;
import model.UnionModel;
import model.UpazillaModel;


public class OrderOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	DBData db = new DBData();
	AreaDao aDao = new AreaDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		if (action.equals("viewsellerorder")) {
			System.out.println( request.getParameter("action")+ " " + request.getParameter("soid"));
			int soid = Integer.parseInt(request.getParameter("soid"));
			OrderSellerProductModel orderSellerProductModel = db.getOrderSellerProductById(soid);
			request.setAttribute("order", orderSellerProductModel);
			request.getRequestDispatcher("view_order.jsp").forward(request, response);;
		}
		else if (action.equals("vieworder")) {
			int oid = Integer.parseInt(request.getParameter("oid"));
			OrdersModel ordersModel = db.getOrderById(oid);
			request.setAttribute("order", ordersModel);
			request.getRequestDispatcher("view_order_inventory.jsp").forward(request, response);;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		if (action.equals("editordersellerproduct")) {
			OrderSellerProductModel orderSellerProductModel = new OrderSellerProductModel();
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			int soid = Integer.parseInt(request.getParameter("soid").toString());
			
			OrderSellerProductModel orderSellerProductModel2 = db.getOrderSellerProductById(soid);

			int delId = Integer.parseInt(request.getParameter("deliveryPerson"));
			orderSellerProductModel.setDeliveryPersonModel(db.getDeliveryPersonById(delId));
			
			orderSellerProductModel.setOrderId(soid);
			orderSellerProductModel.setCareOfContact(request.getParameter("careOfContact").toString());
			orderSellerProductModel.setPhoneNumber(request.getParameter("deliveryPhone").toString());
			orderSellerProductModel.setOrderQuantity(Double.parseDouble(request.getParameter("deliveryQuantity").toString()));
			orderSellerProductModel.setOrderVillage(request.getParameter("deliveryVillage").toString());
			orderSellerProductModel.setOrderStreet(request.getParameter("deliveryStreet").toString());
			orderSellerProductModel.setOrderZipCode(request.getParameter("deliveryZipCode").toString());
			orderSellerProductModel.setOrderDate(request.getParameter("orderDate"));
			orderSellerProductModel.setOrderStatus(request.getParameter("orderStatus"));
			
			
			int divId = Integer.parseInt(request.getParameter("deliveryDivision"));
			DivisionModel divisionModel = aDao.getDivisionById(divId);
			
			int disId = Integer.parseInt(request.getParameter("deliveryDistrict"));
			DistrictModel districtModel = aDao.getDistrictById(disId);
			
			int upaId = Integer.parseInt(request.getParameter("deliveryUpazilla"));
			UpazillaModel upazillaModel = aDao.getUpazillaById(upaId);
			
			int uniId = Integer.parseInt(request.getParameter("deliveryUnion"));
			UnionModel unionModel = aDao.getUnionById(uniId);
			
			orderSellerProductModel.setDivisionModel(divisionModel);
			orderSellerProductModel.setDistrictModel(districtModel);
			orderSellerProductModel.setUpazillaModel(upazillaModel);
			orderSellerProductModel.setUnionModel(unionModel);
			
			SellersProduct sellersProduct = orderSellerProductModel2.getSellersProduct();
			orderSellerProductModel.setSellersProduct(sellersProduct);
			orderSellerProductModel.setSellerModel(sellersProduct.getSellerModel());
			
			CustomerModel customerModel = db.getCustomerById(Integer.parseInt(request.getParameter("customerModel")));
			orderSellerProductModel.setCustomerModel(customerModel);
			
	/*		AreaModel areaModel = db.getAreaById(Integer.parseInt(request.getParameter("areaModel")));
			ordersModel.setAreaModel(areaModel);*/

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDate");
			try {
				orderSellerProductModel.setExpectedDeliveryDate(simpleDateFormat.parse(deliveryDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			db.updateOrderSellerProduct(orderSellerProductModel);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if (action.equals("orderinventory")) {
			OrdersModel ordersModel = new OrdersModel();
			
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			int oid = Integer.parseInt(request.getParameter("oid").toString());
			
			OrdersModel ordersModel2 = db.getOrderById(oid);
			

			ordersModel.setOrderId(oid);
			ordersModel.setCareOfContact(request.getParameter("careOfContact").toString());
			ordersModel.setPhoneNumber(request.getParameter("deliveryPhone").toString());
			ordersModel.setOrderQuantity(Double.parseDouble(request.getParameter("deliveryQuantity").toString()));
			ordersModel.setOrderVillage(request.getParameter("deliveryVillage").toString());
			ordersModel.setOrderStreet(request.getParameter("deliveryStreet").toString());
			ordersModel.setOrderZipCode(request.getParameter("deliveryZipCode").toString());
			ordersModel.setOrderDate(request.getParameter("orderDate"));
			ordersModel.setOrderStatus(request.getParameter("orderStatus"));
			
			int delId = Integer.parseInt(request.getParameter("deliveryPerson"));
			ordersModel.setDeliveryPersonModel(db.getDeliveryPersonById(delId));
			
			int divId = Integer.parseInt(request.getParameter("deliveryDivision"));
			DivisionModel divisionModel = aDao.getDivisionById(divId);
			
			int disId = Integer.parseInt(request.getParameter("deliveryDistrict"));
			DistrictModel districtModel = aDao.getDistrictById(disId);
			
			int upaId = Integer.parseInt(request.getParameter("deliveryUpazilla"));
			UpazillaModel upazillaModel = aDao.getUpazillaById(upaId);
			
			int uniId = Integer.parseInt(request.getParameter("deliveryUnion"));
			UnionModel unionModel = aDao.getUnionById(uniId);
			
			ordersModel.setDivisionModel(divisionModel);
			ordersModel.setDistrictModel(districtModel);
			ordersModel.setUpazillaModel(upazillaModel);
			ordersModel.setUnionModel(unionModel);
			
			ordersModel.setProductModel(ordersModel2.getProductModel());
			ordersModel.setCustomerModel(ordersModel2.getCustomerModel());
			
	/*		AreaModel areaModel = db.getAreaById(Integer.parseInt(request.getParameter("areaModel")));
			ordersModel.setAreaModel(areaModel);*/

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDate");
			try {
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(deliveryDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			db.updateOrder(ordersModel);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
