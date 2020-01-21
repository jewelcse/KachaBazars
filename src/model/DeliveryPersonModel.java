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

import org.hibernate.annotations.Type;
@Entity
@Table(name = "delivery_person")
public class DeliveryPersonModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "delivery_person_id")
	private int deliveryPersonId;
	
	@Column(name = "delivery_person_first_name")
	private String deliveryPersonFirstName;
	
	@Column(name = "delivery_person_last_name")
	private String deliveryPersonLastName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private DivisionModel divisionmodel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private DistrictModel districtModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UpazillaModel upazillaModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UnionModel unionModel;
	
	@Column(name = "village")
	private String customerVillage;
	
	@Column(name = "street")
	private String customerStreet;
	
	@Column(name = "holding_number")
	private String customerHoldingNumber;
	
	@Column(name = "delivery_person_phone")
	private String deliveryPersonPhone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_person_dob")
	private Date deliveryPersonDOB;
	
	@Column(name = "delivery_person_image_path")
	private String deliveryPersonImagePath;
	
	@Column(name = "delivery_person_image_name")
	private String deliveryPersonImageName;
	
	@Column(name = "delivery_person_nid")
	private String deliveryPersonNID;
	
	@Column(name = "delivery_person_pass")
	private String deliveryPersonPassword;
	
	@Column(name = "delivery_Person_gender")
	private String deliveryPersonGender;
	
	
	public String getDeliveryPersonGender() {
		return deliveryPersonGender;
	}

	public void setDeliveryPersonGender(String deliveryPersonGender) {
		this.deliveryPersonGender = deliveryPersonGender;
	}

	public String getDeliveryPersonNID() {
		return deliveryPersonNID;
	}

	public void setDeliveryPersonNID(String deliveryPersonNID) {
		this.deliveryPersonNID = deliveryPersonNID;
	}

	public int getDeliveryPersonId() {
		return deliveryPersonId;
	}

	public void setDeliveryPersonId(int deliveryPersonId) {
		this.deliveryPersonId = deliveryPersonId;
	}

	public String getDeliveryPersonFirstName() {
		return deliveryPersonFirstName;
	}

	public void setDeliveryPersonFirstName(String deliveryPersonFirstName) {
		this.deliveryPersonFirstName = deliveryPersonFirstName;
	}

	public String getDeliveryPersonLastName() {
		return deliveryPersonLastName;
	}

	public void setDeliveryPersonLastName(String deliveryPersonLastName) {
		this.deliveryPersonLastName = deliveryPersonLastName;
	}

	

	public DivisionModel getDivisionmodel() {
		return divisionmodel;
	}

	public void setDivisionmodel(DivisionModel divisionmodel) {
		this.divisionmodel = divisionmodel;
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

	public String getCustomerVillage() {
		return customerVillage;
	}

	public void setCustomerVillage(String customerVillage) {
		this.customerVillage = customerVillage;
	}

	public String getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}

	public String getCustomerHoldingNumber() {
		return customerHoldingNumber;
	}

	public void setCustomerHoldingNumber(String customerHoldingNumber) {
		this.customerHoldingNumber = customerHoldingNumber;
	}

	public String getDeliveryPersonPhone() {
		return deliveryPersonPhone;
	}

	public void setDeliveryPersonPhone(String deliveryPersonPhone) {
		this.deliveryPersonPhone = deliveryPersonPhone;
	}

	

	public Date getDeliveryPersonDOB() {
		return deliveryPersonDOB;
	}

	public void setDeliveryPersonDOB(Date deliveryPersonDOB) {
		this.deliveryPersonDOB = deliveryPersonDOB;
	}

	public String getDeliveryPersonImagePath() {
		return deliveryPersonImagePath;
	}

	public void setDeliveryPersonImagePath(String deliveryPersonImagePath) {
		this.deliveryPersonImagePath = deliveryPersonImagePath;
	}

	public String getDeliveryPersonImageName() {
		return deliveryPersonImageName;
	}

	public void setDeliveryPersonImageName(String deliveryPersonImageName) {
		this.deliveryPersonImageName = deliveryPersonImageName;
	}

	public String getDeliveryPersonPassword() {
		return deliveryPersonPassword;
	}

	public void setDeliveryPersonPassword(String deliveryPersonPassword) {
		this.deliveryPersonPassword = deliveryPersonPassword;
	}
}
