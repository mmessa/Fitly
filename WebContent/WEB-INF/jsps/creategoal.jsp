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
		action="${pageContext.request.contextPath}/docreategoal"
		commandName="goal">
	<sf:input type="hidden" name="goalId" path="goalId"/>
		<table>
			<tr>
				<td class="label">Goal:</td>
				<td><sf:input class="control" path="name" name="name" 
						type="text" /><br /> <sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label">Type:</td>
				<td><sf:input class="control" path="type" name="type" 
						type="text" /><br /> <sf:errors path="type" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label">Description:</td>
				<td><sf:input class="control" path="description" name="description" 
						type="text" /><br /> <sf:errors path="description" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label">Value:</td>
				<td><sf:input class="control" path="value" name="value" 
						type="text" /><br /> <sf:errors path="value" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="complete">Complete:</td>
				<td><sf:input class="control" path="complete" name="complete" 
						type="text" /><br /> <sf:errors path="complete" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Goal" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

</body>
</html>