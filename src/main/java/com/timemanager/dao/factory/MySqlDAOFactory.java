package com.timemanager.dao.factory;

import com.timemanager.dao.RecordingElapsedTimeDAO;
import com.timemanager.dao.RecordingElapsedTimeDaoImpl;
import com.timemanager.dao.ResponsibleDAO;
import com.timemanager.dao.ResponsibleDaoImpl;
import com.timemanager.dao.TaskDAO;
import com.timemanager.dao.TaskDaoImpl;

public final class MySqlDAOFactory extends DAOFactory {

	MySqlDAOFactory() {
		super();
	}

	@Override
	public ResponsibleDAO getResponsibleDAO() {
		return new ResponsibleDaoImpl();
	}

	@Override
	public RecordingElapsedTimeDAO getRecordingElapsedTimeDAO() {
		return new RecordingElapsedTimeDaoImpl();
	}

	@Override
	public TaskDAO getTaskDAO() {
		return new TaskDaoImpl();
	}

}
