package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBData;
import model.BidModel;
import model.ProductModel;


public class BidsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DBData db = new DBData();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action").toString();
		
		if (action.equals("bid")) {		
			BidModel bidModel = new BidModel();
			int pid = Integer.parseInt(request.getParameter("pid"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String bidDate = request.getParameter("date").toString();
			Date date;
			try {
				date = simpleDateFormat.parse(bidDate);
				bidModel.setDate(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
			ProductModel productModel = db.getProductById(pid);
			
			bidModel.setBidQuantity(quantity);
			bidModel.setProductModel(productModel);

			db.saveBid(bidModel);
			
			request.setAttribute("pid", pid);
			request.getRequestDispatcher("/view_demand.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
