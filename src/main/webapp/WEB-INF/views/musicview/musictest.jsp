<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width=800 border="1">
		<tr align="center" height="30" bgcolor="pink">
			<td>넘버</td>
			<td>sname</td>
			<td>stitle</td>
			<td>downloadfile</td>
			<td>Image</td>
		</tr>
		<c:forEach var="row" items="${Banana}">
			<tr>
				<td>${row.snum}</td>
				<td>${row.sname}</td>
				<td>${row.stitle}</td>
				<td><a href="dnload?dnfile=${row.downloadfile}">${row.downloadfile}</a></td>
				<td><img src="${row.image}" width="70" height="70"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>