<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fitly Home</title>
</head>
<body>
<p>
<h1>Fitly Test 1, 2, 3</h1>

<c:forEach var="row" items="${users}">
	username: ${row.username}<br/>
    email: ${row.email}<br/>
    password: ${row.password}<br/>
    <br>
</c:forEach>


<a href="${pageContext.request.contextPath}/profile">Go To Profile Page</a>

<p>
<a href="<c:url value='/createprofile'/>">Create Profile</a>
</p>

<p>
<a href="<c:url value='/login'/>">Login</a>
</p>

<p>
<a href="<c:url value='/loggedout'/>">Logout</a>
</p>

</body>
</html>