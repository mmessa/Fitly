<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>
	
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreateweight"
		commandName="weight">
	<sf:input type="hidden" name="weightId" path="weightId"/>
		<table>
			<tr>
				<td class="label">Weight:</td>
				<td><sf:input class="control" path="weight" name="weight" 
						type="text" /><br /> <sf:errors path="weight" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Submit" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

</body>
</html>