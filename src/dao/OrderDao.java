package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.CustomerModel;
import model.DeliveryPersonModel;
import model.OrderSellerProductModel;
import model.OrdersModel;
import model.SellersProduct;

public class OrderDao {
	int counter=0;

	public ArrayList<OrdersModel> getNewOrdersForDeliveryManByDelId(int delId) {
		// TODO Auto-generated method stub
		
			String query = "from OrdersModel ordersModel";
			Connection con = new Connection();
			Session session = con.getSessionFactory().openSession();

			Query queryExecuteable = session.createQuery(query);
			List<OrdersModel> ordersModels=new ArrayList<>();
			ordersModels = queryExecuteable.list();

			java.util.Iterator<OrdersModel> it = ordersModels.iterator();

			List<OrdersModel> ordersModels2 = new ArrayList<OrdersModel>();
			
			while (it.hasNext()) {
				Object type = (Object) it.next();

				OrdersModel sub =  (OrdersModel) type;
				
				if (sub.getDeliveryPersonModel() != null) {
					if (sub.getDeliveryPersonModel().getDeliveryPersonId() == delId && sub.getOrderStatus().equalsIgnoreCase("allocated")) {
						ordersModels2.add(sub);
						
						System.out.println("Union Id = " + sub.getDeliveryPersonModel().getDeliveryPersonId());
					}
				}

			}
			

			session.flush();
			session.close();

			return (ArrayList<OrdersModel>) ordersModels2;
		//	return cartDetailsModels;
		}

	public DeliveryPersonModel getDeliveryPersonPasswordByPhone(String phone) {
		// TODO Auto-generated method stub
		String query = "from DeliveryPersonModel deliverer where deliverer.deliveryPersonPhone='"+phone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		DeliveryPersonModel deliveryPersonModel = null;
		try {
			deliveryPersonModel = (DeliveryPersonModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(deliveryPersonModel);
		session.flush();
		session.close();
		return deliveryPersonModel;
	}

	public OrdersModel getOrderByTransactionId(String tranId) {
		// TODO Auto-generated method stub
		String query = "from OrdersModel ordersModel where ordersModel.tranId = '" + tranId + "'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		OrdersModel ordersModels = new OrdersModel();
		ordersModels = (OrdersModel) queryExecuteable.list().get(0);
		
		session.flush();
		session.close();
		
		return ordersModels;
	}

	public List<OrdersModel> getCartOrderListByTransactionId(String tranId) {
		// TODO Auto-generated method stub
		String query = "from OrdersModel ordersModel where ordersModel.tranId = '" + tranId + "'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<OrdersModel> ordersModels = new ArrayList<OrdersModel>();
		ordersModels = queryExecuteable.list();
		
		session.flush();
		session.close();
		
		return ordersModels;
	}

	public OrderSellerProductModel getOrderSellerProductByTransactionId(String tranId) {
		// TODO Auto-generated method stub
		String query = "from OrderSellerProductModel ordersModel where ordersModel.tranId = '" + tranId + "'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		OrderSellerProductModel ordersModels = new OrderSellerProductModel();
		ordersModels = (OrderSellerProductModel) queryExecuteable.list().get(0);
		
		session.flush();
		session.close();
		
		return ordersModels;
	}
		
}
