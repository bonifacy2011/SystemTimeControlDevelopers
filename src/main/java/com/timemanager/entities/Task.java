package com.timemanager.entities;

import java.util.ArrayList;
import java.util.List;

public class Task extends BaseEntity {

	public static final String TABLE_NAME = "task";
	public static final String NAME_COLUMN = "name";
	public static final String RESPONSIBLE_ID_COLUMN = "responsible_id";
	public static final String RECORDING_ELAPSED_TIME_ID_COLUMN = "recordingElapsedTime_id";

	private String name;
	private String responsiblePersonForTheTask;
	private List<RecordingElapsedTime> recordingElapsedTimeList = new ArrayList<>();

	public Task() {
		super();
	}

	public Task(Integer id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResponsiblePersonForTheTask() {
		return responsiblePersonForTheTask;
	}

	public void setResponsiblePersonForTheTask(String responsiblePersonForTheTask) {
		this.responsiblePersonForTheTask = responsiblePersonForTheTask;
	}

	public List<RecordingElapsedTime> getRecordingElapsedTimeList() {
		return recordingElapsedTimeList;
	}

	public void setRecordingElapsedTimeList(List<RecordingElapsedTime> recordingElapsedTimeList) {
		this.recordingElapsedTimeList = recordingElapsedTimeList;
	}

}
