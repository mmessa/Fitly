<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<body onload='document.f.weight.focus();'>
	<div class="container-fluid">
		<div class="formElements">
			<sf:form name="f" method="post"
				action="${pageContext.request.contextPath}/docreateweight"
				commandName="weight">
				<sf:input type="hidden" name="weightId" path="weightId" />
				<table>
					<tr>
						<td class="fieldTitle">Weight:</td>
						<td><sf:input class="control fieldSpace" path="weight" name="weight"
								type="text" /><br /> <sf:errors path="weight" cssClass="error"></sf:errors></td>
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