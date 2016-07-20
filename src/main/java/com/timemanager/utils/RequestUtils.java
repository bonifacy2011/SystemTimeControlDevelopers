package com.timemanager.utils;

import javax.servlet.http.HttpServletRequest;

public final class RequestUtils {

	private RequestUtils() {
		super();
	}

	public static String getParameter(HttpServletRequest request, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			throw new IllegalArgumentException();
		}

		String value = request.getParameter(paramName);
		if (value != null) {
			return value;
		}

		return StringUtils.EMPTY_STR;
	}

	public static boolean isParameterNotPresent(HttpServletRequest request, String paramName) {
		return !RequestUtils.isParameterPresent(request, paramName);
	}

	public static boolean isParameterPresent(HttpServletRequest request, String paramName) {
		if (StringUtils.isBlank(paramName)) {
			throw new IllegalArgumentException();
		}

		String value = request.getParameter(paramName);
		return (value != null);
	}
}
