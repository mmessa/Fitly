<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>

<body onload='document.f.name.focus();'>
<div class="container-fluid">
		<div class="formElements">
	<sf:form name = "f" method="post"
		action="${pageContext.request.contextPath}/docreatesupplement"
		commandName="supplement">
	<sf:input type="hidden" name="supplementId" path="supplementId"/>
		<table>
			<tr>
				<td class="fieldTitle">Name:</td>
				<td><sf:input class="control fieldSpace" path="name" name="name" 
						type="text" /><br /> <sf:errors path="name" cssClass="error"></sf:errors></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="control fieldSpace btn btn-info myButton" value="Submit" type="submit" /></td>
			</tr>
		</table>

	</sf:form>
</div>
</div>
<%@ include file="shared/footer.jspf" %>