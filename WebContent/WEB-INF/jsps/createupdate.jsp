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
		action="${pageContext.request.contextPath}/docreateupdate"
		commandName="update">
	<sf:input type="hidden" name="updateId" path="updateId"/>
		<table>
			<tr>
				<td class="label">Notes:</td>
				<td><sf:input class="control" path="notes" name="notes" 
						type="text" /><br /> <sf:errors path="notes" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Update" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

</body>
</html>