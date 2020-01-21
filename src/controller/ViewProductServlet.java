package controller;

import java.io.IOException;
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
import model.CartModel;
import model.CustomerModel;
import model.ProductModel;
import model.SellersProduct;

public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	DBData db = new DBData();
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession();
		String action = request.getParameter("action");
		session = request.getSession();
		// System.out.println(action);

		if (action.equals("order")) {
			Integer pid = Integer.parseInt(request.getParameter("productid").toString());

			if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
			}

			ProductModel productModel = new ProductModel();
			productModel = db.getProductById(pid);

			request.setAttribute("product", productModel);
			request.setAttribute("action", "order");

			rd = request.getRequestDispatcher("/ViewProduct.jsp");
		} else if (action.equals("addtocart")) {
			// System.out.println("Add To cart");
			Integer pid = Integer.parseInt(request.getParameter("pid").toString());

			ProductModel productModel = new ProductModel();
			productModel = db.getProductById(pid);
			request.setAttribute("product", productModel);
			request.setAttribute("action", "addtocart");
			rd = request.getRequestDispatcher("/ViewProduct.jsp");
			System.out.println("new page");
		} else if (action.equals("sellerorder")) {
			Integer spid = Integer.parseInt(request.getParameter("productid").toString());

			if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
			}

			SellersProduct sellersProduct = new SellersProduct();
			sellersProduct = db.getSellerProductById(spid);

			request.setAttribute("product", sellersProduct);
			request.setAttribute("action", "sellerorder");

			rd = request.getRequestDispatcher("/ViewSellerProduct.jsp");

		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		session = request.getSession();

		String action = request.getParameter("action");

		int pid = Integer.parseInt(request.getParameter("pid"));

		System.out.println(action);
		if (action.equals("Add to Cart")) {

			if (session.getAttribute("cid") != null) {
				int cid = Integer.parseInt(session.getAttribute("cid").toString());
				request.setAttribute("cid", cid);
				CustomerModel customerModel = new CustomerModel();
				customerModel = db.getCustomerById(cid);

				String productQuantity = request.getParameter("productQuantity");

				
				CartModel cartModel = new CartModel();
				cartModel = db.getCartByCustomerId(cid);

				ProductModel productModel = new ProductModel();
				productModel = db.getProductById(pid);

				CartDetailsModel cartDetailsModel = new CartDetailsModel();

				String cartProductStatus = "Undecided";

				cartDetailsModel.setCartProductQuantity(Double.parseDouble(productQuantity));
				cartDetailsModel.setCartId(cartModel);
				cartDetailsModel.setCartProductStatus(cartProductStatus);
				cartDetailsModel.setProductModel(productModel);

				request.setAttribute("cid", cid);

				db.saveCartDetails(cartDetailsModel);

				List<ProductModel> productModels = db.getAllProducts();
				request.setAttribute("productList1", productModels);
				request.setAttribute("name", "Our Products");

				request.getRequestDispatcher("/explore.jsp").forward(request, response);
			}

			else {
				String url = request.getRequestURI();

				String page = "addtocart";

				String baseUrl = request.getContextPath() + "/customers?action=login&url=" + url + "&pid=" + pid
						+ "&page=" + page;

				response.sendRedirect(baseUrl);
			}

		} else if (action.equalsIgnoreCase("One Click Buy")) {
			
			if (session.getAttribute("cid") != null) { 
			String productQuantity = request.getParameter("productQuantity");
			ProductModel productModel = new DBData().getProductById(pid);

			
			request.setAttribute("qty", productQuantity);
			request.setAttribute("product", productModel);

			request.getRequestDispatcher("/Confirmation.jsp").forward(request, response);
			}
			else {
				String url = request.getRequestURI();

				String page = "addtocart";

				String baseUrl = request.getContextPath() + "/customers?action=login&url=" + url + "&pid=" + pid
						+ "&page=" + page;

				response.sendRedirect(baseUrl);
			}
		}else if (action.equalsIgnoreCase("Buy Product")) {
			if (session.getAttribute("cid") != null) { 
				String productQuantity = request.getParameter("productQuantity");
				SellersProduct productModel = db.getSellerProductById(pid);

				
				request.setAttribute("qty", productQuantity);
				request.setAttribute("product", productModel);

				System.out.println("here");
				
				request.getRequestDispatcher("/confirm_seller_product.jsp").forward(request, response);
				}
				else {
					String url = request.getRequestURI();

					String page = "addtocart";

					String baseUrl = request.getContextPath() + "/customers?action=login&url=" + url + "&pid=" + pid
							+ "&page=" + page;

					response.sendRedirect(baseUrl);
				}
		}
		

	}
}
