<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<body onload='document.f.firstName.focus();'>
	<div class="container-fluid">
		<div class="formElements">
			<sf:form name="f" method="post"
				action="${pageContext.request.contextPath}/updateprofile"
				commandName="profile">
				<sf:input type="hidden" name="userId" path="userId" />
				<table>
					<tr>
						<td>First Name:</td>
						<td><sf:input class="control fieldSpace" path="firstName"
								name="firstName" type="text" /><br /> <sf:errors
								path="firstName" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><sf:input class="control fieldSpace" path="lastName"
								name="lastName" type="text" /><br /> <sf:errors
								path="lastName" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldSpace">Height (Feet):</td>
						<td class="fieldSpace"><sf:input class="control fieldSpace"
								path="heightFeet" name="heightFeet" type="text" /><br /> <sf:errors
								path="heightFeet" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldSpace">Height (Inches):</td>
						<td class="fieldSpace"><sf:input class="control fieldSpace"
								path="heightInches" name="heightInches" type="text" /><br /> <sf:errors
								path="heightInches" cssClass="error"></sf:errors></td>
					</tr>

					<tr>
						<td class="fieldSpace">City:</td>
						<td class="fieldSpace"><sf:input class="control fieldSpace"
								path="city" name="city" type="text" /><br /> <sf:errors
								path="city" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldSpace">State:</td>
						<td class="fieldSpace"><sf:input class="control fieldSpace"
								path="state" name="state" type="text" /><br /> <sf:errors
								path="state" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldSpace">Zip Code:</td>
						<td class="fieldSpace"><sf:input class="control fieldSpace"
								path="zipCode" name="zipCode" type="text" /><br /> <sf:errors
								path="zipCode" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldSpace">Gym:</td>
						<td class="fieldSpace"><sf:input class="control fieldSpace"
								path="gym" name="gym" type="text" /><br /> <sf:errors
								path="gym" cssClass="error"></sf:errors></td>
					</tr>

					<tr>
						<td></td>
						<td><input class="control fieldSpace" value="Update Profile"
							type="submit" /></td>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</tr>
				</table>

			</sf:form>
		</div>
	</div>
	<%@ include file="shared/footer.jspf"%>