package model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "orders")
public class OrdersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	

	@Column(name = "order_date")
	private String orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductModel productModel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerModel customerModel;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private DeliveryPersonModel deliveryPersonModel;

	@Column(name = "order_status")
	private String orderStatus;
		
	@Column(name = "care_of_contact")
	private String careOfContact;
	
	@Column(name = "reciever_phone_number")
	private String phoneNumber;
	
	@Column(name = ("order_quantity"))
	private double orderQuantity;
	
	@Column(name = "order_village")
	private String orderVillage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private DivisionModel divisionModel;

	@ManyToOne(cascade = CascadeType.ALL)
	private DistrictModel districtModel;

	@ManyToOne(cascade = CascadeType.ALL)
	private UpazillaModel upazillaModel;

	@ManyToOne(cascade = CascadeType.ALL)
	private UnionModel unionModel;
	
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
	
	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
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

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(double d) {
		this.orderQuantity = d;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
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
