<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SCTD - System Control Time Developers</title>
</head>

<body>
	<center>
		<h1>Welcome to System Control Time Developers v1.0</h1>
		<h3>Select Action from below menu</h3>

		<ul>
			<li><a href="report_1.do">Report 1</a></li>
			<li><a href="report_2.do">Report 2</a></li>
		</ul>
	</center>


	<table border="1px" >
		<tr>
			<th width="150px">Id</th>
			<th width="150px">Название</th>
			<th width="150px"><a href="responsibles.do">Responsible</th>
			<th width="150px"><a href="taskServ.do?${sortedNameColumn}=name">
					Задачи </a></th>
			<p>
				<a href="insert.do">Добавить проект</a>
				<a href="recording_elapsed_time.do">Добавить время выполнения задачи</a>
			</p>
		</tr>
	</table>
	
	
<!-- 	<section class="map"> -->
<!-- 		<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3153.0478018295726!2d-122.4014323!3d37.78891949999999!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x80858088282e0d53%3A0x75ff4c9eda6b14d7!2zNjA3IE1hcmtldCBTdCwgU2FuIEZyYW5jaXNjbywgQ0EgOTQxMDUsINCh0KjQkA!5e0!3m2!1sru!2s!4v1420624075024" width="100%" height="440" frameborder="0" style="border:0" frameborder="0" scrolling="no"></iframe> -->

<!-- 	</section> -->
</body>
</html>