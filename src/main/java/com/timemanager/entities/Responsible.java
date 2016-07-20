package com.timemanager.entities;

import java.util.HashSet;
import java.util.Set;

public class Responsible extends BaseEntity {

	public static final String TABLE_NAME = "responsible";
	public static final String NAME_COLUMN = "name";
	public static final String SURNAME = "surname";

	private String name;
	private String surname;
	private Set<RecordingElapsedTime> recordingElapsedTimes = new HashSet<RecordingElapsedTime>();

	public Responsible() {
		super();
	}

	public Responsible(Integer id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<RecordingElapsedTime> getRecordingElapsedTimes() {
		return recordingElapsedTimes;
	}

	public void setRecordingElapsedTimes(Set<RecordingElapsedTime> recordingElapsedTimes) {
		this.recordingElapsedTimes = recordingElapsedTimes;
	}

	@Override
	public String toString() {
		return "Responsible [name=" + name + ", surname=" + surname + "]";
	}
}
