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
		<h1>System Control Time Developers - Responsible page</h1>
	</center>

	<table style="margin-bottom: 10px">
		<tr>
			<td width="100px"><a href="welcome.do">Back To Main</a></td>
			<td width="150px"><a href="responsibles.do">Back To
					Responsibles</a></td>
		</tr>
	</table>

	<form action="responsibles.do?action=save" method="post">

		<table cellspacing="25">
			<tr>
				<td width="180px">Responsible Name:</td>
				<td width="100px"><input type="text" name="txtName" /></td>
			</tr>
			<tr>
				<td width="180px">Responsible Surname:</td>
				<td width="100px"><input type="text" name="txtSurname"/></td>
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