package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")


public class CategoryModel {
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "category_description")
	private String categoryDescription;
	
	@Column(name = "category_image_path")
	private String categoryImagePath;
	
	@Column(name = "category_image_name")
	private String categoryImageName;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public String getCategoryImagePath() {
		return categoryImagePath;
	}
	public void setCategoryImagePath(String categoryImagePath) {
		this.categoryImagePath = categoryImagePath;
	}
	public String getCategoryImageName() {
		return categoryImageName;
	}
	public void setCategoryImageName(String categoryImageName) {
		this.categoryImageName = categoryImageName;
	}
	
}
