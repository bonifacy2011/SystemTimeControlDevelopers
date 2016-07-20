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
		<h1>System Control Time Developers - Responsibles page</h1>
	</center>

	<table>
		<tr>
			<td width="150px"><a href="welcome.do">Back To Main</a></td>
			<td width="450px"><a href="responsibles.do?action=add">Add
					Responsibles</a></td>
		</tr>
	</table>

	<table border="1px">
		<tr>
			<th width="100px">Id</th>
			<th width="100px">Responsible Name</th>
			<th width="250px">Responsible Surname</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${responsibleList}" var="responsib">
			<tr>
				<td align="center"><c:out value="${responsib.id}" /></td>
				<td align="center"><c:out value="${responsib.name}" /></td>
				<td align="center"><c:out value="${responsib.surname}" /></td>
				<td align="center"><a href="responsibles.do?action=delete&id=${responsib.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>