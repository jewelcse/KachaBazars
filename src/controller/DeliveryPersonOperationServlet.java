package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBData;
import dao.DeliveryDao;
import model.DeliveryPersonModel;
import model.OrderSellerProductModel;
import model.OrdersModel;

public class DeliveryPersonOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DeliveryDao dd = new DeliveryDao();
	DBData db = new DBData();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("inventoryorderview")) {

			int oid = Integer.parseInt(request.getParameter("oid"));

			OrdersModel ordersModel = db.getOrderById(oid);

			double amount = ordersModel.getOrderQuantity()
					* Double.parseDouble(ordersModel.getProductModel().getProductPrice());

			String paymentStatus = "";

			if (ordersModel.isPaymentStatus()) {
				request.setAttribute("payment", "done");
			} else {
				request.setAttribute("payment", "pending");
			}

			request.setAttribute("amount", amount);
			request.setAttribute("orderdetails", ordersModel);

			request.getRequestDispatcher("/dm-order-details.jsp").forward(request, response);
		} else if (action.equalsIgnoreCase("viewsellerorder")) {
			int soid = Integer.parseInt(request.getParameter("soid"));

			OrderSellerProductModel orderSellerProductModel = db.getOrderSellerProductById(soid);

			double amount = orderSellerProductModel.getOrderQuantity()
					* orderSellerProductModel.getSellersProduct().getProductPrice();

			String paymentStatus = "";

			if (orderSellerProductModel.isPaymentStatus()) {
				request.setAttribute("payment", "done");
			} else {
				request.setAttribute("payment", "pending");
			}

			request.setAttribute("amount", amount);
			request.setAttribute("orderdetails", orderSellerProductModel);

			request.getRequestDispatcher("/dm-seller-order-details.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("dlogin")) {

			String phone = request.getParameter("deliveryPersonPhone");
			String password = request.getParameter("deliveryPersonPassword");

			DeliveryPersonModel deliveryPersonModel = new DeliveryPersonModel();

			deliveryPersonModel = dd.getDeliveryPersonPasswordByPhone(phone);

			if (deliveryPersonModel == null) {
				request.setAttribute("message", "Account id Invalid...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/devilery-person-login.jsp").forward(request, response);
			} else if (phone.equals(deliveryPersonModel.getDeliveryPersonPhone())
					&& password.equals(deliveryPersonModel.getDeliveryPersonPassword())) {
				int did = deliveryPersonModel.getDeliveryPersonId();
				HttpSession session = request.getSession();
				session.setAttribute("message", "login");
				session.setAttribute("name", deliveryPersonModel.getDeliveryPersonFirstName());
				session.setAttribute("did", did);

				request.getRequestDispatcher("/delivery-person-homepage.jsp").forward(request, response);

			}

			else {
				request.setAttribute("message", "Account id or wrong password...");
				request.setAttribute("action", "login");
				request.getRequestDispatcher("/devilery-person-login.jsp").forward(request, response);
			}

		} else if (action.equalsIgnoreCase("update")) {

			int oid = Integer.parseInt(request.getParameter("oid"));

			OrdersModel ordersModel = db.getOrderById(oid);
			String orderStatus = request.getParameter("orderStatus");

			System.out.println(orderStatus);

			ordersModel.setOrderStatus(orderStatus);
			db.updateOrder(ordersModel);

			request.getRequestDispatcher("/delivery-person-homepage.jsp").forward(request, response);

		}
		else if (action.equalsIgnoreCase("updatesellerorder")) {
			int soid = Integer.parseInt(request.getParameter("soid"));

			OrderSellerProductModel orderSellerProductModel = db.getOrderSellerProductById(soid);
			String orderStatus = request.getParameter("orderStatus");

			System.out.println(orderStatus);

			orderSellerProductModel.setOrderStatus(orderStatus);
			db.updateOrderSellerProduct(orderSellerProductModel);

			request.getRequestDispatcher("/delivery-person-homepage.jsp").forward(request, response);
		}

	}

}
