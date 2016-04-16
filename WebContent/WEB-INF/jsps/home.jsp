<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>

<p>
<h1>Fitly Test 1, 2, 3</h1>


<c:forEach var="row" items="${users}">
	username: ${row.username}<br/>
    email: ${row.email}<br/>
    password: ${row.password}<br/>
    <br>
</c:forEach>


<a href="${pageContext.request.contextPath}/profile">Go To Profile Page</a>
<br><br>

<a href="<c:url value='/challenges'/>">Challenges</a>
<p>
<a href="<c:url value='/editprofile'/>">Edit Profile</a>
</p>

<p>
<a href="<c:url value='/login'/>">Login</a>
</p>

<p>
<a href="<c:url value='/loggedout'/>">Logout</a>
</p>

<%@ include file="shared/footer.jspf" %>
