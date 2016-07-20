package com.timemanager.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timemanager.actions.constans.ActionTypes;
import com.timemanager.actions.constans.ViewPaths;
import com.timemanager.dao.ResponsibleDAO;
import com.timemanager.dao.factory.DAOFactory;
import com.timemanager.entities.Responsible;
import com.timemanager.utils.RequestUtils;

public class ResponsiblesAction extends BaseAction {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResponsibleDAO dao = DAOFactory.getDAOFactory().getResponsibleDAO();
		ActionTypes type = getActionType(request);

		switch (type) {
		case LIST:
		case UNDEFINED: {
			loadAllResponsibles(request, response);
			forwardToView(ViewPaths.ResponsibleView, request, response);
			return;
		}
		case ADD: {
			forwardToView(ViewPaths.AddResponsibleView, request, response);
			return;
		}
		case SAVE: {
			Responsible responsible = buildResponsibleFromRequest(request);
			dao.insert(responsible);
			loadAllResponsibles(request, response);
			forwardToView(ViewPaths.ResponsibleView, request, response);
			return;
		}

		case DELETE: {
			Responsible responsible = findById(request);
			dao.delete(responsible);
			loadAllResponsibles(request, response);
			forwardToView(ViewPaths.ResponsibleView, request, response);
			return;
		}
		}
	}

	private void loadAllResponsibles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponsibleDAO dao = DAOFactory.getDAOFactory().getResponsibleDAO();
		List<Responsible> responsibleList = dao.findAll();
		request.setAttribute("responsibleList", responsibleList);
	}

	private Responsible buildResponsibleFromRequest(HttpServletRequest request) {
		Responsible responsible = new Responsible();
		responsible.setName(RequestUtils.getParameter(request, "txtName"));
		responsible.setSurname(RequestUtils.getParameter(request, "txtSurname"));
		return responsible;
	}

	private Responsible findById(HttpServletRequest request) {
		ResponsibleDAO dao = DAOFactory.getDAOFactory().getResponsibleDAO();
		Responsible responsible = dao.findById(Integer.parseInt(RequestUtils.getParameter(request, "id")));
		return responsible;
	}
}
