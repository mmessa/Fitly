<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>
	
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreatesupplement"
		commandName="supplement">
	<sf:input type="hidden" name="supplementId" path="supplementId"/>
		<table>
			<tr>
				<td class="label">Name:</td>
				<td><sf:input class="control" path="name" name="name" 
						type="text" /><br /> <sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Submit" type="submit" /></td>
			</tr>
		</table>

	</sf:form>

</body>
</html>