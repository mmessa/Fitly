<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fitly Profile</title>
</head>
<body>

<p>
<a href="<c:url value='/'/>">Home</a>
<a href="<c:url value='/profile'/>">Home</a>

</p>

<h2>Challenges</h2>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Picture URL<th>
			<th>Description</th>
			<th>Coins Given</th>
			<th>Experience Given</th>
			<th colspan="7"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${challenges}">
		<tr>
			<td>${row.name}</td>
			<td>${row.level}</td>
			<td>${row.pictureUrl}</td>
			<td>${row.description}</td>
			<td>${row.coinsGiven}</td>
			<td>${row.experienceGiven}</td>
			<td>
				<form action="docreateperformance" method="post">
  					<button type="submit" name="challengeId" value="${row.challengeId}" class="btn-link">Select Challenge</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>