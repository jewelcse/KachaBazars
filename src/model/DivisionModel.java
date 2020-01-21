package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "divisions")
public class DivisionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int divisionId;
	
	@Column(name = "name")
	private String divisionName;
	
	@Column(name = "bn_name")
	private String divisionBanglaName;

	public int getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(int divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getDivisionBanglaName() {
		return divisionBanglaName;
	}

	public void setDivisionBanglaName(String divisionBanglaName) {
		this.divisionBanglaName = divisionBanglaName;
	}
	
	
}
