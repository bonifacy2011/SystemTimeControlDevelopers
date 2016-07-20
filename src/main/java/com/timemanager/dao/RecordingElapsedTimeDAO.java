package com.timemanager.dao;

import java.util.List;

import com.timemanager.entities.RecordingElapsedTime;
import com.timemanager.entities.Responsible;
import com.timemanager.exeptions.DAOException;

public interface RecordingElapsedTimeDAO {

	public List<RecordingElapsedTime> findAll() throws DAOException;

	public RecordingElapsedTime findById(Integer id) throws DAOException;

	public void insert(RecordingElapsedTime recordingElapsedTime, Responsible responsible) throws DAOException;

	public void update(RecordingElapsedTime recordingElapsedTime) throws DAOException;

	public void delete(RecordingElapsedTime recordingElapsedTime) throws DAOException;
}