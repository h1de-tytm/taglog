package com.taglog.beauty;

import javax.validation.constraints.NotNull;

public class BeautyCategory {
	private Long categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private Long displayNum;
	
	public BeautyCategory() {};
	
	public BeautyCategory(String categoryName, Long displayNum) {
		this(null, categoryName, displayNum);
	}
	
	public BeautyCategory(Long categoryId, String categoryName, Long displayNum) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.displayNum = displayNum;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getDisplayNum() {
		return displayNum;
	}

	public void setDisplayNum(Long displayNum) {
		this.displayNum = displayNum;
	}
	
	

}
