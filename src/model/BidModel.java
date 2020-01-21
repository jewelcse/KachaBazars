package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bids")
public class BidModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid_id")
	private int bidId;
	
	@Column(name = "bid_quantity")
	private int bidQuantity;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private ProductModel productModel;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "bid_date")
	private Date date;
	
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getBidQuantity() {
		return bidQuantity;
	}
	public void setBidQuantity(int bidQuantity) {
		this.bidQuantity = bidQuantity;
	}
	public ProductModel getProductModel() {
		return productModel;
	}
	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
