<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>


<h2>Challenges</h2>
<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Picture URL<th>
			<th>Description</th>
			<th>Coins Given</th>
			<th>Experience Given</th>
			<th colspan="7"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${challenges}">
		<tr>
			<td>${row.name}</td>
			<td>${row.level}</td>
			<td>${row.pictureUrl}</td>
			<td>${row.description}</td>
			<td>${row.coinsGiven}</td>
			<td>${row.experienceGiven}</td>
			<td>
				<form action="docreateperformance" method="post">
  					<button type="submit" name="challengeId" value="${row.challengeId}" class="btn-link">Select Challenge</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="shared/footer.jspf" %>