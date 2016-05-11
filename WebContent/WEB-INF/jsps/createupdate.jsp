<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<body onload='document.f.notes.focus();'>
	<div class="container-fluid">
		<div class="formElements">
			<sf:form name="f" method="post"
				action="${pageContext.request.contextPath}/docreateupdate"
				commandName="update">
				<sf:input type="hidden" name="updateId" path="updateId" />
				<table>
					<tr>
						<td class="fieldTitle">Notes:</td>
						<td><sf:input class="control fieldSpace" path="notes" name="notes"
								type="text" /><br /> <sf:errors path="notes" cssClass="error"></sf:errors></td>
					</tr>

					<tr>
						<td></td>
						<td><input class="control btn btn-info myButton fieldSpace" value="Submit" type="submit" /></td>

					</tr>
				</table>

			</sf:form>
		</div>
	</div>
	<%@ include file="shared/footer.jspf"%>