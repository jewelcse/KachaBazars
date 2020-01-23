package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ietf.jgss.Oid;

import controller.OrderFromSeller;
import dao.Connection;
import javassist.bytecode.Descriptor.Iterator;
import model.AdminModel;
import model.AreaModel;
import model.BidModel;
import model.CartDetailsModel;
import model.CartModel;
import model.CategoryModel;
import model.CustomerModel;
import model.DeliveryPersonModel;
import model.DistrictModel;
import model.DivisionModel;
import model.OrderSellerProductModel;
import model.OrdersModel;
import model.ProductModel;
import model.RecommendationModel;
import model.SellerModel;
import model.SellersProduct;
import model.SubcategoryModel;
import model.UnitModel;
import model.UpazillaModel;

public class DBData {
	int counter=0;

	public void saveCategory(CategoryModel category) {

		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
		
		session.flush();
		session.close();
		
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}

	public CategoryModel getCategoryById(int id) {
		String query = "from CategoryModel category where category.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		CategoryModel categoryModel = (CategoryModel) queryExecuteable.list().get(0);
		
		con.closeSessionFactory();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return categoryModel;
	}

	public List<CategoryModel> getAllCategories() {
		List<CategoryModel> categoryModel = new ArrayList<>();
		String query = "from CategoryModel book";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from CategoryModel Category");
		categoryModel = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return categoryModel;
	}

	public List<CategoryModel> getAllCategoryModels() {
		List<CategoryModel> categoryModel = new ArrayList<>();

		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query query = session.createQuery("from CategoryModel category");
		System.out.println("line 56 dbdata  " + query);
		categoryModel = query.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return categoryModel;
	}

	public void updateCategory(CategoryModel category) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(category);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Updated...");
	}

	public void deleteCategory(CategoryModel categoryModel) {

		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(categoryModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Deleted...");
	}

	public void saveSubcategory(SubcategoryModel subcategory) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(subcategory);
		transaction.commit();
		session.flush();
		session.close();
		System.out.println("Inserted...");
		con.closeSessionFactory();
	}

	public List<SubcategoryModel> getAllSubcategories() {
		List<SubcategoryModel> subcategoryModel = new ArrayList<>();
		String query = "from SubategoryModel subcategory";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from SubcategoryModel Subcategory");
		subcategoryModel = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return subcategoryModel;
	}

	public SubcategoryModel getSubcategoryById(int id) {
		String query = "from SubcategoryModel subcategory where subcategory.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		SubcategoryModel subcategoryModel = (SubcategoryModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return subcategoryModel;
	}

	public void saveProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(productModel);
		
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}

	public List<ProductModel> getAllProducts() {
		List<ProductModel> productModels = new ArrayList<>();
		String query = "from ProductModel productModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from ProductModel productModels");
		productModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return productModels;
	}

	public ProductModel getProductById(int id) {
		String query = "from ProductModel product where product.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ProductModel productModel = (ProductModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return productModel;
	}

	public List<CustomerModel> getAllCustomers() {
		// TODO Auto-generated method stub
		List<CustomerModel> customerModels = new ArrayList<>();
		String query = "from CustomerModel customerModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from CustomerModel customerModels");
		customerModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customerModels;
	}

	public List<SellerModel> getAllSellers() {
		// TODO Auto-generated method stub
		List<SellerModel> sellerModels = new ArrayList<>();
		String query = "from SellerModel sellerModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from SellerModel sellerModels");
		sellerModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellerModels;
	}

	public List<DeliveryPersonModel> getAllDeliveryPersons() {
		// TODO Auto-generated method stub
		List<DeliveryPersonModel> deliveryPersonModels = new ArrayList<>();
		String query = "from DeliveryPersonModel deliveryPersonModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from DeliveryPersonModel deliveryPersonModels");
		deliveryPersonModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return deliveryPersonModels;
	}

	public List<AreaModel> getAllAreas() {
		// TODO Auto-generated method stub
		List<AreaModel> areaModels = new ArrayList<>();
		String query = "from AreaModel areaModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from AreaModel areaModels");
		areaModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return areaModels;
	}
	
	
	public void saveArea(AreaModel areaModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(areaModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}

	public List<OrdersModel> getAllOrders() {
		// TODO Auto-generated method stub
		List<OrdersModel> ordersModels = new ArrayList<>();
		String query = "from OrdersModel ordersModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from OrdersModel ordersModels");
		ordersModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return ordersModels;
	}

	public CustomerModel getCustomerById(int id) {
		
		/*
		String query = "from CustomerModel customer where customer.id=" + id;
		
		Session session = Connection.getSessionFactory().openSession();
		

		
		
		Query queryExecuteable = session.createQuery(query);
		CustomerModel customer = (CustomerModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		Connection.shutdown();
		return customer;
		
		*/
		
		String query = "from CustomerModel customer where customer.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		
		
		Query queryExecuteable = session.createQuery(query);
		CustomerModel customer = (CustomerModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customer;
		
		
	}

	public void saveOrder(OrdersModel ordersModel) {

		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(ordersModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}


	public void saveSeller(SellerModel sellerModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(sellerModel);
		transaction.commit();
		session.flush();
		session.close();
		System.out.println("Inserted...");
		con.closeSessionFactory();
	}

	public SellerModel getPasswordByPhone(String phone) {
		String query = "from SellerModel seller where seller.sellerPhone='"+phone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		SellerModel sellerModel = null;
		try {
			sellerModel = (SellerModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(sellerModel);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellerModel;
	}

	public CartModel getCartByCustomerId(int id) {
		// TODO Auto-generated method stub
		String query = "from CartModel cart where cart.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		System.out.println(id);
		
		Query queryExecuteable = session.createQuery(query);
		CartModel cart = (CartModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return cart;
	}

	public void saveCartDetails(CartDetailsModel cartDetailsModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(cartDetailsModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}

	public List<CartDetailsModel> getCartDetailsByCartId(int cartId) {
		// TODO Auto-generated method stub
		String query = "from CartDetailsModel cartDetailsModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<CartDetailsModel> cartDetailsModels=new ArrayList<>();
		cartDetailsModels = queryExecuteable.list();

		java.util.Iterator<CartDetailsModel> it = cartDetailsModels.iterator();

		List<CartDetailsModel> cartDetailsModels2 = new ArrayList<CartDetailsModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			CartDetailsModel sub =  (CartDetailsModel) type;
			if (sub.getCartId().getCartId() == cartId) {
				cartDetailsModels2.add(sub);
				
				System.out.println(cartDetailsModels);
			}

		}
		

		session.flush();
		session.close();
		con.closeSessionFactory();

		return cartDetailsModels2;
	//	return cartDetailsModels;
	}

	public void saveCustomer(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(customerModel);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public CustomerModel getCustomerPasswordByPhone(String customerPhone) {
		// TODO Auto-generated method stub
		String query = "from CustomerModel customer where customer.customerPhone='"+customerPhone+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		CustomerModel customerModel = null;
		try {
			customerModel = (CustomerModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(customerModel);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customerModel;
	}

	public void saveCart(CartModel cartModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(cartModel);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public List<OrdersModel> getDemandsByDate(String date) {
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
			String date1 = sub.getExpectedDeliveryDate().toString();
			if (date.equals(date1)) {
				ordersModels2.add(sub);
			}
		}
		session.flush();
		session.close();

		con.closeSessionFactory();
		return ordersModels2;
	}

	public OrdersModel getOrderById(int oid) {
		// TODO Auto-generated method stub
		String query = "from OrdersModel order where order.id=" + oid;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		System.out.println(oid);
		
		Query queryExecuteable = session.createQuery(query);
		OrdersModel ordersModel = (OrdersModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return ordersModel;
	}


	public void updateOrder(OrdersModel ordersModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(ordersModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Updated...");
	}

	public DeliveryPersonModel getDeliveryPersonById(int id) {
		// TODO Auto-generated method stub
		String query = "from DeliveryPersonModel deliveryPerson where deliveryPerson.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		DeliveryPersonModel deliveryPerson = (DeliveryPersonModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return deliveryPerson;
	}

	public SellerModel getSellerById(int id) {
		// TODO Auto-generated method stub
		String query = "from SellerModel seller where seller.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		SellerModel seller = (SellerModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return seller;
	}

	public AreaModel getAreaById(int id) {
		// TODO Auto-generated method stub
		String query = "from AreaModel area where area.id=" + id;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		AreaModel area = (AreaModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return area;
	}

	public void saveDeliveryPerson(DeliveryPersonModel deliveryPersonModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(deliveryPersonModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}

	public void updateProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(productModel);
		transaction.commit();
		System.out.println("Updated...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public List<ProductModel> getAllProductLimitedTo(int offSet, int recordPerPage) {
		List<ProductModel> productModels = new ArrayList<>();
		String query = "from ProductModel productModels";
		
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		queryExecuteable.setFirstResult(offSet);
		queryExecuteable.setMaxResults(recordPerPage);
		productModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return productModels;
	}

	public int getAllRecords() {
		String query = "from ProductModel productModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<OrdersModel> ordersModels=new ArrayList<>();
		ordersModels = queryExecuteable.list();

		java.util.Iterator<OrdersModel> it = ordersModels.iterator();
		List<OrdersModel> ordersModels2 = new ArrayList<OrdersModel>();
		
		while (it.hasNext()) {
			counter++;
		}
		session.flush();
		session.close();
		con.closeSessionFactory();
		return counter;
	}

	public void deleteCartDetailsByCartId(CartDetailsModel cartDetailsModel) {
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(cartDetailsModel);
		transaction.commit();
		System.out.println("Deleted...");
		session.flush();
		session.close();
		con.closeSessionFactory();

	}

	public void saveBid(BidModel bidModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(bidModel);
		transaction.commit();
		System.out.println("Inserted...");
		session.flush();
		session.close();
		con.closeSessionFactory();
	}

	public List<BidModel> getAllBids() {
		// TODO Auto-generated method stub
		List<BidModel> bidModels = new ArrayList<>();
		String query = "from BidModel bidModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from BidModel bidModels");
		bidModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return bidModels;
	}

	public void saveRecommendation(RecommendationModel recommendationModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(recommendationModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}


	public void deleteSubcategoryById(SubcategoryModel subcategoryModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.delete(subcategoryModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Deleted...");
	}
	
	public List<UnitModel> getAllUnits()
	{
		List<UnitModel> unitModels = new ArrayList<>();
		String query = "from UnitModel unitModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from UnitModel unitModels");
		unitModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return unitModels;
	}

	public UnitModel getUnitById(int uid) {
		// TODO Auto-generated method stub
		String query = "from UnitModel unit where unit.id=" + uid;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		UnitModel unit = (UnitModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return unit;
	}
	
	public List<DivisionModel> getAllDivision() {
		// TODO Auto-generated method stub
		List<DivisionModel> divisionModels = new ArrayList<>();
		String query = "from DivisionModel divisionModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from DivisionModel divisionModels");
		divisionModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return divisionModels;
	}

	public void saveSellerProduct(SellersProduct sellersProduct) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(sellersProduct);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}

	public List<SellersProduct> getProductByUnion(int unionId) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProducts";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		List<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getUnionModel().getUnionId() == unionId) {
				sellersProducts2.add(sub);
				
				System.out.println("Union Id = " + sub.getSellerModel().getUnionModel().getUnionId() + " and " + unionId);
			}

		}
		

		session.flush();
		session.close();
		
		con.closeSessionFactory();

		return sellersProducts2;
	//	return cartDetailsModels;
	}

	public List<SellersProduct> getProductByUpazilla(int upaId) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProducts";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		List<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getUpazillaModel().getUpazillaId() == upaId) {
				sellersProducts2.add(sub);
			}
		}

		session.flush();
		session.close();
		
		con.closeSessionFactory();
		
		return sellersProducts2;
	}

	public List<SellersProduct> getProductByDistrict(int disId) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProducts";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		List<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getDistrictModel().getDistrictId() == disId) {
				sellersProducts2.add(sub);
			}
		}
		
		session.flush();
		session.close();
		
		con.closeSessionFactory();

		return sellersProducts2;
	}

	public List<SellersProduct> getProductByDivision(int divId) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProducts";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		List<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		List<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getDivisionmodel().getDivisionId() == divId) {
				sellersProducts2.add(sub);
			}
		}
		
		session.flush();
		session.close();
		
		con.closeSessionFactory();

		return sellersProducts2;
	}

	public SellersProduct getSellerProductById(Integer spid) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct product where product.id=" + spid;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		SellersProduct sellersProduct = (SellersProduct) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		
		con.closeSessionFactory();
		
		return sellersProduct;
	}

	public void saveSellerProductOrder(OrderSellerProductModel ordersModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.save(ordersModel);
		transaction.commit();
		session.flush();
		session.close();
		
		con.closeSessionFactory();
		System.out.println("Inserted...");
	}
	
	public List<OrderSellerProductModel> getAllOrderFromSeller() {
		List<OrderSellerProductModel> orderSellerProductModels = new ArrayList<>();
		String query = "from OrderSellerProductModel orderSellerProductModels";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from OrderSellerProductModel orderSellerProductModels");
		orderSellerProductModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return orderSellerProductModels;
	}

	public OrderSellerProductModel getOrderSellerProductById(int soid) {
		// TODO Auto-generated method stub
		String query = "from OrderSellerProductModel orderSellerProductModel where orderSellerProductModel.id=" + soid;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		OrderSellerProductModel orderSellerProductModel = (OrderSellerProductModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		
		con.closeSessionFactory();
		return orderSellerProductModel;
	}

	public void updateOrderSellerProduct(OrderSellerProductModel orderSellerProductModel) {
		// TODO Auto-generated method stub
		Connection con = new Connection();

		Session session = con.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		session.update(orderSellerProductModel);
		transaction.commit();
		session.flush();
		session.close();
		con.closeSessionFactory();
		System.out.println("Updated...");
	}

	public List<SellersProduct> getAllSellerProductrs() {
		// TODO Auto-generated method stub
		List<SellersProduct> sellersProducts = new ArrayList<>();
		String query = "from SellersProduct sellersProducts";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from SellersProduct sellersProducts");
		sellersProducts = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellersProducts;
	}
	
	public ArrayList<SellersProduct> getAllSellerProductrsArraylist() {
		// TODO Auto-generated method stub
		ArrayList<SellersProduct> sellersProducts = new ArrayList<>();
		String query = "from SellersProduct sellersProducts";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from SellersProduct sellersProducts");
		sellersProducts = (ArrayList<SellersProduct>) queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellersProducts;
	}

	public ArrayList<CustomerModel> getCustomerPasswordByPhoneList(String phone, String pass) {
		// TODO Auto-generated method stub
	
		
		String query = "from CustomerModel customerModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<CustomerModel> customerModels=new ArrayList<>();
		customerModels = (ArrayList<CustomerModel>) queryExecuteable.list();

		java.util.Iterator<CustomerModel> it = customerModels.iterator();

		ArrayList<CustomerModel> customerModels2 = new ArrayList<CustomerModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			CustomerModel sub =  (CustomerModel) type;
				System.out.println("match");
				customerModels2.add(sub);
			
		}
		
		session.flush();
		session.close();

		con.closeSessionFactory();
		return customerModels2;
		
	}

	public ArrayList<ProductModel> getAllProductsArrayList() {
		// TODO Auto-generated method stub
		ArrayList<ProductModel> productModels = new ArrayList<>();
		String query = "from ProductModel product";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery("from ProductModel product");
		productModels = (ArrayList<ProductModel>) queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return productModels;
	}

	public ArrayList<SellersProduct> getSellerProductBySID(Integer sid) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProduct";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = (ArrayList<SellersProduct>) queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		ArrayList<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getSellerId() == sid) {
				sellersProducts2.add(sub);
				System.out.println("Found");
			}
			
			
		}
		
		session.flush();
		session.close();

		con.closeSessionFactory();
		return sellersProducts2;
	}

	public ArrayList<DistrictModel> getDistrictByDivisionId(int divId) {
		// TODO Auto-generated method stub
		String query = "from DistrictModel districtModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<DistrictModel> districtModels=new ArrayList<>();
		districtModels = (ArrayList<DistrictModel>) queryExecuteable.list();

		java.util.Iterator<DistrictModel> it = districtModels.iterator();

		ArrayList<DistrictModel> districtModels2 = new ArrayList<DistrictModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			DistrictModel sub =  (DistrictModel) type;
			if (sub.getDivisionModel().getDivisionId() == divId) {
				districtModels2.add(sub);
				System.out.println("Found");
			}
			
			
		}
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return districtModels2;
	}

	public ArrayList<UpazillaModel> getUpazillaByDistrictId(int disId) {
		// TODO Auto-generated method stub
		String query = "from UpazillaModel upazillaModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<UpazillaModel> upazillaModels=new ArrayList<>();
		upazillaModels = (ArrayList<UpazillaModel>) queryExecuteable.list();

		java.util.Iterator<UpazillaModel> it = upazillaModels.iterator();

		ArrayList<UpazillaModel> upazillaModels2 = new ArrayList<UpazillaModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			UpazillaModel sub =  (UpazillaModel) type;
			if (sub.getDistrictModel().getDistrictId() == disId) {
				upazillaModels2.add(sub);
				System.out.println("Found");
			}
			
			
		}
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return upazillaModels2;
	}

	public ArrayList<SellersProduct> getSellerProductByDivisionId(int divId) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProduct";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = (ArrayList<SellersProduct>) queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		ArrayList<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getDivisionmodel().getDivisionId() == divId) {
				sellersProducts2.add(sub);
				System.out.println("Found Product");
			}
			
			
		}
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellersProducts2;
	} 

	public ArrayList<SellersProduct> getSellerProductByUpazillaId(int upaId) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProduct";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = (ArrayList<SellersProduct>) queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		ArrayList<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getSellerModel().getUpazillaModel().getUpazillaId() == upaId) {
				sellersProducts2.add(sub);
				System.out.println("Found Product");
			}
			
			
		}
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellersProducts2;
	}

	public List<ProductModel> getProductByCategoryName(String action) {
		// TODO Auto-generated method stub
		String query = "from ProductModel productModel";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<ProductModel> productModels=new ArrayList<>();
		productModels = (ArrayList<ProductModel>) queryExecuteable.list();

		java.util.Iterator<ProductModel> it = productModels.iterator();

		ArrayList<ProductModel> productModels2 = new ArrayList<ProductModel>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			ProductModel sub =  (ProductModel) type;
			if (sub.getProductCategory().getCategoryName().equalsIgnoreCase(action)) {
				productModels2.add(sub);
				System.out.println("Found Product");
			}
			
			
		}
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return productModels2;
	}

	public List<SellersProduct> getSellerProductByCategoryName(String catName) {
		// TODO Auto-generated method stub
		String query = "from SellersProduct sellersProduct";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		Query queryExecuteable = session.createQuery(query);
		ArrayList<SellersProduct> sellersProducts=new ArrayList<>();
		sellersProducts = (ArrayList<SellersProduct>) queryExecuteable.list();

		java.util.Iterator<SellersProduct> it = sellersProducts.iterator();

		ArrayList<SellersProduct> sellersProducts2 = new ArrayList<SellersProduct>();
		
		while (it.hasNext()) {
			Object type = (Object) it.next();

			SellersProduct sub =  (SellersProduct) type;
			if (sub.getCategoryModel().getCategoryName().equalsIgnoreCase(catName)) {
				sellersProducts2.add(sub);
				System.out.println("Found Product");
			}
			
			
		}
		
		session.flush();
		session.close();
		con.closeSessionFactory();
		return sellersProducts2;
	}

	public AdminModel getAdminPasswordByName(String name) {
		// TODO Auto-generated method stub
		String query = "from AdminModel adminModel where adminModel.adminName='"+name+"'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		AdminModel adminModel = new AdminModel();
		try {
			adminModel = (AdminModel) queryExecuteable.list().get(0);
		} catch (Exception e) {
		System.out.println("Problem with login...");
		}
		//SignupModel signupModel = (SignupModel) queryExecuteable.list().get(0);
		System.out.println(adminModel);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return adminModel;
	}
	
	public List<ProductModel>  getFeaturedProducts()
	{
		
		String query = "from ProductModel product where product.type='Featured'";
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		List<ProductModel> productModels = new ArrayList<ProductModel>();		
		productModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return productModels;
	}

	public OrdersModel getOrderByTransId(String tranId) {
		// TODO Auto-generated method stub
		String query = "from OrdersModel order where order.tranId=" + tranId;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		OrdersModel ordersModel = (OrdersModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return ordersModel;
	}
	
	

	public CustomerModel getCustomerByphone(String phone) {
		// TODO Auto-generated method stub
		String query = "from CustomerModel order where order.customerPhone=" + phone;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		CustomerModel customerModel = (CustomerModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return customerModel;
	}

	public List<OrdersModel> getOrderlistByTranId(String tranId) {
		// TODO Auto-generated method stub
		String query = "from OrdersModel order where order.tranId=" + tranId;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();

		//Query queryExecuteable = session.createQuery(query);
		Query queryExecuteable = session.createQuery(query);
		List<OrdersModel> ordersModels = new ArrayList<OrdersModel>();		
		ordersModels = queryExecuteable.list();
		session.flush();
		session.close();
		con.closeSessionFactory();
		return ordersModels;
	}

	public OrderSellerProductModel getOrderSellerProductByTranId(String tranId) {
		// TODO Auto-generated method stub
		String query = "from OrderSellerProductModel order where order.tranId=" + tranId;
		Connection con = new Connection();
		Session session = con.getSessionFactory().openSession();
		
		Query queryExecuteable = session.createQuery(query);
		OrderSellerProductModel ordersModel = (OrderSellerProductModel) queryExecuteable.list().get(0);
		session.flush();
		session.close();
		con.closeSessionFactory();
		return ordersModel;
	}
}
