<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<div class="container-fluid">
	<h1>Fitly Challenges</h1>
	<br>
	<div id="accordion">
		<h3>All Challenges</h3>
		<div>
			<div class="row challenges">

				<c:forEach var="row" items="${challenges}">
					<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">

						<img
							src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
							alt="pic" class="challengeImg">
						<c:choose>
							<c:when test="${level < row.level}">

								<div class="btn btn-info lowLevel">Unqualified Level</div>


							</c:when>
							<c:otherwise>
								<form action="docreateperformance" method="post">
									<button type="submit" name="challengeId"
										value="${row.challengeId}"
										class="btn btn-info selectChallengeButton">Select
										Challenge</button>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
							</c:otherwise>
						</c:choose>
					</div>

				</c:forEach>
			</div>

		</div>
		<h3>Beginner Challenges</h3>
		<div>
			<div class="row challenges">

				<c:forEach var="row" items="${beginnerChallenges}">
					<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">

						<img
							src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
							alt="pic" class="challengeImg">
						<c:choose>
							<c:when test="${level < row.level}">

								<div class="btn btn-info lowLevel">Unqualified Level</div>


							</c:when>
							<c:otherwise>
								<form action="docreateperformance" method="post">
									<button type="submit" name="challengeId"
										value="${row.challengeId}"
										class="btn btn-info selectChallengeButton">Select
										Challenge</button>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
		</div>
		<h3>Intermediate Challenges</h3>
		<div>
			<div class="row challenges">

				<c:forEach var="row" items="${intermediateChallenges}">
					<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">

						<img
							src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
							alt="pic" class="challengeImg">
						<c:choose>
							<c:when test="${level < row.level}">

								<div class="btn btn-info lowLevel">Unqualified Level</div>


							</c:when>
							<c:otherwise>
								<form action="docreateperformance" method="post">
									<button type="submit" name="challengeId"
										value="${row.challengeId}"
										class="btn btn-info selectChallengeButton">Select
										Challenge</button>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
		</div>
		<h3>Advanced Challenges</h3>
		<div>
			<div class="row challenges">

				<c:forEach var="row" items="${advancedChallenges}">
					<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">

						<img
							src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
							alt="pic" class="challengeImg">
						<c:choose>
							<c:when test="${level < row.level}">

								<div class="btn btn-info lowLevel">Unqualified Level</div>


							</c:when>
							<c:otherwise>
								<form action="docreateperformance" method="post">
									<button type="submit" name="challengeId"
										value="${row.challengeId}"
										class="btn btn-info selectChallengeButton">Select
										Challenge</button>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</div>
		</div>
		<h3>My Completed Challenges</h3>
		<div>
			<div class="row challenges">
				<c:choose>
					<c:when test="${completedChallenges.size() == 0}">
				No challenges completed
				</c:when>
					<c:otherwise>
						<c:forEach var="row" items="${completedChallenges}">
							<div class="col-xs-6 col-sm-4 col-md-3 col-lg-3 completedChallenge">

								<img
									src="<c:url value='/static/images/static/${row.pictureUrl}'/>"
									alt="pic" class="challengeImg">


							</div>
							
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</div>

		</div>
	</div>
</div>


<%@ include file="shared/footer.jspf"%>
