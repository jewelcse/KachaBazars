package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.DBData;

import java.util.ArrayList;
import java.util.Base64;
import javassist.bytecode.ByteArray;
import model.CategoryModel;
import model.SellerModel;
import model.SellersProduct;
import model.SubcategoryModel;
import model.UnitModel;

public class RestSellerProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if (action == null) {
			System.out.println("No action is GIVEN");
		}
		else if (action.equals("getselleraddspinner")) {
			System.out.println(action);
			
			ArrayList<CategoryModel> categoryModels = (ArrayList<CategoryModel>) db.getAllCategories();
			ArrayList<SubcategoryModel> subcategoryModelas = (ArrayList<SubcategoryModel>) db.getAllSubcategories();
			ArrayList<UnitModel> unitModels = (ArrayList<UnitModel>) db.getAllUnits();
			
			JSONArray jsonArray = new JSONArray();
			
			jsonArray.put(categoryModels);
			jsonArray.put(subcategoryModelas);
			jsonArray.put(unitModels);
			
			try {
				System.out.println(jsonArray.get(2).toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter pw = response.getWriter();
			pw.write(jsonArray.toString());
			
		}
		else if (action.equals("getGovtPrice")) {
			
			int subId = Integer.parseInt(request.getParameter("subId"));
			
			SubcategoryModel subcategoryModel = db.getSubcategoryById(subId);
			
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			PrintWriter pw = response.getWriter();
			
			try {
				
				jsonObject.put("govtPrice", subcategoryModel.getGovtPrice());
				jsonArray.put(jsonObject);
				pw.write(jsonArray.toString());
				
				System.out.println(jsonArray.toString());
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action == null) {
			System.out.println("No action is GIVEN");
		} else if (action.equals("addsellerproduct")) {

			String encoded, productName, productImageName, productImagePath, productDescription;
			int sid, catId, subcatId, unitId;
			double productPrice, productQuantity;

			productDescription = request.getParameter("description");
			productQuantity = Double.parseDouble(request.getParameter("quantity"));
			productPrice = Double.parseDouble(request.getParameter("price"));
			productDescription = request.getParameter("description");
			
			sid = Integer.parseInt(request.getParameter("sid"));
			catId = Integer.parseInt(request.getParameter("catId"));
			subcatId = Integer.parseInt(request.getParameter("subcatId"));
			unitId = Integer.parseInt(request.getParameter("unitId"));
			
			encoded = request.getParameter("image");
			productName = request.getParameter("name");
			
			
			SellerModel sellerModel = db.getSellerById(sid);
			CategoryModel categoryModel = db.getCategoryById(catId);
			SubcategoryModel subcategoryModel = db.getSubcategoryById(subcatId);
			UnitModel unitModel = db.getUnitById(unitId);
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			String time = (dtf.format(now));  
			
			productImageName = time + "_" + productName+ ".jpg";
			
			
			byte[] decodedBytes = Base64.getMimeDecoder().decode(encoded);
			
			String upload = "C:\\Users\\HP\\Desktop\\Backups\\7_10\\ecommerce\\WebContent\\images\\sellerproducts\\";
			
			String savePath=("C:\\Users\\HP\\Desktop\\Backups\\7_10\\ecommerce\\WebContent\\images\\sellerproducts"+File.separator+productImageName);
			//	String savePath=("http:\\localhost:9090\\ecommerce\\images\\sellerproducts"+File.separator+productImageName);
				//http://localhost:9090/ecommerce/images/products/20190923144614_pic11.jpg
				File fileSaveDirectory = new File(savePath);
			

				
				FileOutputStream fileOuputStream = new FileOutputStream(savePath);
				fileOuputStream.write(decodedBytes);
				fileOuputStream.close();
				
				SellersProduct sellersProduct = new SellersProduct();
				
				sellersProduct.setProductName(productName);
				sellersProduct.setProductImageName(productImageName);
				sellersProduct.setProductImagePath(savePath);
				sellersProduct.setCategoryModel(categoryModel);
				sellersProduct.setProductDescription(productDescription);
				sellersProduct.setProductPrice(productPrice);
				sellersProduct.setProductQuantity(productQuantity);
				sellersProduct.setSellerModel(sellerModel);
				sellersProduct.setSubcategoryModel(subcategoryModel);
				sellersProduct.setUnitModel(unitModel);
				
				db.saveSellerProduct(sellersProduct);
				//	part.write(savePath+File.separator);
			
				JSONArray jsonArray = new JSONArray();
				PrintWriter printWriter = response.getWriter();
				printWriter.write(jsonArray.toString());
		}
	}

	private void getUnitById(int unitId) {
		// TODO Auto-generated method stub
		
	}

}
