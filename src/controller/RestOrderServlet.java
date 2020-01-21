package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import dao.AreaDao;
import dao.DBData;
import model.CustomerModel;
import model.DistrictModel;
import model.DivisionModel;
import model.OrderSellerProductModel;
import model.OrdersModel;
import model.ProductModel;
import model.SellerModel;
import model.SellersProduct;
import model.UnionModel;
import model.UpazillaModel;

public class RestOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    DBData db = new DBData();
    AreaDao ad = new AreaDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action.equals("orderfrominventory")) {
			
			String coc, phone, expectedDate, street, village, zip, transId;
			int cid, quantity, pid;
			
			coc = request.getParameter("coc");
			phone = request.getParameter("phone");
			transId = request.getParameter("transId");
			expectedDate = request.getParameter("date");
			street = request.getParameter("street");
			village = request.getParameter("village");
			zip = request.getParameter("zip");
			
			cid = Integer.parseInt(request.getParameter("cid"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
			pid = Integer.parseInt(request.getParameter("pid"));
			
			ProductModel productModel = db.getProductById(pid);
			
			int divId = Integer.parseInt(request.getParameter("divId"));
			int a = Integer.parseInt(request.getParameter("disId"));
			int b = Integer.parseInt(request.getParameter("upaId"));
			int c = Integer.parseInt(request.getParameter("uniId"));
			
			ArrayList<DistrictModel> districtModels = (ArrayList<DistrictModel>) ad.getDistrictByDivisionId(divId);
			int disId = districtModels.get(a).getDistrictId();
			ArrayList<UpazillaModel> upazillaModels = (ArrayList<UpazillaModel>) ad.getUpazillaByDistrictId(disId);
			int upaId = upazillaModels.get(b).getUpazillaId();
			ArrayList<UnionModel> unionModels = (ArrayList<UnionModel>) ad.getUnionByUpazillaId(upaId);
			
			CustomerModel customerModel = db.getCustomerById(cid);
			OrdersModel ordersModel = new OrdersModel();
			DivisionModel divisionModel = ad.getDivisionById(divId);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String orderingTime = (dtf.format(now));
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				System.out.println(expectedDate + " line 89");
				ordersModel.setExpectedDeliveryDate(simpleDateFormat.parse(expectedDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			ordersModel.setTranId(transId);
			ordersModel.setCareOfContact(coc);
			ordersModel.setCustomerModel(customerModel);
			ordersModel.setDistrictModel(districtModels.get(a));
			ordersModel.setDivisionModel(divisionModel);
			ordersModel.setOrderDate(orderingTime);
			ordersModel.setOrderQuantity(quantity);
			ordersModel.setOrderStatus("unallocated");
			ordersModel.setOrderStreet(street);
			ordersModel.setOrderVillage(village);
			ordersModel.setOrderZipCode(zip);
			ordersModel.setPhoneNumber(phone);
			ordersModel.setUpazillaModel(upazillaModels.get(b));
			ordersModel.setUnionModel(unionModels.get(c));
			ordersModel.setProductModel(productModel);
			ordersModel.setPaymentStatus(true);
			
			System.out.println("here");
			
			db.saveOrder(ordersModel);
			
			PrintWriter pw = response.getWriter();
			
			JSONArray jsonArray = new JSONArray();
			
				
			pw.write(jsonArray.toString());
				
			
			
			
		}
		else if (action.equals("orderfromfarmer")) {

			String coc, phone, expectedDate, street, village, zip, division, district, upazilla, tranId;
			int cid, quantity, spid;
			
			coc = request.getParameter("coc");
			phone = request.getParameter("phone");
			
			expectedDate = request.getParameter("date");
			street = request.getParameter("street");
			village = request.getParameter("village");
			zip = request.getParameter("zip");
			tranId = request.getParameter("tranId");
			
			int divId = Integer.parseInt(request.getParameter("divId"));
			int a = Integer.parseInt(request.getParameter("disId"));
			int b = Integer.parseInt(request.getParameter("upaId"));
			int c = Integer.parseInt(request.getParameter("uniId"));
			
			ArrayList<DistrictModel> districtModels = (ArrayList<DistrictModel>) ad.getDistrictByDivisionId(divId);
			int disId = districtModels.get(a).getDistrictId();
			ArrayList<UpazillaModel> upazillaModels = (ArrayList<UpazillaModel>) ad.getUpazillaByDistrictId(disId);
			int upaId = upazillaModels.get(b).getUpazillaId();
			ArrayList<UnionModel> unionModels = (ArrayList<UnionModel>) ad.getUnionByUpazillaId(upaId);
			
			cid = Integer.parseInt(request.getParameter("cid"));
			quantity = Integer.parseInt(request.getParameter("quantity"));
			spid = Integer.parseInt(request.getParameter("pid"));
			
			SellersProduct sellersProduct = db.getSellerProductById(spid);
			
			DivisionModel divisionModel = ad.getDivisionById(divId);;
			
			CustomerModel customerModel = db.getCustomerById(cid);
			
			
			
			
			OrderSellerProductModel orderSellerProductModel = new OrderSellerProductModel();

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			String orderingTime = (dtf.format(now));
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				System.out.println(expectedDate + " line 89");
				orderSellerProductModel.setExpectedDeliveryDate(simpleDateFormat.parse(expectedDate));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			orderSellerProductModel.setSellerModel(sellersProduct.getSellerModel());
			orderSellerProductModel.setCareOfContact(coc);
			orderSellerProductModel.setCustomerModel(customerModel);
			orderSellerProductModel.setDistrictModel(districtModels.get(a));
			orderSellerProductModel.setDivisionModel(divisionModel);
			orderSellerProductModel.setOrderDate(orderingTime);
			orderSellerProductModel.setOrderQuantity(quantity);
			orderSellerProductModel.setOrderStatus("unallocated");
			orderSellerProductModel.setOrderStreet(street);
			orderSellerProductModel.setOrderVillage(village);
			orderSellerProductModel.setOrderZipCode(zip);
			orderSellerProductModel.setPhoneNumber(phone);
			orderSellerProductModel.setUpazillaModel(upazillaModels.get(b));
			orderSellerProductModel.setSellersProduct(sellersProduct);
			orderSellerProductModel.setUnionModel(unionModels.get(c));
			orderSellerProductModel.setPaymentStatus(false);
			orderSellerProductModel.setTranId(tranId);
			
			db.saveSellerProductOrder(orderSellerProductModel);
			
			PrintWriter pw = response.getWriter();
			
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("tranId", tranId);
				jsonArray.put(jsonObject);
				pw.write(jsonArray.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (action.equalsIgnoreCase("sellerorderSuccess")) {
			String tranId = request.getParameter("tranId");
			
			OrderSellerProductModel orderSellerProductModel = db.getOrderSellerProductByTranId(tranId);
			orderSellerProductModel.setPaymentStatus(true);
			db.updateOrderSellerProduct(orderSellerProductModel);
			
			PrintWriter pWriter = response.getWriter();
			
			JSONArray jsonArray = new JSONArray();
			pWriter.write(jsonArray.toString());
		}
	
	}

}
