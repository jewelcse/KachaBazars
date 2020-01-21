package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class InventoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private int inventoryId;
	
	@Column(name = "inventory_product")
	private ProductModel productModel;
	
	@Column(name = "inventory_product_quantity")
	private double productQuantity;
	
	@Column(name = "inventory_area")
	private AreaModel areaModel;
	
	@Column(name = "inventory_seller")
	private SellerModel sellerModel;
	
}
