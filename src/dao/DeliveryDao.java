package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.CustomerModel;
import model.DeliveryPersonModel;
import model.OrderSellerProductModel;
import model.OrdersModel;

public class DeliveryDao {
	int counter=0;

	public DeliveryPersonModel getDeliveryPersonPasswordByPhone(String phone) {
		// TODO Auto-generated method stub
		String query = "from DeliveryPersonModel deliveryPersonModel where deliveryPersonModel.deliveryPersonPhone='"+phone+"'";
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
		con.closeSessionFactory();
		return deliveryPersonModel;
	}
	
	
	
	public ArrayList<OrdersModel> getOrdersByDeliveryPersonId(int delId) {
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
		con.closeSessionFactory();

		return (ArrayList<OrdersModel>) ordersModels2;
	//	return cartDetailsModels;
	}
	
	public ArrayList<OrderSellerProductModel> getSellerOrdersByDeliveryPersonId(int delId) {
		// TODO Auto-generated method stub
		
		String query = "from OrderSellerProductModel orderSellerProductModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<OrderSellerProductModel>orderSellerProductModels=new ArrayList<>();
		orderSellerProductModels = queryExecuteable.list();

		java.util.Iterator<OrderSellerProductModel> it = orderSellerProductModels.iterator();

		List<OrderSellerProductModel> orderSellerProductModels2 = new ArrayList<OrderSellerProductModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			OrderSellerProductModel sub =  (OrderSellerProductModel) type;
						
			if (sub.getDeliveryPersonModel() != null) {
				if (sub.getDeliveryPersonModel().getDeliveryPersonId() == delId && sub.getOrderStatus().equalsIgnoreCase("allocated")) {
					orderSellerProductModels2.add(sub);
					
					System.out.println("Delivery = " + sub.getDeliveryPersonModel().getDeliveryPersonId());
				}
			}

		}
		

		session.flush();
		session.close();

		con.closeSessionFactory();
		
		return (ArrayList<OrderSellerProductModel>) orderSellerProductModels2;
	//	return cartDetailsModels;
	}
	
}
