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
@Table(name = "area")

public class AreaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
	private int areaId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private DivisionModel divisionModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private DistrictModel districtModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UpazillaModel upazillaModel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private UnionModel unionModel;
	
	@Column(name = "village")
	private String village;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "holding_no")
	private String holdingNo;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public DivisionModel getDivisionModel() {
		return divisionModel;
	}

	public void setDivisionModel(DivisionModel divisionModel) {
		this.divisionModel = divisionModel;
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

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHoldingNo() {
		return holdingNo;
	}

	public void setHoldingNo(String holdingNo) {
		this.holdingNo = holdingNo;
	}
}
