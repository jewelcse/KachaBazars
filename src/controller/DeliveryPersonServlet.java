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
import javax.servlet.http.Part;

import dao.DBData;
import model.AreaModel;
import model.DeliveryPersonModel;
import model.SellerModel;

@MultipartConfig
public class DeliveryPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DBData db = new DBData();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		if (action.equals("view")) {
			List<DeliveryPersonModel> deliveryPersonModels = db.getAllDeliveryPersons();
			request.setAttribute("delivery", deliveryPersonModels);
			request.getRequestDispatcher("/devilery-person-login.jsp").forward(request, response);
		}
		else if (action.equals("add")) {
			
			request.setAttribute("action", "add");
			rd = request.getRequestDispatcher("/new_delivery_person.jsp");
		}
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DeliveryPersonModel deliveryPersonModel = new DeliveryPersonModel();
		
		deliveryPersonModel.setDeliveryPersonFirstName(request.getParameter("deliveryPersonFirstName"));
		deliveryPersonModel.setDeliveryPersonLastName(request.getParameter("deliveryPersonLastName"));
		deliveryPersonModel.setDeliveryPersonPhone(request.getParameter("deliveryPersonPhone"));
		deliveryPersonModel.setDeliveryPersonGender(request.getParameter("deliveryPersonGender"));
		deliveryPersonModel.setDeliveryPersonNID(request.getParameter("deliveryPersonNID"));
		
		Part part = request.getPart("sellerImage");
		String deliveryPersonImageName = getImageFileName(part);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
		LocalDateTime now = LocalDateTime.now();  
		String time = (dtf.format(now)); 
		
		deliveryPersonImageName = time + "_" +  deliveryPersonImageName;
		
		
		String savePath=("C:\\Users\\HP\\git\\test\\ecommerce\\WebContent\\images\\delivery"+File.separator+deliveryPersonImageName);
		
		File fileSaveDirectory = new File(savePath);
		part.write(savePath+File.separator);
		
		
		deliveryPersonModel.setDeliveryPersonImageName(deliveryPersonImageName);
		deliveryPersonModel.setDeliveryPersonImagePath(savePath);
		int aid = Integer.parseInt(request.getParameter("deliveryPersonZone"));
		AreaModel areaModel = db.getAreaById(aid);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String deliveryDate = request.getParameter("deliveryPersonDOB");
		try {
			deliveryPersonModel.setDeliveryPersonDOB(simpleDateFormat.parse(deliveryDate));
			System.out.println("line 88 " + simpleDateFormat.parse(deliveryDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		db.saveDeliveryPerson(deliveryPersonModel);
		
		request.getRequestDispatcher("/view_demand.jsp").forward(request, response);
		
		
		
	}
	
	private String getImageFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
	}

}
