<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<body onload='document.f.bodyFatPercentage.focus();'>
	<div class="container-fluid">
		<div class="formElements">
			<sf:form name="f" method="post"
				action="${pageContext.request.contextPath}/docreatebodyfat"
				commandName="bodyFat">
				<sf:input type="hidden" name="bodyFatId" path="bodyFatId" />
				<table>
					<tr>
						<td class="fieldTitle">Body Fat%:</td>
						<td><sf:input class="control fieldSpace" path="bodyFatPercentage"
								name="bodyFatPercentage" type="text" /><br /> <sf:errors
								path="bodyFatPercentage" cssClass="error"></sf:errors></td>
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