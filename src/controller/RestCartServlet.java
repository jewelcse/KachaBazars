package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.AreaDao;
import dao.DBData;
import model.CartDetailsModel;
import model.CartModel;
import model.CustomerModel;
import model.DistrictModel;
import model.DivisionModel;
import model.OrdersModel;
import model.ProductModel;
import model.UnionModel;
import model.UpazillaModel;

public class RestCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	AreaDao ad = new AreaDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("getcartdetails")) {

			int cid = Integer.parseInt(request.getParameter("cid"));

			CustomerModel customerModel = db.getCustomerById(cid);
			CartModel cartModel = db.getCartByCustomerId(cid);
			List<CartDetailsModel> cartDetailsModels = db.getCartDetailsByCartId(cartModel.getCartId());

			Iterator<CartDetailsModel> it = cartDetailsModels.iterator();

			JSONArray jsonArray = new JSONArray();

			while (it.hasNext()) {
				Object type = (Object) it.next();

				CartDetailsModel sub = (CartDetailsModel) type;

				JSONObject JO = new JSONObject();

				try {
					JO.put("productName", sub.getProductModel().getProductName());
					JO.put("price", sub.getProductModel().getProductPrice());
					JO.put("stotal",
							Double.parseDouble(sub.getProductModel().getProductPrice()) * sub.getCartProductQuantity());

					jsonArray.put(JO);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			PrintWriter pw = response.getWriter();
			pw.write(jsonArray.toString());

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("cartadd")) {

			int cid = Integer.parseInt(request.getParameter("cid"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			String qty = request.getParameter("qty");

			CustomerModel customerModel = db.getCustomerById(cid);
			ProductModel productModel = db.getProductById(pid);

			CartModel cartModel = db.getCartByCustomerId(cid);
			CartDetailsModel cartDetailsModel = new CartDetailsModel();

			cartDetailsModel.setCartId(cartModel);
			cartDetailsModel.setCartProductQuantity(Double.parseDouble(qty));
			cartDetailsModel.setCartProductStatus("Undecided");
			cartDetailsModel.setProductModel(productModel);

			db.saveCartDetails(cartDetailsModel);

			JSONArray jsonArray = new JSONArray();

			PrintWriter pw = response.getWriter();
			pw.write(jsonArray.toString());

		} else if (action.equalsIgnoreCase("cartorder")) {

			int cid = Integer.parseInt(request.getParameter("cid"));

			CartModel cartModel = db.getCartByCustomerId(cid);
			List<CartDetailsModel> cartDetailsModel = db.getCartDetailsByCartId(cartModel.getCartId());

			String coc, phone, expectedDate, street, village, zip;

			coc = request.getParameter("coc");
			phone = request.getParameter("phone");

			expectedDate = request.getParameter("date");
			street = request.getParameter("street");
			village = request.getParameter("village");
			zip = request.getParameter("zip");
			
			cid = Integer.parseInt(request.getParameter("cid"));			
			
			int divId = Integer.parseInt(request.getParameter("divId"));
			int a = Integer.parseInt(request.getParameter("disId"));
			int b = Integer.parseInt(request.getParameter("upaId"));
			int c = Integer.parseInt(request.getParameter("uniId"));
			
			
			ArrayList<DistrictModel> districtModels = (ArrayList<DistrictModel>) ad.getDistrictByDivisionId(divId);
			int disId = districtModels.get(a).getDistrictId();
			ArrayList<UpazillaModel> upazillaModels = (ArrayList<UpazillaModel>) ad.getUpazillaByDistrictId(disId);
			int upaId = upazillaModels.get(b).getUpazillaId();
			ArrayList<UnionModel> unionModels = (ArrayList<UnionModel>) ad.getUnionByUpazillaId(upaId);

			DivisionModel divisionModel = ad.getDivisionById(divId);
			
			OrdersModel ordersModel = new OrdersModel();

			ordersModel.setUpazillaModel(upazillaModels.get(b));
			ordersModel.setUnionModel(unionModels.get(c));
			ordersModel.setDistrictModel(districtModels.get(a));
			ordersModel.setDivisionModel(divisionModel);

			CustomerModel customerModel = db.getCustomerById(cid);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String orderingTime = (dtf.format(now));

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(expectedDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			String hex = UUID.randomUUID().toString();

			LocalDateTime now1 = LocalDateTime.now();

			DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");

			String tranId = hex + dtf2.format(now1);

			Iterator<CartDetailsModel> it = cartDetailsModel.iterator();

			double total = 0;

			while (it.hasNext()) {

				Object type = (Object) it.next();
				CartDetailsModel cdm = (CartDetailsModel) type;

				ordersModel.setTranId(tranId);
				ordersModel.setPaymentStatus(false);
				ordersModel.setCareOfContact(coc);
				ordersModel.setCustomerModel(customerModel);
				ordersModel.setOrderDate(orderingTime);
				ordersModel.setOrderQuantity(cdm.getCartProductQuantity());
				ordersModel.setOrderStatus("unallocated");
				ordersModel.setOrderStreet(street);
				ordersModel.setOrderVillage(village);
				ordersModel.setOrderZipCode(zip);
				ordersModel.setPhoneNumber(phone);
				ordersModel.setProductModel(cdm.getProductModel());

				total = total
						+ (cdm.getCartProductQuantity() * Double.parseDouble(cdm.getProductModel().getProductPrice()));

				cdm.setCartId(null);
				cdm.setProductModel(null);

				System.out.println("here");

				db.saveOrder(ordersModel);
				db.deleteCartDetailsByCartId(cdm);

			}

			PrintWriter pw = response.getWriter();

			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();

			
				try {
					jsonObject.put("tranId", tranId);
					jsonObject.put("total", total+"");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				jsonArray.put(jsonObject);
				pw.write(jsonArray.toString());  
			

		} else if (action.equalsIgnoreCase("cartorderdone")) {

			String tranId = request.getParameter("tranId");

			List<OrdersModel> ordersModel = db.getOrderlistByTranId(tranId);

			Iterator<OrdersModel> it = ordersModel.iterator();
			
			while (it.hasNext()) {

				Object type = (Object) it.next();
				OrdersModel cdm = (OrdersModel) type;
				cdm.setPaymentStatus(true);
				db.updateOrder(cdm);
			}

			PrintWriter pw = response.getWriter();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			String message = "Payment completed successfully";
			try {
				jsonObject.put("mes", message);
				jsonArray.put(jsonObject);
				pw.write(jsonArray.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}

}
