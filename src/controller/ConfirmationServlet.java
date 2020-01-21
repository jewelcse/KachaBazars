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
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.DBData;
import model.CartDetailsModel;
import model.ProductModel;
import model.SellersProduct;

public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	DBData db = new DBData();
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession();

		String action = request.getParameter("action");

		if (action.equals("confirm")) {
			int pid = Integer.parseInt(request.getParameter("pid").toString());

			if (session.getAttribute("cid") == null) {
				String url = request.getRequestURI();

				String page = "confirm";

				String baseUrl = request.getContextPath() + "/customers?action=login&url=" + url + "&pid=" + pid
						+ "&page=" + page;

				response.sendRedirect(baseUrl);

			}

			else if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
				ProductModel productModel = new ProductModel();
				productModel = db.getProductById(pid);
				request.setAttribute("product", productModel);
				request.setAttribute("action", "buy");
				request.getRequestDispatcher("/Confirmation.jsp").forward(request, response);
			}

		} else if (action.equals("checkout")) {

			if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
				int cartId = Integer.parseInt(request.getParameter("cartId"));
				request.setAttribute("cartId", cartId);
				request.getRequestDispatcher("/cart_confirmation.jsp").forward(request, response);
			}
		} else if (action.equals("confirmsellerproduct")) {
			int pid = Integer.parseInt(request.getParameter("pid").toString());

			if (session.getAttribute("cid") == null) {
				String url = request.getRequestURI();

				String page = "confirmsellerproduct";

				String baseUrl = request.getContextPath() + "/customers?action=login&url=" + url + "&pid=" + pid
						+ "&page=" + page;

				response.sendRedirect(baseUrl);

			}

			else if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
				SellersProduct sellersProduct = new SellersProduct();
				sellersProduct = db.getSellerProductById(pid);
				request.setAttribute("product", sellersProduct);
				request.setAttribute("action", "buy");
				System.out.println("here");
				request.getRequestDispatcher("/confirm_seller_product.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
