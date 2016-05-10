<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<body onload='document.f.name.focus();'>
	<div class="container-fluid">
		<div class="formElements">
			<sf:form name="f" method="post"
				action="${pageContext.request.contextPath}/docreategoal"
				commandName="goal">
				<sf:input type="hidden" name="goalId" path="goalId" />
				<table>
					<tr>
						<td class="fieldTitle">Goal:</td>
						<td><sf:input class="control fieldSpace" path="name"
								name="name" type="text" /><br /> <sf:errors path="name"
								cssClass="error"></sf:errors></td>
					</tr>



					<tr>
						<td class="fieldTitle">Description:</td>
						<td><sf:input class="control fieldSpace" path="description"
								name="description" type="text" /><br /> <sf:errors
								path="description" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td class="fieldTitle">Complete:</td>
						<td><sf:input class="control fieldSpace" path="complete" name="complete"
								type="text" /><br /> <sf:errors path="complete"
								cssClass="error"></sf:errors></td>
					</tr>
					<tr>

						<td><sf:input class="control" path="type" name="type"
								type="hidden" /><br /> <sf:errors path="type" cssClass="error"></sf:errors></td>
					</tr>
					<tr>
						<td><sf:input class="control" path="value" name="value"
								type="hidden" /><br /> <sf:errors path="value"
								cssClass="error"></sf:errors></td>
					</tr>



					<tr>
						<td></td>
						<td><input
							class="control fieldSpace btn btn-info myButton goalButton"
							value="Submit" type="submit" /></td>

					</tr>
				</table>

			</sf:form>
		</div>
	</div>
	<%@ include file="shared/footer.jspf"%>