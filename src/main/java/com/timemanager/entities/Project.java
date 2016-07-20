package com.timemanager.entities;

import java.util.List;

public class Project extends BaseEntity {

	public static final String TABLE_NAME = "project";
	public static final String NAME_COLUMN = "name";

	private String name;
	private String responsiblePersonForTheProject;
	private List<Task> task; // list

	public Project() {
		super();
	}

	public Project(Integer id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponsiblePersonForTheProject() {
		return responsiblePersonForTheProject;
	}

	public void setResponsiblePersonForTheProject(String responsiblePersonForTheProject) {
		this.responsiblePersonForTheProject = responsiblePersonForTheProject;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

}
