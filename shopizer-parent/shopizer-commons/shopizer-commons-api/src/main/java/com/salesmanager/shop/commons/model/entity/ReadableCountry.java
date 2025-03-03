package com.salesmanager.shop.commons.model.entity;

import java.util.ArrayList;
import java.util.List;

public class ReadableCountry extends CountryEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private List<ReadableZone> zones = new ArrayList<ReadableZone>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReadableZone> getZones() {
		return zones;
	}

	public void setZones(List<ReadableZone> zones) {
		this.zones = zones;
	}

}
