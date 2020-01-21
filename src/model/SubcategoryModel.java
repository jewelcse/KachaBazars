package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubcategoryModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subcategory_id")
	private int subcategoryId;
	
	@Column(name = "subcategory_name")
	private String subcategoryName;
	
	@Column(name = "subcategory_description")
	private String subcategoryDescription;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CategoryModel categoryInformation;
	
	@Column(name = "govt_price")
	private String govtPrice;
	
	
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}
	public String getSubcategoryDescription() {
		return subcategoryDescription;
	}
	public void setSubcategoryDescription(String subcategoryDescription) {
		this.subcategoryDescription = subcategoryDescription;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public CategoryModel getCategoryInformation() {
		return categoryInformation;
	}
	public void setCategoryInformation(CategoryModel categoryInformation) {
		this.categoryInformation = categoryInformation;
	}
	public String getGovtPrice() {
		return govtPrice;
	}
	public void setGovtPrice(String govtPrice) {
		this.govtPrice = govtPrice;
	}
}
