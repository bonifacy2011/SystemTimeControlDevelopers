package com.timemanager.dao;

import java.util.List;

import com.timemanager.entities.RecordingElapsedTime;
import com.timemanager.entities.Responsible;
import com.timemanager.entities.Task;
import com.timemanager.exeptions.DAOException;

public class TaskDaoImpl implements TaskDAO {

	public static final String SQL_FIND_ALL = "select t." + Task.ID_COLUMN + ", t. " + Task.NAME_COLUMN + ", r." + RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN + ", r1." + Responsible.NAME_COLUMN
			+ ", r1." + Responsible.SURNAME + "  FROM " + RecordingElapsedTime.TABLE_NAME + " r INNER JOIN " + Responsible.TABLE_NAME + " r1 on r." + RecordingElapsedTime.RESPONSIBLE_ID_COLUMN
			+ " = r1." + Responsible.ID_COLUMN + "";
	public static final String SQL_FIND_BY_ID = "select * from " + RecordingElapsedTime.TABLE_NAME + " where " + RecordingElapsedTime.ID_COLUMN + " = ?";
	public static final String SQL_INSERT = "insert into " + RecordingElapsedTime.TABLE_NAME + " (" + RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN + ", " + RecordingElapsedTime.RESPONSIBLE_ID_COLUMN
			+ ") values (?, ?)";
	public static final String SQL_UPDATE = "update " + RecordingElapsedTime.TABLE_NAME + " set " + RecordingElapsedTime.NUMBER_OF_HOURS_COLUMN + " where " + RecordingElapsedTime.ID_COLUMN + " = ?";
	public static final String SQL_DELETE = "delete from " + RecordingElapsedTime.TABLE_NAME + " where " + RecordingElapsedTime.ID_COLUMN + " = ?";

	@Override
	public List<Task> findAll() throws DAOException {

		return null;
	}

	@Override
	public Task findById(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Task task) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Task task) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Task task) throws DAOException {
		// TODO Auto-generated method stub

	}

}
