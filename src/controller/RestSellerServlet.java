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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import antlr.collections.List;
import dao.DBData;
import model.CustomerModel;
import model.SellerModel;
import model.SellersProduct;


public class RestSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBData db = new DBData();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		if (action == null) {
			System.out.println("No action is GIVEN");
		}
		else if (action.equals("getSellerProductsById")) {
			
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			
			System.out.println(sid);
			
			ArrayList<SellersProduct> sellersProducts = db.getSellerProductBySID(sid);
			
			JSONArray jsonArray = new JSONArray();
			
			PrintWriter pw = response.getWriter();
			
			Iterator<SellersProduct> it2 = sellersProducts.iterator();
			
			while (it2.hasNext()) {
				Object type = (Object) it2.next();

				JSONObject JO = new JSONObject();
				
				SellersProduct sub =  (SellersProduct) type;
				try {
					
					JO.put("productName", sub.getProductName());
					JO.put("productDescription", sub.getProductDescription());
					JO.put("productQuantity", sub.getProductQuantity());
					JO.put("productImageName", sub.getProductImageName());
					JO.put("productId", sub.getProductId());
					JO.put("sellerId", sub.getSellerModel().getSellerId());
					JO.put("sellerName", sub.getSellerModel().getSellerFirstName()+ " " + sub.getSellerModel().getSellerLastName());
					JO.put("productPrice", sub.getProductPrice());
					
					jsonArray.put(JO);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
			System.out.println(jsonArray);
			
			pw.write(jsonArray.toString());
			
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		System.out.println("Post seler");
		if (action == null) {
			System.out.println("No action Given");
		}
		else if (action.equals("sellerlogin")) {
			String phone = request.getParameter("k1");
			String pass = request.getParameter("k2");
			
			SellerModel sellerModel = new SellerModel();
			
			sellerModel.setSellerPhone(phone);
			sellerModel.setSellerPassword(pass);			
			
			PrintWriter pw = response.getWriter();
			
			SellerModel sellerModel2 = db.getPasswordByPhone(phone);
			
			if(sellerModel2.getSellerPhone().equals(phone) && sellerModel2.getSellerPassword().equals(pass))
			{
				ArrayList<SellerModel> sellerModels = new ArrayList<SellerModel>();
				sellerModels.add(sellerModel2);
				
				JSONArray jsonArray = new JSONArray();
				
				jsonArray.put(sellerModels);
				
				pw.write(jsonArray.toString());
					
			}
		}
			
	}

}
