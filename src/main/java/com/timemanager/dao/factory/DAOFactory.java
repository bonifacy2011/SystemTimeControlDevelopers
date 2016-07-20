package com.timemanager.dao.factory;

import com.timemanager.dao.RecordingElapsedTimeDAO;
import com.timemanager.dao.ResponsibleDAO;
import com.timemanager.dao.TaskDAO;

public abstract class DAOFactory {

	public abstract ResponsibleDAO getResponsibleDAO();

	public abstract RecordingElapsedTimeDAO getRecordingElapsedTimeDAO();

	public abstract TaskDAO getTaskDAO();

	public static DAOFactory getDAOFactory() {
		return new MySqlDAOFactory();
	}

}
