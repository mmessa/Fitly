<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>
	
	<sf:form method="post"
		action="${pageContext.request.contextPath}/docreatebodyfat"
		commandName="bodyFat">
	<sf:input type="hidden" name="bodyFatId" path="bodyFatId"/>
		<table>
			<tr>
				<td class="label">Body Fat%:</td>
				<td><sf:input class="control" path="bodyFatPercentage" name="bodyFatPercentage" 
						type="text" /><br /> <sf:errors path="bodyFatPercentage" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Submit" type="submit" /></td>
				
			</tr>
		</table>

	</sf:form>

</body>
</html>