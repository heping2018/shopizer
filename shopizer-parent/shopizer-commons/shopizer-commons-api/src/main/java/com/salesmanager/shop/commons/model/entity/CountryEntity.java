package com.salesmanager.shop.commons.model.entity;

public class CountryEntity extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private boolean supported;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isSupported() {
		return supported;
	}

	public void setSupported(boolean supported) {
		this.supported = supported;
	}

}
