package com.timemanager.entities;

public class BaseEntity {

	public static final String ID_COLUMN = "id";

	private Integer id;

	public BaseEntity() {
	}

	public BaseEntity(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
