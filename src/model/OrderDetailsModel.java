package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetailsModel {
	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_details_id")
	private int orderDetailsId;
	
	@Column(name = "care_of_contact")
	private String careOfContact;
	
	@Column(name = "reciever_phone_number")
	private String phoneNumber;
	
	@Column(name = ("order_quantity"))
	private int orderQuantity;
	
	@Column(name = "order_village")
	private String orderVillage;
	
	@Column(name = "order_district")
	private String orderDistrict;
	
	@Column(name = "order_upazilla")
	private String orderUpazilla;
	
	@Column(name = "order_street")
	private String orderStreet;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private OrdersModel orderModel;
	
	@Column(name = "order_zip_code")
	private String orderZipCode;

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
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

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderVillage() {
		return orderVillage;
	}

	public void setOrderVillage(String orderVillage) {
		this.orderVillage = orderVillage;
	}

	public String getOrderDistrict() {
		return orderDistrict;
	}

	public void setOrderDistrict(String orderDistrict) {
		this.orderDistrict = orderDistrict;
	}

	public String getOrderUpazilla() {
		return orderUpazilla;
	}

	public void setOrderUpazilla(String orderUpazilla) {
		this.orderUpazilla = orderUpazilla;
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
	
	public OrdersModel getOrderModel() {
		return orderModel;
	}

	public void setOrderModel(OrdersModel orderModel) {
		this.orderModel = orderModel;
	}
}
