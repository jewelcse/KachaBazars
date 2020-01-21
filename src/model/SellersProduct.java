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
@Table(name = "sellers_product")
public class SellersProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_quantity")
	private double productQuantity;
	
	@Column(name = "product_name")
	private String productName;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private CategoryModel categoryModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private SubcategoryModel subcategoryModel;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_image_path")
	private String productImagePath;
	
	@Column(name = "product_image_name")
	private String productImageName;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UnitModel unitModel;

	@ManyToOne(cascade = CascadeType.MERGE)
	private SellerModel sellerModel;
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public SubcategoryModel getSubcategoryModel() {
		return subcategoryModel;
	}

	public void setSubcategoryModel(SubcategoryModel subcategoryModel) {
		this.subcategoryModel = subcategoryModel;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public UnitModel getUnitModel() {
		return unitModel;
	}

	public void setUnitModel(UnitModel unitModel) {
		this.unitModel = unitModel;
	}

	public SellerModel getSellerModel() {
		return sellerModel;
	}

	public void setSellerModel(SellerModel sellerModel) {
		this.sellerModel = sellerModel;
	}


	
	
}
