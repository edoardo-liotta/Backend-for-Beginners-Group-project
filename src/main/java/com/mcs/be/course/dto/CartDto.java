package com.mcs.be.course.dto;

import java.io.Serializable;
import java.util.List;

public class CartDto implements Serializable {

	private Long id;
	
	private List<CartEntryDto> entries;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartEntryDto> getEntries() {
		return entries;
	}

	public void setEntries(List<CartEntryDto> entries) {
		this.entries = entries;
	}
	
	
}
