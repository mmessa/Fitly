<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>



<body onload='document.f.username.focus();'>
<div class="container-fluid">
	<h3 class="fieldTitle">Login with Username and Password</h3>
	
	<c:if test="${param.error != null}">
	
	<p class="error">Login failed.</p>
	
	</c:if>
	<div class="formElements">
	<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
		<table>
			<tr>
				<td class="fieldTitle">Username:</td>
				<td><input class="fieldSpace" type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td class="fieldTitle">Password:</td>
				<td><input class="fieldSpace" type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input class="btn btn-info myButton loginButton" name="submit" type="submit" value="Login" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</table>
	</form>
	
	<p><a href="<c:url value ="/newaccount"/>" class="btn btn-info myButton">Create new account</a></p>
	</div>
</div>
<%@ include file="shared/footer.jspf" %>