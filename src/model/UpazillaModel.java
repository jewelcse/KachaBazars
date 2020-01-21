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
@Table(name = "upazilas")
public class UpazillaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int upazillaId;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private DistrictModel districtModel;
	
	@Column(name = "name")
	private String upazillaName;
	
	@Column(name = "bn_name")
	private String upazillaBangaName;

	public int getUpazillaId() {
		return upazillaId;
	}

	public void setUpazillaId(int upazillaId) {
		this.upazillaId = upazillaId;
	}

	public DistrictModel getDistrictModel() {
		return districtModel;
	}

	public void setDistrictModel(DistrictModel districtModel) {
		this.districtModel = districtModel;
	}

	public String getUpazillaName() {
		return upazillaName;
	}

	public void setUpazillaName(String upazillaName) {
		this.upazillaName = upazillaName;
	}

	public String getUpazillaBangaName() {
		return upazillaBangaName;
	}

	public void setUpazillaBangaName(String upazillaBangaName) {
		this.upazillaBangaName = upazillaBangaName;
	}
}
