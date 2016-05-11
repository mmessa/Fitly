<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>
<!--
	<h1>Fitly Home</h1>

	<sec:authorize access="isAnonymous()">
		<body onload='document.f.username.focus();'>
			<c:if test="${param.error != null}">
				<p class="error">Login failed.</p>
			</c:if>
			<div class="loginForm">

				<form name='f' action='${pageContext.request.contextPath}/login'
					method='POST'>
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
							<td colspan='2'><input name="submit" type="submit"
								value="Login" /></td>
						</tr>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</table>
				</form>



				<p>
					<a href="<c:url value ="/newaccount"/>">Create new account</a>
				</p>
			</div>
	</sec:authorize>
	-->
<div class="svg">
<img src="<c:url value='/static/images/static/home_page.jpg'/>" width="100%">
</div>


<%@ include file="shared/footer.jspf"%>
