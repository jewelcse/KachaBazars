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
@Table(name = "unions")
public class UnionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int unionId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UpazillaModel upazillaModel;
	
	@Column(name = "name")
	private String unionName;
	
	@Column(name = "bn_name")
	private String unionBanglaName;
	
	@Column(name = "lat")
	private double unionLat;
	
	@Column(name = "lon")
	private double unionLon;

	public int getUnionId() {
		return unionId;
	}

	public void setUnionId(int unionId) {
		this.unionId = unionId;
	}

	public UpazillaModel getUpazillaModel() {
		return upazillaModel;
	}

	public void setUpazillaModel(UpazillaModel upazillaModel) {
		this.upazillaModel = upazillaModel;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getUnionBanglaName() {
		return unionBanglaName;
	}

	public void setUnionBanglaName(String unionBanglaName) {
		this.unionBanglaName = unionBanglaName;
	}

	public double getUnionLat() {
		return unionLat;
	}

	public void setUnionLat(double unionLat) {
		this.unionLat = unionLat;
	}

	public double getUnionLon() {
		return unionLon;
	}

	public void setUnionLon(double unionLon) {
		this.unionLon = unionLon;
	}
}
