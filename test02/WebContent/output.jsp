<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.test.dto.TestDto"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Data 출력</h1>
	<table border="1">
	<c:forEach var="dto" items="${list }">
		<tr>
			<th>NAME</th>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<th>AGE</th>
			<td>${dto.age}</td>
		</tr>
		<tr>
			<th>ADDR</th>
			<td>${dto.addr}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>