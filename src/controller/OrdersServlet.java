package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.AreaDao;
import dao.DBData;
import model.AreaModel;
import model.CartDetailsModel;
import model.CartModel;
import model.CustomerModel;
import model.DeliveryPersonModel;
import model.DistrictModel;
import model.DivisionModel;
import model.OrderSellerProductModel;
import model.OrdersModel;
import model.ProductModel;
import model.RecommendationModel;
import model.SellerModel;
import model.SellersProduct;
import model.SubcategoryModel;
import model.UnionModel;
import model.UpazillaModel;
import sslcommerz.TransactionInitiator;

public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	AreaDao aDao = new AreaDao();
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		System.out.println("line : "+action);
		
		if (action.equals("view")) {
			List<OrdersModel> ordersModels = db.getAllOrders();
			request.setAttribute("orders", ordersModels);
			request.setAttribute("action", "view");
			rd = request.getRequestDispatcher("/index.jsp");
		} else if (action.equals("confirm")) {
			OrdersModel ordersModel = new OrdersModel();

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String time = (dtf.format(now));
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			ProductModel productModel = db.getProductById(pid);
			
			request.setAttribute("product", productModel);
			request.setAttribute("orders", ordersModel);
			request.setAttribute("action", "confirm");

			rd = request.getRequestDispatcher("/Confirmation.jsp");
			// db.saveOrder(ordersModel);
		}
		else if (action.equals("edit")) {
			int oid = Integer.parseInt(request.getParameter("oid"));
			OrdersModel ordersModel = new OrdersModel();
			ordersModel = db.getOrderById(oid);
			System.out.println("line 65 " + ordersModel);
			request.setAttribute("order", ordersModel);
			request.setAttribute("action", "update");
			
			rd = request.getRequestDispatcher("/update_order.jsp");
		}
		else if (action.equals("done")) {
			
			OrdersModel ordersModel = new OrdersModel();
			
			int oid = Integer.parseInt(request.getParameter("oid").toString());
			
			OrdersModel ordersModel2 = db.getOrderById(oid);
			
			ordersModel.setOrderId(ordersModel2.getOrderId());
			ordersModel.setCareOfContact(ordersModel2.getCareOfContact());
			ordersModel.setPhoneNumber(ordersModel2.getPhoneNumber());
			ordersModel.setOrderQuantity(ordersModel2.getOrderQuantity());
			ordersModel.setOrderVillage(ordersModel2.getOrderVillage());
			
			
			
			ordersModel.setOrderStreet(ordersModel2.getOrderStreet());
			ordersModel.setOrderZipCode(ordersModel2.getOrderZipCode());
			ordersModel.setOrderDate(ordersModel2.getOrderDate());
			ordersModel.setOrderDate(ordersModel2.getOrderDate());
			ordersModel.setExpectedDeliveryDate(ordersModel2.getExpectedDeliveryDate());
			ordersModel.setCustomerModel(ordersModel2.getCustomerModel());
			ordersModel.setProductModel(ordersModel2.getProductModel());
			
			ordersModel.setOrderStatus(request.getParameter("dropdown"));
			
			int aid = Integer.parseInt(request.getParameter("dd1"));
			int did = Integer.parseInt(request.getParameter("dd2"));

			ordersModel.setDeliveryPersonModel(db.getDeliveryPersonById(did));
			
			System.out.println(" line 106 area " + db.getAreaById(aid));
			
			db.updateOrder(ordersModel);
			
			rd = request.getRequestDispatcher("/index.jsp");
			
		}
		else if (action.equals("addtocart")) {
			Integer pid = Integer.parseInt(request.getParameter("pid").toString());
			System.out.println("cid = " + session.getAttribute("cid").toString());
			if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
			}

			ProductModel productModel = new ProductModel();
			productModel = db.getProductById(pid);

			request.setAttribute("product", productModel);
			request.setAttribute("action", "order");

			rd = request.getRequestDispatcher("/ViewProduct.jsp");
			
		}
		else if (action.equals("confirmsellerproduct")) {
			OrdersModel ordersModel = new OrdersModel();

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String time = (dtf.format(now));
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			ProductModel productModel = db.getProductById(pid);
			
			request.setAttribute("product", productModel);
			request.setAttribute("orders", ordersModel);
			request.setAttribute("action", "confirm");

			rd = request.getRequestDispatcher("/confirm_seller_product.jsp");
			// db.saveOrder(ordersModel);
		}
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		DBData db = new DBData();

		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		if (action.equals("confirm")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int pid = Integer.parseInt(request.getParameter("pid"));

			CustomerModel customerModel = db.getCustomerById(cid);
			ProductModel productModel = db.getProductById(pid);
			OrdersModel ordersModel = new OrdersModel();

			String careOfContact = request.getParameter("careOfContact");
			String deliveryPhone = request.getParameter("deliveryPhone");
			String deliveryVillage = request.getParameter("deliveryVillage");

			String deliveryStreet = request.getParameter("deliveryStreet");
			String deliveryZipCode = request.getParameter("deliveryZipCode");
			String orderStatus = "Unallocated";

			
			
			int divId = Integer.parseInt(request.getParameter("deliveryDivision"));
			DivisionModel divisionModel = aDao.getDivisionById(divId);
			
			int disId = Integer.parseInt(request.getParameter("deliveryDistrict"));
			DistrictModel districtModel = aDao.getDistrictById(disId);
			
			int upaId = Integer.parseInt(request.getParameter("deliveryUpazilla"));
			UpazillaModel upazillaModel = aDao.getUpazillaById(upaId);
			
			int uniId = Integer.parseInt(request.getParameter("deliveryUnion"));
			UnionModel unionModel = aDao.getUnionById(uniId);
			
			double orderQuantity = Double.parseDouble(request.getParameter("qty"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();

			String orderingTime = (dtf.format(now));
			
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			
			String hex = UUID.randomUUID().toString();
			
		//	BigInteger bigIntegerStr = new BigInteger(hex);
			
		//	BigInteger bigInteger2 = new BigInteger("‭4294967295‬");
			
		//	bigIntegerStr = bigIntegerStr.mod(bigInteger2);
			
			String tranId = hex + dtf2.format(now);

			ordersModel.setCustomerModel(customerModel);
			ordersModel.setProductModel(productModel);
			ordersModel.setCareOfContact(careOfContact);
			ordersModel.setPhoneNumber(deliveryPhone);
			ordersModel.setOrderVillage(deliveryVillage);
			ordersModel.setDivisionModel(divisionModel);
			ordersModel.setDistrictModel(districtModel);
			ordersModel.setUpazillaModel(upazillaModel);
			ordersModel.setUnionModel(unionModel);
			ordersModel.setOrderStreet(deliveryStreet);
			ordersModel.setOrderZipCode(deliveryZipCode);
			ordersModel.setOrderDate(orderingTime);
			ordersModel.setOrderStatus(orderStatus);
			ordersModel.setOrderQuantity(orderQuantity);
			ordersModel.setTranId(tranId);
			ordersModel.setPaymentStatus(false);
						
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDate");
	//		System.out.println("line 110 " + deliveryDate);
			try {
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(deliveryDate));
	//			System.out.println("line 120 " + simpleDateFormat.parse(deliveryDate));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			RecommendationModel recommendationModel = new RecommendationModel();
			recommendationModel.setCustomerModel(customerModel);
			recommendationModel.setProductModel(productModel);
			
			db.saveRecommendation(recommendationModel);
			db.saveOrder(ordersModel);			
			
			TransactionInitiator trans = new TransactionInitiator();
			
			
			String response1 = trans.initTrnxnRequest(ordersModel);
			
			
			
			
			
			response.sendRedirect(response1);
			 
		//	request.setAttribute("cid", cid);
		//	request.setAttribute("action", "view");
		//	request.getRequestDispatcher("/Homepage.jsp").forward(request, response);
		}
		else if (action.equals("edit")) {
			OrdersModel ordersModel = new OrdersModel();
			
			int oid = Integer.parseInt(request.getParameter("oid").toString());

			ordersModel.setOrderId(oid);
			ordersModel.setCareOfContact(request.getParameter("careOfContact").toString());
			ordersModel.setPhoneNumber(request.getParameter("deliveryPhone").toString());
			ordersModel.setOrderQuantity(Double.parseDouble(request.getParameter("deliveryQuantity").toString()));
			ordersModel.setOrderVillage(request.getParameter("deliveryVillage").toString());
			int divId = Integer.parseInt(request.getParameter("deliveryDivision"));
			DivisionModel divisionModel = aDao.getDivisionById(divId);
			
			int disId = Integer.parseInt(request.getParameter("deliveryDistrict"));
			DistrictModel districtModel = aDao.getDistrictById(disId);
			
			int upaId = Integer.parseInt(request.getParameter("deliveryUpazilla"));
			UpazillaModel upazillaModel = aDao.getUpazillaById(upaId);
			
			int uniId = Integer.parseInt(request.getParameter("deliveryUnion"));
			UnionModel unionModel = aDao.getUnionById(uniId);
			ordersModel.setOrderStreet(request.getParameter("deliveryStreet").toString());
			ordersModel.setOrderZipCode(request.getParameter("deliveryZipCode").toString());
			ordersModel.setOrderDate(request.getParameter("orderDate"));
			ordersModel.setOrderStatus(request.getParameter("orderStatus"));
			ordersModel.setDivisionModel(divisionModel);
			ordersModel.setDistrictModel(districtModel);
			ordersModel.setUpazillaModel(upazillaModel);
			ordersModel.setUnionModel(unionModel);
			ProductModel productModel = db.getProductById(Integer.parseInt(request.getParameter("productModel")));
			ordersModel.setProductModel(productModel);
			
			CustomerModel customerModel = db.getCustomerById(Integer.parseInt(request.getParameter("customerModel")));
			ordersModel.setCustomerModel(customerModel);
			

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
		else if (action.equals("cartconfirm")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			
			OrdersModel ordersModel = new OrdersModel();
			CustomerModel customerModel = db.getCustomerById(cid);
							
			String careOfContact = request.getParameter("careOfContact");
			String deliveryPhone = request.getParameter("deliveryPhone");
			String deliveryVillage = request.getParameter("deliveryVillage");
			String deliveryUpazilla = request.getParameter("deliveryUpazilla");
			String deliveryDistrict = request.getParameter("deliveryDistrict");
			String deliveryStreet = request.getParameter("deliveryStreet");
			String deliveryZipCode = request.getParameter("deliveryZipCode");
			String orderStatus = "Unallocated";
			
			int divId = Integer.parseInt(request.getParameter("deliveryDivision"));
			DivisionModel divisionModel = aDao.getDivisionById(divId);
			
			int disId = Integer.parseInt(request.getParameter("deliveryDistrict"));
			DistrictModel districtModel = aDao.getDistrictById(disId);
			
			int upaId = Integer.parseInt(request.getParameter("deliveryUpazilla"));
			UpazillaModel upazillaModel = aDao.getUpazillaById(upaId);
			
			int uniId = Integer.parseInt(request.getParameter("deliveryUnion"));
			UnionModel unionModel = aDao.getUnionById(uniId);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDate");
			
			String hex = UUID.randomUUID().toString();
			
		//	BigInteger bigIntegerStr = new BigInteger(hex);
			
		//	BigInteger bigInteger2 = new BigInteger("‭4294967295‬");
			
		//	bigIntegerStr = bigIntegerStr.mod(bigInteger2);
			
			LocalDateTime now = LocalDateTime.now();

			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			
			String tranId = hex + dtf2.format(now);
			
			Date a =null;
			try {
				 a = simpleDateFormat.parse(deliveryDate);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String orderingTime = (dtf.format(now));
			
			double total = 0.00;
			double abc = 0.00;
			
			List<CartDetailsModel> cartDetailsModels = db.getCartDetailsByCartId(cartId);
			
			Iterator<CartDetailsModel> it = cartDetailsModels.iterator();
			
			while (it.hasNext()) {

				Object type = (Object) it.next();
				CartDetailsModel cdm =  (CartDetailsModel) type;				
				ordersModel.setProductModel(cdm.getProductModel());
				ordersModel.setCustomerModel(customerModel);
				ordersModel.setOrderQuantity(cdm.getCartProductQuantity());
				ordersModel.setCareOfContact(careOfContact);
				ordersModel.setOrderDate(orderingTime);
				ordersModel.setPhoneNumber(deliveryPhone);
				ordersModel.setOrderVillage(deliveryVillage);
				ordersModel.setTranId(tranId);
				ordersModel.setPaymentStatus(false);
				
				ordersModel.setOrderStreet(deliveryStreet);
				ordersModel.setOrderZipCode(deliveryZipCode);
				ordersModel.setExpectedDeliveryDate(a);
				ordersModel.setOrderStatus(orderStatus);
				
				ordersModel.setDivisionModel(divisionModel);
				ordersModel.setDistrictModel(districtModel);
				ordersModel.setUpazillaModel(upazillaModel);
				ordersModel.setUnionModel(unionModel);
				
				cdm.setCartId(null);
				cdm.setProductModel(null);
				
				abc = ordersModel.getOrderQuantity() * Double.parseDouble(ordersModel.getProductModel().getProductPrice());
				total = total + abc;
				
				db.saveOrder(ordersModel);
				db.deleteCartDetailsByCartId(cdm);
				
			}
			
			TransactionInitiator trans = new TransactionInitiator();
			
			String response1 = trans.initTrnxnRequest(tranId, total);
			
			response.sendRedirect(response1);

			
		//	request.setAttribute("cid", cid);
		//	request.setAttribute("action", "view");
		//	request.getRequestDispatcher("/Homepage.jsp").forward(request, response);
		}
		else if (action.equals("confirmsellerproduct")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			int divId = Integer.parseInt(request.getParameter("deliveryDivision"));
			int disId = Integer.parseInt(request.getParameter("deliveryDistrict"));		
			int upaId = Integer.parseInt(request.getParameter("deliveryUpazilla"));
			int uniId = Integer.parseInt(request.getParameter("deliveryUnion"));
			
			
			
			DivisionModel deliveryDivision = aDao.getDivisionById(divId);
			DistrictModel deliveryDistrict = aDao.getDistrictById(disId);
			UpazillaModel deliveryUpazilla = aDao.getUpazillaById(upaId);
			UnionModel deliveryUnion = aDao.getUnionById(uniId);
			CustomerModel customerModel = db.getCustomerById(cid);
			SellersProduct sellersProduct = db.getSellerProductById(pid);
			SellerModel sellerModel = db.getSellerById(sellersProduct.getSellerModel().getSellerId());
			OrderSellerProductModel ordersModel = new OrderSellerProductModel();

			String careOfContact = request.getParameter("careOfContact");
			String deliveryPhone = request.getParameter("deliveryPhone");
			String deliveryVillage = request.getParameter("deliveryVillage");
			String deliveryStreet = request.getParameter("deliveryStreet");
			String deliveryZipCode = request.getParameter("deliveryZipCode");
			String orderStatus = "Unallocated";

			double orderQuantity = Double.parseDouble(request.getParameter("qty"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();

			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			
			String hex = UUID.randomUUID().toString();
			
		//	BigInteger bigIntegerStr = new BigInteger(hex);
			
		//	BigInteger bigInteger2 = new BigInteger("‭4294967295‬");
			
		//	bigIntegerStr = bigIntegerStr.mod(bigInteger2);
			
			String tranId = hex + dtf2.format(now);
			
			
			String orderingTime = (dtf.format(now));

			ordersModel.setCustomerModel(customerModel);
			ordersModel.setSellersProduct(sellersProduct);
			ordersModel.setSellerModel(sellerModel);
			ordersModel.setCareOfContact(careOfContact);
			ordersModel.setPhoneNumber(deliveryPhone);

			ordersModel.setDivisionModel(deliveryDivision);
			ordersModel.setDistrictModel(deliveryDistrict);
			ordersModel.setUpazillaModel(deliveryUpazilla);
			ordersModel.setUnionModel(deliveryUnion);
			ordersModel.setOrderVillage(deliveryVillage);
			ordersModel.setOrderStreet(deliveryStreet);
			
			ordersModel.setOrderZipCode(deliveryZipCode);
			ordersModel.setOrderDate(orderingTime);
			ordersModel.setOrderStatus(orderStatus);
			ordersModel.setOrderQuantity(orderQuantity);
			ordersModel.setTranId(tranId);
			ordersModel.setPaymentStatus(false);

	
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDate");
	//		System.out.println("line 110 " + deliveryDate);
			try {
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(deliveryDate));
	//			System.out.println("line 120 " + simpleDateFormat.parse(deliveryDate));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
						
			RecommendationModel recommendationModel = new RecommendationModel();
			recommendationModel.setCustomerModel(customerModel);
			recommendationModel.setSellerModel(sellerModel);
			
			db.saveRecommendation(recommendationModel);
	
			db.saveSellerProductOrder(ordersModel);
			 
			TransactionInitiator trans = new TransactionInitiator();		
			String response1 = trans.initTrnxnRequest(ordersModel);
			
			response.sendRedirect(response1);
		}
		else if (action.equalsIgnoreCase("confirmsellerproductcurrentinfo")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			
			CustomerModel customerModel = db.getCustomerById(cid);
			SellersProduct sellersProduct = db.getSellerProductById(pid);
			SellerModel sellerModel = db.getSellerById(sellersProduct.getSellerModel().getSellerId());
			OrderSellerProductModel ordersModel = new OrderSellerProductModel();

			String careOfContact = customerModel.getCustomerFirstName() + customerModel.getCustomerLastName();
			String deliveryPhone = customerModel.getCustomerPhone();
			String deliveryVillage = customerModel.getCustomerVillage();
			String deliveryStreet = customerModel.getCustomerStreet();
			String deliveryZipCode = customerModel.getCustomerZipcode();
			String orderStatus = "Unallocated";

			double orderQuantity = Double.parseDouble(request.getParameter("qty"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();

			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			
			String hex = UUID.randomUUID().toString();
			
		//	BigInteger bigIntegerStr = new BigInteger(hex);
			
		//	BigInteger bigInteger2 = new BigInteger("‭4294967295‬");
			
		//	bigIntegerStr = bigIntegerStr.mod(bigInteger2);
			
			String tranId = hex + dtf2.format(now);
			
			
			String orderingTime = (dtf.format(now));

			ordersModel.setCustomerModel(customerModel);
			ordersModel.setSellersProduct(sellersProduct);
			ordersModel.setSellerModel(sellerModel);
			ordersModel.setCareOfContact(careOfContact);
			ordersModel.setPhoneNumber(deliveryPhone);

			ordersModel.setDivisionModel(customerModel.getDivisionmodel());
			ordersModel.setDistrictModel(customerModel.getDistrictModel());
			ordersModel.setUpazillaModel(customerModel.getUpazillaModel());
			ordersModel.setUnionModel(customerModel.getUnionModel());
			ordersModel.setOrderVillage(deliveryVillage);
			ordersModel.setOrderStreet(deliveryStreet);
			
			ordersModel.setOrderZipCode(deliveryZipCode);
			ordersModel.setOrderDate(orderingTime);
			ordersModel.setOrderStatus(orderStatus);
			ordersModel.setOrderQuantity(orderQuantity);
			ordersModel.setTranId(tranId);
			ordersModel.setPaymentStatus(false);

	
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDate");
	//		System.out.println("line 110 " + deliveryDate);
			try {
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(deliveryDate));
	//			System.out.println("line 120 " + simpleDateFormat.parse(deliveryDate));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
						
			RecommendationModel recommendationModel = new RecommendationModel();
			recommendationModel.setCustomerModel(customerModel);
			recommendationModel.setSellerModel(sellerModel);
			
			db.saveRecommendation(recommendationModel);
	
			db.saveSellerProductOrder(ordersModel);
			 
			TransactionInitiator trans = new TransactionInitiator();		
			String response1 = trans.initTrnxnRequest(ordersModel);
			
			response.sendRedirect(response1);
		}
		else if (action.equalsIgnoreCase("usecurrentinfo")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int pid = Integer.parseInt(request.getParameter("pid"));

			CustomerModel customerModel = db.getCustomerById(cid);
			ProductModel productModel = db.getProductById(pid);
			OrdersModel ordersModel = new OrdersModel();

			String orderStatus = "Unallocated";
			
			double orderQuantity = Double.parseDouble(request.getParameter("qty"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();

			String orderingTime = (dtf.format(now));
			
			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			
			String hex = UUID.randomUUID().toString();
			
		//	BigInteger bigIntegerStr = new BigInteger(hex);
			
		//	BigInteger bigInteger2 = new BigInteger("‭4294967295‬");
			
		//	bigIntegerStr = bigIntegerStr.mod(bigInteger2);
			
			String tranId = hex + dtf2.format(now);

			ordersModel.setCustomerModel(customerModel);
			ordersModel.setProductModel(productModel);
			ordersModel.setCareOfContact(customerModel.getCustomerFirstName() + customerModel.getCustomerLastName());
			ordersModel.setPhoneNumber(customerModel.getCustomerPhone());
			ordersModel.setOrderVillage(customerModel.getCustomerVillage());
			ordersModel.setDivisionModel(customerModel.getDivisionmodel());
			ordersModel.setDistrictModel(customerModel.getDistrictModel());
			ordersModel.setUpazillaModel(customerModel.getUpazillaModel());
			ordersModel.setUnionModel(customerModel.getUnionModel());
			ordersModel.setOrderStreet(customerModel.getCustomerStreet());
			ordersModel.setOrderZipCode(customerModel.getCustomerZipcode());
			ordersModel.setOrderDate(orderingTime);
			ordersModel.setOrderStatus(orderStatus);
			ordersModel.setOrderQuantity(orderQuantity);
			ordersModel.setTranId(tranId);
			ordersModel.setPaymentStatus(false);
						
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDatesameinfo");
	//		System.out.println("line 110 " + deliveryDate);
			try {
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(deliveryDate));
	//			System.out.println("line 120 " + simpleDateFormat.parse(deliveryDate));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			RecommendationModel recommendationModel = new RecommendationModel();
			recommendationModel.setCustomerModel(customerModel);
			recommendationModel.setProductModel(productModel);
			
			TransactionInitiator trans = new TransactionInitiator();
			
			String response1 = trans.initTrnxnRequest(ordersModel);
			
			
			
			
			db.saveRecommendation(recommendationModel);
			db.saveOrder(ordersModel);
			response.sendRedirect(response1);
		} else if (action.equalsIgnoreCase("cartconfirmuserinfo")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			
			OrdersModel ordersModel = new OrdersModel();
			CustomerModel customerModel = db.getCustomerById(cid);
							
			String careOfContact = customerModel.getCustomerFirstName() + customerModel.getCustomerLastName(); 
			String deliveryPhone = customerModel.getCustomerPhone();
			String deliveryVillage = customerModel.getCustomerVillage();
			String deliveryStreet = customerModel.getCustomerStreet();
			String deliveryZipCode = customerModel.getCustomerZipcode();
			String orderStatus = "Unallocated";

			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String deliveryDate = request.getParameter("deliveryDatesameinfo");
			
			String hex = UUID.randomUUID().toString();
			
		//	BigInteger bigIntegerStr = new BigInteger(hex);
			
		//	BigInteger bigInteger2 = new BigInteger("‭4294967295‬");
			
		//	bigIntegerStr = bigIntegerStr.mod(bigInteger2);
			
			LocalDateTime now = LocalDateTime.now();

			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			
			String tranId = hex + dtf2.format(now);
			
			Date a =null;
			try {
				 a = simpleDateFormat.parse(deliveryDate);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String orderingTime = (dtf.format(now));
			
			double total = 0.00;
			double abc = 0.00;
			
			List<CartDetailsModel> cartDetailsModels = db.getCartDetailsByCartId(cartId);
			
			Iterator<CartDetailsModel> it = cartDetailsModels.iterator();
			
			while (it.hasNext()) {

				Object type = (Object) it.next();
				CartDetailsModel cdm =  (CartDetailsModel) type;				
				ordersModel.setProductModel(cdm.getProductModel());
				ordersModel.setCustomerModel(customerModel);
				ordersModel.setOrderQuantity(cdm.getCartProductQuantity());
				ordersModel.setCareOfContact(careOfContact);
				ordersModel.setOrderDate(orderingTime);
				ordersModel.setPhoneNumber(deliveryPhone);
				ordersModel.setOrderVillage(deliveryVillage);
				ordersModel.setTranId(tranId);
				ordersModel.setPaymentStatus(false);
				
				ordersModel.setOrderStreet(deliveryStreet);
				ordersModel.setOrderZipCode(deliveryZipCode);
				ordersModel.setExpectedDeliveryDate(a);
				ordersModel.setOrderStatus(orderStatus);
				
				ordersModel.setDivisionModel(customerModel.getDivisionmodel());
				ordersModel.setDistrictModel(customerModel.getDistrictModel());
				ordersModel.setUpazillaModel(customerModel.getUpazillaModel());
				ordersModel.setUnionModel(customerModel.getUnionModel());
				
				cdm.setCartId(null);
				cdm.setProductModel(null);
				
				abc = ordersModel.getOrderQuantity() * Double.parseDouble(ordersModel.getProductModel().getProductPrice());
				total = total + abc;
				
				db.saveOrder(ordersModel);
				db.deleteCartDetailsByCartId(cdm);
				
			}
			
			TransactionInitiator trans = new TransactionInitiator();
			
			String response1 = trans.initTrnxnRequest(tranId, total);
			
			response.sendRedirect(response1);
		}
	}
}
