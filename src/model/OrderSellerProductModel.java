package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_seller_product")
public class OrderSellerProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SellersProduct sellersProduct;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerModel customerModel;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private DeliveryPersonModel deliveryPersonModel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SellerModel sellerModel;


	@Column(name = "order_status")
	private String orderStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private DivisionModel divisionModel;

	@ManyToOne(cascade = CascadeType.ALL)
	private DistrictModel districtModel;

	@ManyToOne(cascade = CascadeType.ALL)
	private UpazillaModel upazillaModel;

	@ManyToOne(cascade = CascadeType.ALL)
	private UnionModel unionModel;
	
	@Column(name = "care_of_contact")
	private String careOfContact;
	
	@Column(name = "reciever_phone_number")
	private String phoneNumber;
	
	@Column(name = ("order_quantity"))
	private double orderQuantity;
	
	@Column(name = "order_village")
	private String orderVillage;
	
	@Column(name = "order_street")
	private String orderStreet;

	@Column(name = "order_zip_code")
	private String orderZipCode;
	
	@Column(name = "tran_id")
	private String tranId;
	
	@Column(name = "payment_status")
	private boolean paymentStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expected_delivery_date")
	private Date expectedDeliveryDate;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public SellersProduct getSellersProduct() {
		return sellersProduct;
	}

	public void setSellersProduct(SellersProduct sellersProduct) {
		this.sellersProduct = sellersProduct;
	}

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public DeliveryPersonModel getDeliveryPersonModel() {
		return deliveryPersonModel;
	}

	public void setDeliveryPersonModel(DeliveryPersonModel deliveryPersonModel) {
		this.deliveryPersonModel = deliveryPersonModel;
	}

	public SellerModel getSellerModel() {
		return sellerModel;
	}

	public void setSellerModel(SellerModel sellerModel) {
		this.sellerModel = sellerModel;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public DivisionModel getDivisionModel() {
		return divisionModel;
	}

	public void setDivisionModel(DivisionModel divisionModel) {
		this.divisionModel = divisionModel;
	}

	public DistrictModel getDistrictModel() {
		return districtModel;
	}

	public void setDistrictModel(DistrictModel districtModel) {
		this.districtModel = districtModel;
	}

	public UpazillaModel getUpazillaModel() {
		return upazillaModel;
	}

	public void setUpazillaModel(UpazillaModel upazillaModel) {
		this.upazillaModel = upazillaModel;
	}

	public UnionModel getUnionModel() {
		return unionModel;
	}

	public void setUnionModel(UnionModel unionModel) {
		this.unionModel = unionModel;
	}

	public String getCareOfContact() {
		return careOfContact;
	}

	public void setCareOfContact(String careOfContact) {
		this.careOfContact = careOfContact;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(double orderQuantity2) {
		this.orderQuantity = orderQuantity2;
	}

	public String getOrderVillage() {
		return orderVillage;
	}

	public void setOrderVillage(String orderVillage) {
		this.orderVillage = orderVillage;
	}

	public String getOrderStreet() {
		return orderStreet;
	}

	public void setOrderStreet(String orderStreet) {
		this.orderStreet = orderStreet;
	}

	public String getOrderZipCode() {
		return orderZipCode;
	}

	public void setOrderZipCode(String orderZipCode) {
		this.orderZipCode = orderZipCode;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
}
