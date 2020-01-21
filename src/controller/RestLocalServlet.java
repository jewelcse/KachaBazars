package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
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
import dao.AreaDao;
import dao.DBData;
import model.CartModel;
import model.CustomerModel;
import model.DistrictModel;
import model.DivisionModel;
import model.SellersProduct;
import model.UnionModel;
import model.UpazillaModel;

public class RestLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	AreaDao areaDao = new AreaDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if (action == null) {
			System.out.println("No action given");
		} else if (action.equals("getLocalProducts")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			CustomerModel customerModel = db.getCustomerById(cid);

			int divId = customerModel.getDivisionmodel().getDivisionId();
			int disId = customerModel.getDistrictModel().getDistrictId();
			int upaId = customerModel.getUpazillaModel().getUpazillaId();
			int uniId = customerModel.getUnionModel().getUnionId();

			ArrayList<SellersProduct> sellersProductsUnion = (ArrayList<SellersProduct>) db.getProductByUnion(uniId);
			ArrayList<SellersProduct> sellersProductsUpazilla = (ArrayList<SellersProduct>) db
					.getProductByUpazilla(upaId);
			ArrayList<SellersProduct> sellersProductsDistrict = (ArrayList<SellersProduct>) db
					.getProductByDistrict(disId);
			ArrayList<SellersProduct> sellersProductsDivision = (ArrayList<SellersProduct>) db
					.getProductByDivision(divId);

			JSONArray jsonArray = new JSONArray();
			JSONArray jsonArray2 = new JSONArray();
			JSONArray jsonArray3 = new JSONArray();
			JSONArray jsonArray4 = new JSONArray();

			Iterator<SellersProduct> it = sellersProductsUnion.iterator();

			while (it.hasNext()) {
				Object type = (Object) it.next();

				JSONObject JO = new JSONObject();

				SellersProduct sub = (SellersProduct) type;
				try {
					JO.put("govtPrice", sub.getSubcategoryModel().getGovtPrice());
					JO.put("productName", sub.getProductName());
					JO.put("productDescription", sub.getProductDescription());
					JO.put("productQuantity", sub.getProductQuantity());
					JO.put("productImageName", sub.getProductImageName());
					JO.put("productId", sub.getProductId());
					JO.put("sellerId", sub.getSellerModel().getSellerId());
					JO.put("sellerName",
							sub.getSellerModel().getSellerFirstName() + " " + sub.getSellerModel().getSellerLastName());
					JO.put("productPrice", sub.getProductPrice());

					jsonArray2.put(JO);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			Iterator<SellersProduct> it1 = sellersProductsUpazilla.iterator();

			while (it1.hasNext()) {
				Object type = (Object) it1.next();

				JSONObject JO = new JSONObject();

				SellersProduct sub = (SellersProduct) type;
				try {

					JO.put("productName", sub.getProductName());
					JO.put("productDescription", sub.getProductDescription());
					JO.put("productQuantity", sub.getProductQuantity());
					JO.put("productImageName", sub.getProductImageName());
					JO.put("productId", sub.getProductId());
					JO.put("sellerId", sub.getSellerModel().getSellerId());
					JO.put("sellerName",
							sub.getSellerModel().getSellerFirstName() + " " + sub.getSellerModel().getSellerLastName());
					JO.put("productPrice", sub.getProductPrice());

					jsonArray3.put(JO);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			Iterator<SellersProduct> it2 = sellersProductsDistrict.iterator();

			while (it2.hasNext()) {
				Object type = (Object) it2.next();

				JSONObject JO = new JSONObject();

				SellersProduct sub = (SellersProduct) type;
				try {

					JO.put("productName", sub.getProductName());
					JO.put("productDescription", sub.getProductDescription());
					JO.put("productQuantity", sub.getProductQuantity());
					JO.put("productImageName", sub.getProductImageName());
					JO.put("productId", sub.getProductId());
					JO.put("sellerId", sub.getSellerModel().getSellerId());
					JO.put("sellerName",
							sub.getSellerModel().getSellerFirstName() + " " + sub.getSellerModel().getSellerLastName());
					JO.put("productPrice", sub.getProductPrice());

					jsonArray4.put(JO);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			jsonArray.put(jsonArray2);
			jsonArray.put(jsonArray3);
			jsonArray.put(jsonArray4);

			System.out.println(jsonArray4.toString() + disId);

			PrintWriter pw = response.getWriter();

			pw.write(jsonArray.toString());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("reg")) {

			int divId = Integer.parseInt(request.getParameter("divId"));
			int a = Integer.parseInt(request.getParameter("disId"));
			int b = Integer.parseInt(request.getParameter("upaId"));
			int c = Integer.parseInt(request.getParameter("uniId"));
			String encoded = request.getParameter("img");
			String fname, lname, phone, pass, village, street, zip, hnum, date, imageName;

			fname = request.getParameter("fname");
			lname = request.getParameter("lname");
			phone = request.getParameter("phone");
			village = request.getParameter("village");
			street = request.getParameter("street");
			hnum = request.getParameter("hnum");
			zip = request.getParameter("zip");
			pass = request.getParameter("pass");
			date = request.getParameter("dob");

			ArrayList<DistrictModel> districtModels = (ArrayList<DistrictModel>) areaDao.getDistrictByDivisionId(divId);
			int disId = districtModels.get(a).getDistrictId();
			ArrayList<UpazillaModel> upazillaModels = (ArrayList<UpazillaModel>) areaDao.getUpazillaByDistrictId(disId);
			int upaId = upazillaModels.get(b).getUpazillaId();
			ArrayList<UnionModel> unionModels = (ArrayList<UnionModel>) areaDao.getUnionByUpazillaId(upaId);
			int uniId = unionModels.get(c).getUnionId();

			DivisionModel divisionModel = areaDao.getDivisionById(divId);
			DistrictModel districtModel = areaDao.getDistrictById(disId);
			UpazillaModel upazillaModel = areaDao.getUpazillaById(upaId);
			UnionModel unionModel = areaDao.getUnionById(uniId);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			LocalDateTime now = LocalDateTime.now();
			String time = (dtf.format(now));

			imageName = time + fname + ".jpg";

			byte[] decodedBytes = Base64.getMimeDecoder().decode(encoded);

			String upload = "C:\\Users\\HP\\Desktop\\Backups\\7_10\\ecommerce\\WebContent\\images\\customers\\";

			String savePath = ("C:\\Users\\HP\\Desktop\\Backups\\7_10\\ecommerce\\WebContent\\images\\customers\\" + imageName);
			// String
			// savePath=("http:\\localhost:9090\\ecommerce\\images\\sellerproducts"+File.separator+productImageName);
			// http://localhost:9090/ecommerce/images/products/20190923144614_pic11.jpg
			File fileSaveDirectory = new File(savePath);

			FileOutputStream fileOuputStream = new FileOutputStream(savePath);
			fileOuputStream.write(decodedBytes);
			fileOuputStream.close();
			
			
			
			CustomerModel customerModel = new CustomerModel();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			
			try {
				customerModel.setCustomerDOB(simpleDateFormat.parse(date));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			customerModel.setCustomerFirstName(fname);
			customerModel.setCustomerLastName(lname);
			customerModel.setCustomerHoldingNumber(hnum);
			customerModel.setCustomerImageName(imageName);
			customerModel.setCustomerImagePath(savePath);
			customerModel.setCustomerPassword(pass);
			customerModel.setCustomerPhone(phone);
			customerModel.setCustomerStreet(street);
			customerModel.setCustomerVillage(village);
			customerModel.setCustomerZipcode(zip);
			customerModel.setDistrictModel(districtModel);
			customerModel.setDivisionmodel(divisionModel);
			customerModel.setUnionModel(unionModel);
			customerModel.setUpazillaModel(upazillaModel);
			
			db.saveCustomer(customerModel);
			
			customerModel = db.getCustomerByphone(phone);
			
			
			CartModel cartModel = new CartModel();
			
			cartModel.setCustomerModel(customerModel);						
			db.saveCart(cartModel);
			
			
			PrintWriter pWriter = response.getWriter();
			
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject(customerModel);
			
			jsonArray.put(jsonObject);
			pWriter.write(jsonArray.toString());

		}
	}

}
