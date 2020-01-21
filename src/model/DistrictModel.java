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
@Table(name = "districts")
public class DistrictModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int districtId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private  DivisionModel divisionModel;
	
	@Column(name = "name")
	private String districtName;
	
	@Column(name = "bn_name")
	private String districtBanglaName;
	
	@Column(name = "lat")
	private double lat;
	
	@Column(name = "lon")
	private double lon;
	
	@Column(name = "website")
	private String website;

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	

	public DivisionModel getDivisionModel() {
		return divisionModel;
	}

	public void setDivisionModel(DivisionModel divisionModel) {
		this.divisionModel = divisionModel;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictBanglaName() {
		return districtBanglaName;
	}

	public void setDistrictBanglaName(String districtBanglaName) {
		this.districtBanglaName = districtBanglaName;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
