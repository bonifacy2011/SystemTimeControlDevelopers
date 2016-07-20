package com.timemanager.actions.constans;

public enum ViewPaths {

	WelcomeView("/WEB-INF/pages/welcome/welcome.jsp"),

	ResponsibleView("/WEB-INF/pages/responsible/responsibles.jsp"),

	RecordingElapsedTimeView("/WEB-INF/pages/recordElapsedTime/recording_elapsed_times.jsp"),

	AddRecordingElapsedTimeView("/WEB-INF/pages/recordElapsedTime/addRecordElapsedTime.jsp"),

	AddResponsibleView("/WEB-INF/pages/responsible/addResponsible.jsp"),

	TaskView("/WEB-INF/pages/task/task.jsp");

	private String path;

	private ViewPaths(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
