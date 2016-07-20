<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SCTD - System Control Time Developers</title>
</head>

<body>
	<center>
		<h1>System Control Time Developers - Recording elapsed time page</h1>
	</center>

	<table>
		<tr>
			<td width="150px"><a href="welcome.do">Back To Main</a></td>
			<td width="450px"><a href="recording_elapsed_time.do?action=add">Add
					recording elapsed time</a></td>
		</tr>
	</table>

	<table  border="1">
		<tr>
			<th width="100px">Id</th>
			<th width="100px">Recording date</th>
			<th width="250px">Number of hours</th>
			<th width="250px">Name responsible </th>
			<th width="250px">Surname responsible </th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${recordingList}" var="record">
			<tr>
				<td align="center"><c:out value="${record.id}" /></td>
				<td align="center"><c:out value="${record.dateOfEntry}" /></td>
				<td align="center"><c:out value="${record.numberOfHours}" /></td>
				<td align="center"><c:out value="${record.responsibleName}" /></td>
				<td align="center"><c:out value="${record.responsibleSurname}" /></td>
				<td align="center"><a href="recording_elapsed_time.do?action=delete&id=${record.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>