<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>

<body onload='document.f.username.focus();'>
	
	<sf:form name="f" method="post"
		action="${pageContext.request.contextPath}/docreateweight"
		commandName="weight">
	<sf:input type="hidden" name="weightId" path="weightId"/>
		<table>
			<tr>
				<td>Weight:</td>
				<td><sf:input class="control" path="weight" name="weight" 
						type="text" /><br /> <sf:errors path="weight" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="control" value="Submit" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

<%@ include file="shared/footer.jspf" %>