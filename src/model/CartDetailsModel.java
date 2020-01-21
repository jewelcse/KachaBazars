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
@Table(name = "cart_details")
public class CartDetailsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_details_id")
	private  int cartDetailsId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CartModel cartId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private ProductModel productModel;
	
	@Column(name = "cart_product_quantity")
	private double cartProductQuantity;
	
	@Column(name = "cart_product_status")
	private String cartProductStatus;

	public int getCartDetailsId() {
		return cartDetailsId;
	}

	public void setCartDetailsId(int cartDetailsId) {
		this.cartDetailsId = cartDetailsId;
	}

	public CartModel getCartId() {
		return cartId;
	}

	public void setCartId(CartModel cartId) {
		this.cartId = cartId;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	

	public double getCartProductQuantity() {
		return cartProductQuantity;
	}

	public void setCartProductQuantity(double cartProductQuantity) {
		this.cartProductQuantity = cartProductQuantity;
	}

	public String getCartProductStatus() {
		return cartProductStatus;
	}

	public void setCartProductStatus(String cartProductStatus) {
		this.cartProductStatus = cartProductStatus;
	}
}
