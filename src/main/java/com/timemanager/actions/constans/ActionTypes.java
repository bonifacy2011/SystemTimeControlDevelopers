package com.timemanager.actions.constans;

public enum ActionTypes {

	LIST("list"),

	ADD("add"),

	SAVE("add"),

	UNDEFINED("undefined"),

	FIND_BY_ID("findById"),

	DELETE("delete");

	private String type;

	private ActionTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
