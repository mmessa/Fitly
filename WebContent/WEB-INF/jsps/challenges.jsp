<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>



<div class="container-fluid">
	<div class="row challenges">

		<c:forEach var="row" items="${challenges}">
			<div
				class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
				<div class="challengeHeader">
					${row.name}
				</div> 
				<img
					src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
					alt="pic" class="img"> ${row.level} ${row.description}
				${row.coinsGiven} ${row.experienceGiven}
				<form action="docreateperformance" method="post">
						<button type="submit" name="challengeId"
							value="${row.challengeId}" class="btn-link">Select
							Challenge</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>

			</div>
		</c:forEach>
	</div>
</div>

<h2>Challenges</h2>
<table class="table">
	<thead>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Description</th>
			<th>Coins Given</th>
			<th>Experience Given</th>
			<th>PictureUrl</th>
			<th colspan="6"></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="row" items="${challenges}">
			<tr>
				<td>${row.name}</td>
				<td>${row.level}</td>
				<td>${row.description}</td>
				<td>${row.coinsGiven}</td>
				<td>${row.experienceGiven}</td>
				<td><img
					src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
					alt="pic"></td>
				<td>
					<form action="docreateperformance" method="post">
						<button type="submit" name="challengeId"
							value="${row.challengeId}" class="btn-link">Select
							Challenge</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>



<%@ include file="shared/footer.jspf"%>