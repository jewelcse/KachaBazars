package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import dao.DBData;
import model.CategoryModel;
import model.ProductModel;
import model.SubcategoryModel;
import model.UnitModel;

@MultipartConfig
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DBData db = new DBData();
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd= null;
		String action=request.getParameter("action");
		

	//	System.out.println("jhm"+action);
		if(action.equals("new"))
		{
			ProductModel productModel=new ProductModel();
			request.setAttribute("product", productModel);
			request.setAttribute("action", "new");
			request.getRequestDispatcher("/newproduct.jsp").forward(request, response);
		}
		else if (action.equals("view")) {
			ProductModel productModel = new ProductModel();
			request.setAttribute("products", productModel);
			request.setAttribute("action", "view");
			
			rd = request.getRequestDispatcher("/product.jsp");
		}
		else if (action.equals("update")) {
			int pid = Integer.parseInt(request.getParameter("pid").toString());
			ProductModel productModel = db.getProductById(pid);
			request.setAttribute("pid", pid);
			request.setAttribute("product", productModel);
			request.setAttribute("action", "update");
			
			
			rd = request.getRequestDispatcher("/newproduct.jsp");
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		String action = request.getParameter("action");
		System.out.println("line 50 "+action);
		
		if (action.equals("submit")) {
			String productName = request.getParameter("productName");
			String productDescription = request.getParameter("productDescription");
			Part part = request.getPart("productImage");
			String productImageName = getImageFileName(part);
			String productPrice = request.getParameter("productPrice");
	//		String productCategory = request.getParameter("dropdownProductCategory").toString();
	//		String productSubcategory = request.getParameter("dropdownProductSubcategory").toString();
			String governmentPrice = request.getParameter("governmentPrice");;
	//		String productUnit = request.getParameter("unit").toString();
			String productType = request.getParameter("productType");
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			String time = (dtf.format(now));  
			
			productImageName = time + "_" +  productImageName;
			
			
		//	String savePath=("C:\\Users\\HP\\git\\test\\ecommerce\\WebContent\\images\\products"+File.separator+productImageName);
			
			String savePath=("C:\\Users\\HP\\Desktop\\Backups\\7_10\\ecommerce\\WebContent\\images\\products"+File.separator+productImageName);

			
			File fileSaveDirectory = new File(savePath);
			part.write(savePath+File.separator);
			
			
			
			CategoryModel categoryModel = new CategoryModel();
			SubcategoryModel subcategoryModel = new SubcategoryModel();
			
			
			int cid;
			cid = Integer.parseInt(request.getParameter("dropdownProductCategory"));
			categoryModel = db.getCategoryById(cid);
			
			int sid;
			sid = Integer.parseInt(request.getParameter("dropdownProductSubcategory"));
			subcategoryModel = db.getSubcategoryById(sid);
			
			int uid;
			uid = Integer.parseInt(request.getParameter("unit").toString());
			UnitModel unitModel = db.getUnitById(uid);
			
			ProductModel productModel = new ProductModel();
			
			productModel.setProductName(productName);
			productModel.setProductDescription(productDescription);
			productModel.setProductCategory(categoryModel);
			productModel.setProductSubcategory(subcategoryModel);
			productModel.setProductImageName(productImageName);
			productModel.setProductImagePath(savePath);
			productModel.setProductPrice(productPrice);
			productModel.setGovernmentPrice(governmentPrice);
			productModel.setProductUnit(unitModel);
			productModel.setType(productType);
			
			db.saveProduct(productModel);
			rd = request.getRequestDispatcher("/product.jsp");

		}
		
		else if(action.equals("addmore")) {
			String productName = request.getParameter("productName");
			String productDescription = request.getParameter("productDescription");
			Part part = request.getPart("productImage");
			String productImageName = getImageFileName(part);
			String productPrice = request.getParameter("productPrice");
			//String productCategory = request.getParameter("dropdownProductCategory").toString();
			String productSubcategory = request.getParameter("dropdownProductSubcategory").toString();
			String governmentPrice = request.getParameter("governmentPrice");;
			String productType = request.getParameter("productType");

			System.out.println(productPrice);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
			LocalDateTime now = LocalDateTime.now();  
			String time = (dtf.format(now));  
			
			productImageName = time + "_" +  productImageName;
			
			
			String savePath=("C:\\Users\\HP\\git\\test\\ecommerce\\WebContent\\images\\products"+File.separator+productImageName);
			
			File fileSaveDirectory = new File(savePath);
			part.write(savePath+File.separator);
			
			
			
			CategoryModel categoryModel = new CategoryModel();
			SubcategoryModel subcategoryModel = new SubcategoryModel();
			
			
			int cid;
			cid = Integer.parseInt(request.getParameter("dropdownProductCategory"));
			categoryModel = db.getCategoryById(cid);
			
			int sid;
			sid = Integer.parseInt(request.getParameter("dropdownProductSubcategory"));
			subcategoryModel = db.getSubcategoryById(sid);
			
			int uid;
			uid = Integer.parseInt(request.getParameter("unit").toString());
			UnitModel unitModel = db.getUnitById(uid);
			
			ProductModel productModel = new ProductModel();
			
			productModel.setProductName(productName);
			productModel.setProductDescription(productDescription);
			productModel.setProductCategory(categoryModel);
			productModel.setProductSubcategory(subcategoryModel);
			productModel.setProductImageName(productImageName);
			productModel.setProductImagePath(savePath);
			productModel.setProductPrice(productPrice);
			productModel.setGovernmentPrice(governmentPrice);
			productModel.setProductUnit(unitModel);
			productModel.setType(productType);
			
			db.saveProduct(productModel);
			System.out.println("sgdsjabjsabdsabkdbsajkdbjksabdkjsbakjdbjksabdjksabjkdbsjkadjksakj");
			request.setAttribute("action", "addmore");
			rd = request.getRequestDispatcher("/newproduct.jsp");
		}
		else if (action.equals("update")) {
			String productImageName = null;
			String productName = request.getParameter("productName");
			String productDescription = request.getParameter("productDescription");
			Part part;
			ProductModel productModel = new ProductModel();
			ProductModel productModel2 = new ProductModel();
			System.out.println("line 184 " + request.getPart("productImage"));
			int pid = Integer.parseInt(request.getParameter("pid").toString());
			productModel2 = db.getProductById(pid);
			if(request.getPart("productImage").equals("org.apache.catalina.core.ApplicationPart@808f7dc")) {
				productModel.setProductImageName(productModel2.getProductImageName());
				productModel.setProductImagePath(productModel2.getProductImagePath());
				System.out.println(" line 209 " + productModel2.getProductImagePath());
			}
			
			else {
				part = request.getPart("productImage");
				productImageName = getImageFileName(part);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
				LocalDateTime now = LocalDateTime.now();  
				String time = (dtf.format(now));  
				
				productImageName = time + "_" +  productImageName;
				String savePath=("C:\\Users\\HP\\Desktop\\Backups\\7_10\\ecommerce\\WebContent\\images\\products"+File.separator+productImageName);

				File fileSaveDirectory = new File(savePath);
				part.write(savePath+File.separator);
				productModel.setProductImageName(productImageName);
				productModel.setProductImagePath(savePath);
				
				System.out.println("line 201" + savePath);
				
			}
			
			if (productImageName == null) {
				productModel.setProductImageName(productModel2.getProductImageName());
				productModel.setProductImagePath(productModel2.getProductImagePath());
				System.out.println("line 228 " + productModel2.getProductImagePath());
			}
			
			String productPrice = request.getParameter("productPrice");
			//String productCategory = request.getParameter("dropdownProductCategory").toString();
			String productSubcategory = request.getParameter("dropdownProductSubcategory").toString();
			String governmentPrice = request.getParameter("governmentPrice");;
			String productType = request.getParameter("productType");

			
			int uid;
			uid = Integer.parseInt(request.getParameter("unit").toString());
			UnitModel unitModel = db.getUnitById(uid);
			
			CategoryModel categoryModel = new CategoryModel();
			SubcategoryModel subcategoryModel = new SubcategoryModel();
			
			int cid;
			cid = Integer.parseInt(request.getParameter("dropdownProductCategory").toString());			
			categoryModel = db.getCategoryById(cid);
			
			int sid;
			sid = Integer.parseInt(request.getParameter("dropdownProductSubcategory"));
			subcategoryModel = db.getSubcategoryById(sid);			
			productModel.setProductId(pid);
			productModel.setProductUnit(unitModel);
			productModel.setProductName(productName);
			productModel.setProductDescription(productDescription);
			productModel.setProductCategory(categoryModel);
			productModel.setProductSubcategory(subcategoryModel);
			productModel.setProductPrice(productPrice);
			productModel.setGovernmentPrice(governmentPrice);
			productModel.setType(productType);
			
			db.updateProduct(productModel);
			rd = request.getRequestDispatcher("/product.jsp");
		}
		
		
		rd.forward(request, response);
		
		
	}


	private String getImageFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
	}

}
