package com.timemanager.entities;

import java.util.Date;

public class RecordingElapsedTime extends BaseEntity {

	public static final String TABLE_NAME = "recordingElapsedTime";
	public static final String DATE_OF_ENTRY_COLUMN = "dateOfEntry";
	public static final String NUMBER_OF_HOURS_COLUMN = "numberOfHours";
	public static final String RESPONSIBLE_ID_COLUMN = "responsible_id";

	private Date dateOfEntry;
	private Double numberOfHours;
	private String responsibleName;
	private String responsibleSurname;

	public RecordingElapsedTime() {
		super();
	}

	public RecordingElapsedTime(Integer id) {
		super(id);
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getResponsibleSurname() {
		return responsibleSurname;
	}

	public void setResponsibleSurname(String responsibleSurname) {
		this.responsibleSurname = responsibleSurname;
	}

	public Date getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public Double getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Double numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	@Override
	public String toString() {
		return "RecordingElapsedTime [dateOfEntry=" + dateOfEntry + ", numberOfHours=" + numberOfHours + ", responsibleName=" + responsibleName + ", responsibleSurname=" + responsibleSurname + "]";
	}

}
