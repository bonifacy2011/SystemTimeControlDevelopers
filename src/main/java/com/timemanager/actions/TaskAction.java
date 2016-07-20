package com.timemanager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timemanager.actions.constans.ActionTypes;
import com.timemanager.actions.constans.ViewPaths;
import com.timemanager.dao.RecordingElapsedTimeDAO;
import com.timemanager.dao.ResponsibleDAO;
import com.timemanager.dao.TaskDAO;
import com.timemanager.dao.factory.DAOFactory;
import com.timemanager.entities.RecordingElapsedTime;
import com.timemanager.entities.Responsible;
import com.timemanager.utils.RequestUtils;

public class TaskAction extends BaseAction {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TaskDAO dao = DAOFactory.getDAOFactory().getTaskDAO();
		ActionTypes type = getActionType(request);

		switch (type) {
		case LIST:
		case UNDEFINED: {
			loadAllResponsibles(request, response);
			loadAllRecordingElapsedTime(request, response);
			forwardToView(ViewPaths.RecordingElapsedTimeView, request, response);
			return;
		}
		case ADD: {
			loadAllResponsibles(request, response);
			forwardToView(ViewPaths.AddRecordingElapsedTimeView, request, response);
			return;
		}
		case SAVE: {
			Responsible responsible = buildResponsibleFromRequest(request);
			RecordingElapsedTime recordingElapsedTime = buildRecordngElapsedTimeFromRequest(request);

			// dao.insert(recordingElapsedTime, responsible);
			loadAllRecordingElapsedTime(request, response);
			forwardToView(ViewPaths.RecordingElapsedTimeView, request, response);
			return;
		}

		case DELETE: {
			RecordingElapsedTime recordingElapsedtime = findById(request);
			// dao.delete(recordingElapsedtime);
			loadAllResponsibles(request, response);
			loadAllRecordingElapsedTime(request, response);
			forwardToView(ViewPaths.RecordingElapsedTimeView, request, response);
			return;
		}
		}
	}

	private void loadAllResponsibles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponsibleDAO dao = DAOFactory.getDAOFactory().getResponsibleDAO();
		List<Responsible> responsibleList = dao.findAll();
		request.setAttribute("responsibleList", responsibleList);
	}

	private void loadAllRecordingElapsedTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecordingElapsedTimeDAO dao = DAOFactory.getDAOFactory().getRecordingElapsedTimeDAO();
		List<RecordingElapsedTime> recordingList = dao.findAll();
		request.setAttribute("recordingList", recordingList);
	}

	private RecordingElapsedTime buildRecordngElapsedTimeFromRequest(HttpServletRequest request) {
		RecordingElapsedTime recordingElapsedTime = new RecordingElapsedTime();
		recordingElapsedTime.setNumberOfHours(Double.parseDouble(RequestUtils.getParameter(request, "txtNumberOfHours")));
		return recordingElapsedTime;
	}

	private Responsible buildResponsibleFromRequest(HttpServletRequest request) {
		Responsible responsible = new Responsible();
		responsible.setId(Integer.parseInt(RequestUtils.getParameter(request, "id")));
		return responsible;
	}

	private RecordingElapsedTime findById(HttpServletRequest request) {
		RecordingElapsedTimeDAO dao = DAOFactory.getDAOFactory().getRecordingElapsedTimeDAO();
		RecordingElapsedTime recordingElapsedTime = dao.findById(Integer.parseInt(RequestUtils.getParameter(request, "id")));
		return recordingElapsedTime;
	}
}
