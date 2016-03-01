<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fitly Home</title>
</head>
<body>
Fitly Test 1, 2, 3

<sql:query var="rs" dataSource="jdbc/Fitly">
select userId, email, password from User
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    userId ${row.userId}<br/>
    email ${row.email}<br/>
    password ${row.password}<br/>
</c:forEach>


</body>
</html>