<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>

<body onload='document.f.name.focus();'>	

	<sf:form name ="f" method="post"
		action="${pageContext.request.contextPath}/docreategoal"
		commandName="goal">
	<sf:input type="hidden" name="goalId" path="goalId"/>
		<table>
			<tr>
				<td>Goal:</td>
				<td><sf:input class="control" path="name" name="name" 
						type="text" /><br /> <sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td>Type:</td>
				<td><sf:input class="control" path="type" name="type" 
						type="text" /><br /> <sf:errors path="type" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td>Description:</td>
				<td><sf:input class="control" path="description" name="description" 
						type="text" /><br /> <sf:errors path="description" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td>Value:</td>
				<td><sf:input class="control" path="value" name="value" 
						type="text" /><br /> <sf:errors path="value" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td>Complete:</td>
				<td><sf:input class="control" path="complete" name="complete" 
						type="text" /><br /> <sf:errors path="complete" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="control" value="Submit" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

<%@ include file="shared/footer.jspf" %>