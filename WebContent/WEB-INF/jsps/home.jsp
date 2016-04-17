<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>

<sec:authorize access="isAnonymous()">
	<body onload='document.f.username.focus();'>
	<c:if test="${param.error != null}">
		<p class="error">Login failed.</p>
	</c:if>
	
	<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</table>
	</form>
	<p><a href="<c:url value ="/newaccount"/>">Create new account</a></p>
</sec:authorize>


<%@ include file="shared/footer.jspf" %>
