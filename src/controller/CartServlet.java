package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBData;
import model.CartDetailsModel;
import model.CartModel;


public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DBData db = new DBData();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		String action = request.getParameter("action");
		System.out.println(action);
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		if (action.equals("view")) {
			CartModel cartModel = new CartModel();
			cartModel = db.getCartByCustomerId(cid);
			double total = 0;
			int cartId = cartModel.getCartId();
			List<CartDetailsModel> cartDetailsModel = db.getCartDetailsByCartId(cartModel.getCartId());
			
			request.setAttribute("totalprice", total);
			request.setAttribute("cartDetails", cartDetailsModel);
			request.setAttribute("cid", cid);
			request.setAttribute("cartId", cartId);
			request.setAttribute("action", "view");
			
			rd = request.getRequestDispatcher("/Cart.jsp");
		}
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
