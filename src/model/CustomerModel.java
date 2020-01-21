package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "customers")
public class CustomerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_first_name")
	private String customerFirstName;

	@Column(name = "customer_last_name")
	private String customerLastName;
	
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
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "customer_dob")
	private Date customerDOB;
	
	@Column(name = "customer_image_path")
	private String customerImagePath;
	
	@Column(name = "customer_image_name")
	private String customerImageName;
	
	@Column(name = "customer_password")
	private String customerPassword;
	
	@Column(name = "customer_zipcode")
	private String customerZipcode;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
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

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Date getCustomerDOB() {
		return customerDOB;
	}

	public void setCustomerDOB(Date customerDOB) {
		this.customerDOB = customerDOB;
	}

	public String getCustomerImagePath() {
		return customerImagePath;
	}

	public void setCustomerImagePath(String customerImagePath) {
		this.customerImagePath = customerImagePath;
	}

	public String getCustomerImageName() {
		return customerImageName;
	}

	public void setCustomerImageName(String customerImageName) {
		this.customerImageName = customerImageName;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerZipcode() {
		return customerZipcode;
	}

	public void setCustomerZipcode(String customerZipcode) {
		this.customerZipcode = customerZipcode;
	}
	
}
