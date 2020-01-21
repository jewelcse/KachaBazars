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
@Table(name = "recommendation")
public class RecommendationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recommendationId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private ProductModel productModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private CustomerModel customerModel;

	@ManyToOne(cascade = CascadeType.MERGE)
	private SellerModel sellerModel;
	
	public int getRecommendationId() {
		return recommendationId;
	}

	public void setRecommendationId(int recommendationId) {
		this.recommendationId = recommendationId;
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

	public SellerModel getSellerModel() {
		return sellerModel;
	}

	public void setSellerModel(SellerModel sellerModel) {
		this.sellerModel = sellerModel;
	}
	
	
}
