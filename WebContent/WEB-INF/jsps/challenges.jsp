<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<div class="container-fluid">
	<h1>Challenges</h1>
	<br>
	<div id="accordion">
		<h3>All Challenges</h3>
		<div>
			<div class="row challenges">

				<c:forEach var="row" items="${challenges}">
					<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">

						<img
							src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
							alt="pic" class="img">
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
		<h3>Completed Challenges</h3>
		<div></div>
	</div>
</div>


<%@ include file="shared/footer.jspf"%>