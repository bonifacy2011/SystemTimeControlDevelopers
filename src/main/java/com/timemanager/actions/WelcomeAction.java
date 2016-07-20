package com.timemanager.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timemanager.actions.constans.ViewPaths;

public class WelcomeAction extends BaseAction {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forwardToView(ViewPaths.WelcomeView, request, response);
	}
}
