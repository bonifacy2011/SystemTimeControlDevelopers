<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<table style="margin-bottom: 10px">
		<tr>
			<td width="100px"><a href="welcome.do">Back To Main</a></td>
			<td width="150px"><a href="recording_elapsed_time.do">Back To
					Recording elapsed time</a></td>
		</tr>
	</table>

	<form action="recording_elapsed_time.do?action=save" method="post">
		<table cellspacing="25">
			<tr>
				<td width="180px">Recording hours:</td>
				<td width="100px"><input type="text" name="txtNumberOfHours" /></td>
			</tr>
			<tr>
				<td width="180px">Recording Responsible:</td>
				<td><select name="id" required>
						<option>Select responsible</option>
						<c:forEach items="${responsibleList}" var="responsib">

							<option value="<c:out value="${responsib.id}"/>"><c:out
									value="${responsib.name}" />
								<c:out value="${responsib.surname}" /></option>
						</c:forEach>


				</select></td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td colspan="2" align="right"><input type="submit" value="Save" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>