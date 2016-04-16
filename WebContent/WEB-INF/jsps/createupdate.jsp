<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>
	
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
				<td><input class="control" value="Submit" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

<%@ include file="shared/footer.jspf" %>