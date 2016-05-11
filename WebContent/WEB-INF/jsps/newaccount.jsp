<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>
<div class="container-fluid">
	<div class="formElements">
		<h3 class="fieldTitle">Create New Account</h3>
		<sf:form id="details" method="post"
			action="${pageContext.request.contextPath}/createaccount"
			commandName="user">

			<table class="formtable">
				<tr>
					<td class="fieldTitle">Username:</td>
					<td><sf:input class="control fieldSpace" path="username"
							name="username" type="text" /><br />
						<div class="error">
							<sf:errors path="username"></sf:errors>
						</div></td>
				</tr>
				<tr>
					<td class="fieldTitle">Email:</td>
					<td><sf:input class="control fieldSpace" path="email"
							name="email" type="text" /><br />
						<div class="error">
							<sf:errors path="email"></sf:errors>
						</div></td>
				</tr>
				<tr>
					<td class="fieldTitle">Password:</td>
					<td><sf:input id="password" class="control fieldSpace"
							path="password" name="password" type="password" /><br />
						<div class="error">
							<sf:errors path="password"></sf:errors>
						</div></td>
				</tr>
				<tr>
					<td class="fieldTitle">Confirm Password:</td>
					<td><input id="confirmpass" class="control fieldSpace"
						name="confirmpass" type="password" />
						<div id="matchpass"></div></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="control fieldSpace btn btn-info myButton"
						value="Create" type="submit" /></td>
				</tr>
			</table>

		</sf:form>
	</div>
</div>
<%@ include file="shared/footer.jspf"%>