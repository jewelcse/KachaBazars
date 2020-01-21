package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sun.org.apache.bcel.internal.generic.NEW;

import dao.AreaDao;
import dao.DBData;
import model.BidModel;
import model.CustomerModel;
import model.DistrictModel;
import model.DivisionModel;
import model.SellerModel;
import model.UnionModel;
import model.UpazillaModel;

@MultipartConfig
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	AreaDao aDao = new AreaDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		String action = request.getParameter("action");

		if (action.equals("view")) {
			List<SellerModel> sellerModels = db.getAllSellers();
			request.setAttribute("customers", sellerModels);
			rd = request.getRequestDispatcher("/Sellers.jsp");
		}
		else if(action.equals("new")) {
			SellerModel sellerModel = new SellerModel();

			request.setAttribute("sellers", sellerModel);
			request.setAttribute("action", "reg");

			rd = request.getRequestDispatcher("/SellerRegistration.jsp");
		}
		else if (action.equals("login")) {
			SellerModel sellerModel = new SellerModel();

			request.setAttribute("sellers", sellerModel);
			request.setAttribute("action", "login");

			rd = request.getRequestDispatcher("/sellers_login.jsp");
		}
		else if (action.equals("logout")) {
			session.invalidate();
			request.setAttribute("action", "login");
			rd = request.getRequestDispatcher("/sellers_login.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		String action = request.getParameter("action");
		System.out.println("action = " + action);
		if (action.equals("reg")) {
			SellerModel sellerModel = new SellerModel();

			String sellerFirstName = request.getParameter("sellerFirstName");
			String sellerLastName = request.getParameter("sellerLastName");
			String sellerNID = request.getParameter("sellerNID");
			String sellerGender = request.getParameter("sellerGender");
			String sellerPhone = request.getParameter("sellerPhone");
			String sellerPassword = request.getParameter("sellerPassword");

			int divId = Integer.parseInt(request.getParameter("sellerDivision"));
			DivisionModel sellerDivision = aDao.getDivisionById(divId);
			
			int disId = Integer.parseInt(request.getParameter("sellerDistrict"));
			DistrictModel districtModel = aDao.getDistrictById(disId);
			
			int upaId = Integer.parseInt(request.getParameter("sellerUpazilla"));
			UpazillaModel upazillaModel = aDao.getUpazillaById(upaId);
			
			int uniId = Integer.parseInt(request.getParameter("sellerUnion"));
			UnionModel unionModel = aDao.getUnionById(uniId);
			
			
			
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			String sellerDOB = request.getParameter("sellerDOB");

			try {
				sellerModel.setSellerDOB(simpleDateFormat.parse(sellerDOB));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			LocalDateTime now = LocalDateTime.now();
			String time = (dtf.format(now));

			Part part = request.getPart("sellerImage");
			String sellerImageName = getImageFileName(part);
			sellerImageName = time + "_" + sellerImageName;

			String savePath = ("C:\\Users\\HP\\git\\test\\ecommerce\\WebContent\\images\\sellers" + File.separator + sellerImageName);

			File fileSaveDirectory = new File(savePath);
			part.write(savePath + File.separator);

			sellerModel.setUnionModel(unionModel);
			sellerModel.setUpazillaModel(upazillaModel);
			sellerModel.setDistrictModel(districtModel);
			sellerModel.setDivisionmodel(sellerDivision);
			sellerModel.setSellerImageName(sellerImageName);
			sellerModel.setSellerImagePath(savePath);
			sellerModel.setSellerPhone(sellerPhone);
			sellerModel.setSellerFirstName(sellerFirstName);
			sellerModel.setSellerLastName(sellerLastName);
			sellerModel.setSellerNID(sellerNID);
			sellerModel.setSellerGender(sellerGender);
			sellerModel.setSellerPassword(sellerPassword);

			db.saveSeller(sellerModel);
			request.getRequestDispatcher("/Sellers.jsp").forward(request, response);
		}

		else if (action.equals("login")) {
			String phone = request.getParameter("sellerPhone");
			String password = request.getParameter("sellerPassword");

			SellerModel sellerModel = db.getPasswordByPhone(phone);

			if (sellerModel == null) {
				request.setAttribute("message", "Account id Invalid...");
				request.getRequestDispatcher("/sellers_login.jsp").forward(request, response);
			} else if (phone.equals(sellerModel.getSellerPhone()) && password.equals(sellerModel.getSellerPassword())) {
				HttpSession session = request.getSession();
				
				session.setAttribute("message", "Hi " + sellerModel.getSellerFirstName());
				
				int sid = sellerModel.getSellerId();
				session.setAttribute("sid", sid);

				request.getRequestDispatcher("/seller_home.jsp").forward(request, response);
			}
			else {
				request.setAttribute("message", "Account id or wrong password...");
				request.getRequestDispatcher("/sellers_login.jsp").forward(request, response);
			}
		}

	}

	private String getImageFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}

}
