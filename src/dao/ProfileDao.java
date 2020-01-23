package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import model.CartDetailsModel;
import model.DistrictModel;
import model.DivisionModel;
import model.OrderSellerProductModel;
import model.OrdersModel;
import model.UnionModel;
import model.UpazillaModel;

public class ProfileDao {
	int counter=0;

	public List<OrdersModel> getOrdersByCID(int cid) {
		// TODO Auto-generated method stub
		String query = "from OrdersModel orderModel";
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
			if (sub.getCustomerModel().getCustomerId() == cid) {
				ordersModels2.add(sub);
				
				System.out.println(ordersModels);
			}

		}
		

		session.flush();
		session.close();
		con.closeSessionFactory();
		return ordersModels2;
	}

	public List<OrderSellerProductModel> getOrderSellerProducts(int cid) {
		// TODO Auto-generated method stub
		String query = "from OrderSellerProductModel orderSellerProductModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<OrderSellerProductModel> orderSellerProductModels=new ArrayList<>();
		orderSellerProductModels = queryExecuteable.list();

		java.util.Iterator<OrderSellerProductModel> it = orderSellerProductModels.iterator();

		List<OrderSellerProductModel> orderSellerProductModels2 = new ArrayList<OrderSellerProductModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			OrderSellerProductModel sub =  (OrderSellerProductModel) type;
			if (sub.getCustomerModel().getCustomerId() == cid) {
				orderSellerProductModels2.add(sub);
				
				System.out.println(orderSellerProductModels2);
			}

		}
		

		session.flush();
		session.close();
		con.closeSessionFactory();
		return orderSellerProductModels2;
	}		
}
