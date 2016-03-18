<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<sf:form method="post"
		action="${pageContext.request.contextPath}/updateprofile"
		commandName="profile">
	<sf:input type="hidden" name="userId" path="userId"/>
		<table>
			<tr>
				<td class="label">First Name:</td>
				<td><sf:input class="control" path="firstName" name="firstName" 
						type="text" /><br /> <sf:errors path="firstName" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">Last Name:</td>
				<td><sf:input class="control" path="lastName" name="lastName"
						type="text" /><br /> <sf:errors path="lastName" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">heightFeet:</td>
				<td><sf:input class="control" path="heightFeet" name="heightFeet"
						type="text" /><br /> <sf:errors path="heightFeet" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">heightInches:</td>
				<td><sf:input class="control" path="heightInches" name="heightInches"
						type="text" /><br /> <sf:errors path="heightInches" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label">city:</td>
				<td><sf:input class="control" path="city" name="city"
						type="text" /><br /> <sf:errors path="city" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">state:</td>
				<td><sf:input class="control" path="state" name="state"
						type="text" /><br /> <sf:errors path="state" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">zipCode:</td>
				<td><sf:input class="control" path="zipCode" name="zipCode"
						type="text" /><br /> <sf:errors path="zipCode" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<td class="label">gym:</td>
				<td><sf:input class="control" path="gym" name="gym"
						type="text" /><br /> <sf:errors path="gym" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Update Profile" type="submit" /></td>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</tr>
		</table>

	</sf:form>

</body>
</html>