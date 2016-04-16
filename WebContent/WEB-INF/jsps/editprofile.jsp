<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>
	
	<sf:form method="post"
		action="${pageContext.request.contextPath}/updateprofile"
		commandName="profile">
	<sf:input type="hidden" name="userId" path="userId"/>
		<table>
			<tr>
				<td>First Name:</td>
				<td><sf:input class="control" path="firstName" name="firstName" 
						type="text" /><br /> <sf:errors path="firstName" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><sf:input class="control" path="lastName" name="lastName"
						type="text" /><br /> <sf:errors path="lastName" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>heightFeet:</td>
				<td><sf:input class="control" path="heightFeet" name="heightFeet"
						type="text" /><br /> <sf:errors path="heightFeet" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>heightInches:</td>
				<td><sf:input class="control" path="heightInches" name="heightInches"
						type="text" /><br /> <sf:errors path="heightInches" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td>city:</td>
				<td><sf:input class="control" path="city" name="city"
						type="text" /><br /> <sf:errors path="city" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>state:</td>
				<td><sf:input class="control" path="state" name="state"
						type="text" /><br /> <sf:errors path="state" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>zipCode:</td>
				<td><sf:input class="control" path="zipCode" name="zipCode"
						type="text" /><br /> <sf:errors path="zipCode" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td>gym:</td>
				<td><sf:input class="control" path="gym" name="gym"
						type="text" /><br /> <sf:errors path="gym" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="control" value="Update Profile" type="submit" /></td>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</tr>
		</table>

	</sf:form>

<%@ include file="shared/footer.jspf" %>