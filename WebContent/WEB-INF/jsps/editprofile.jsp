<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<body onload='document.f.firstName.focus();'>
	<div class="container-fluid">
		<div class="formElements">
			<sf:form method="post"
				action="${pageContext.request.contextPath}/uploader?${_csrf.parameterName}=${_csrf.token}"
				encType="multipart/form-data">

				<input type="file" name="file" value="Select image ..." />

				<input type="submit" value="Start upload" />
			</sf:form>
			<sf:form name="f" method="post"
				action="${pageContext.request.contextPath}/updateprofile"
				commandName="profile">
				<sf:input type="hidden" name="userId" path="userId" />
				<table>
					<tr>
						<td class="fieldTitle">First Name:</td>
						<td><sf:input class="control fieldSpace" path="firstName"
								name="firstName" type="text" /><br /> <sf:errors
								path="firstName" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">Last Name:</td>
						<td><sf:input class="control fieldSpace" path="lastName"
								name="lastName" type="text" /><br /> <sf:errors
								path="lastName" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">Height (Feet):</td>
						<td><sf:input class="control fieldSpace" path="heightFeet"
								name="heightFeet" type="text" /><br /> <sf:errors
								path="heightFeet" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">Height (Inches):</td>
						<td><sf:input class="control fieldSpace" path="heightInches"
								name="heightInches" type="text" /><br /> <sf:errors
								path="heightInches" cssClass="error"></sf:errors></td>
					</tr>

					<tr>
						<td class="fieldTitle">City:</td>
						<td><sf:input class="control fieldSpace" path="city"
								name="city" type="text" /><br /> <sf:errors path="city"
								cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">State:</td>
						<td><sf:input class="control fieldSpace" path="state"
								name="state" type="text" /><br /> <sf:errors path="state"
								cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">Zip Code:</td>
						<td><sf:input class="control fieldSpace" path="zipCode"
								name="zipCode" type="text" /><br /> <sf:errors path="zipCode"
								cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">Gym:</td>
						<td><sf:input class="control fieldSpace" path="gym"
								name="gym" type="text" /><br /> <sf:errors path="gym"
								cssClass="error"></sf:errors></td>
					</tr>

					<tr>
						<td></td>
						<td><input class="control fieldSpace btn btn-info myButton"
							value="Update Profile" type="submit" /></td>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</tr>
				</table>

			</sf:form>
		</div>
	</div>
	<%@ include file="shared/footer.jspf"%>