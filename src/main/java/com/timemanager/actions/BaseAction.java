package com.timemanager.actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timemanager.actions.constans.ActionTypes;
import com.timemanager.actions.constans.ViewPaths;
import com.timemanager.utils.RequestUtils;

public abstract class BaseAction extends HttpServlet {

	protected static final String ACTION_REQUEST_PARAM = "action";

	protected void forwardToView(ViewPaths viewPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath.getPath());
		dispatcher.forward(request, response);
	}

	protected ActionTypes getActionType(HttpServletRequest request) {
		try {
			String actionTypeStr = RequestUtils.getParameter(request, ACTION_REQUEST_PARAM).toUpperCase();
			return ActionTypes.valueOf(actionTypeStr);
		} catch (Exception e) {
			return ActionTypes.UNDEFINED;
		}
	}
}
