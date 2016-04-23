<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navigation.jspf"%>

<h2>Profile</h2>
<img src="<c:url value='/static/images/static/profilePic2.jpg'/>" alt="pic">
<br>
 
First Name =
<c:out value='${profile.firstName}' />
<br>
Last Name =
<c:out value='${profile.lastName}' />
<br>
Image =
<c:out value='${profile.image}' />
<br>
Height Feet =
<c:out value='${profile.heightFeet}' />
<br>
Height Inches =
<c:out value='${profile.heightInches}' />
<br>
DOB =
<c:out value='${profile.DOB}' />
<br>
Gender =
<c:out value='${profile.gender}' />
<br>
City =
<c:out value='${profile.city}' />
<br>
State =
<c:out value='${profile.state}' />
<br>
Zip Code =
<c:out value='${profile.zipCode}' />
<br>
Gym =
<c:out value='${profile.gym}' />
<br>
Level =
<c:out value='${profile.level}' />
<br>
XP =
<c:out value='${profile.experiencePoints}' />
<br>
Coins =
<c:out value='${profile.coins}' />
<br>
<br>

<a href="<c:url value='editprofile'/>">Edit Profile</a>

<hr>
<h2>Weight History</h2>
<c:choose>
	<c:when test="${weights.size() == 0}">
		No weights recorded
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Weight</th>
					<th>Date</th>
					<th colspan="4"></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="row" items="${weights}">

					<tr>
						<td>${row.weight}</td>
						<td>${row.createDate}</td>
						<td>
							<form action="createweight" method="post">
								<button type="submit" name="weightId" value="${row.weightId}"
									class="btn-link">Edit</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
						<td>
							<form action="deleteweight" method="post">
								<button type="submit" name="weightId" value="${row.weightId}"
									class="btn-link">Delete</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>



	</c:otherwise>

</c:choose>
<form action="createweight" method="post">
	<button type="submit" class="btn-link">Add Weight</button>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>



<h2>Updates</h2>
<c:choose>
	<c:when test="${updates.size() == 0}">
		No updates recorded
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Notes</th>
					<th>Date</th>
					<th colspan="4"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${updates}">
					<tr>
						<td>${row.notes}</td>
						<td>${row.createDate}</td>
						<td>
							<form action="createupdate" method="post">
								<button type="submit" name="updateId" value="${row.updateId}"
									class="btn-link">Edit</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
						<td>
							<form action="deleteupdate" method="post">
								<button type="submit" name="updateId" value="${row.updateId}"
									class="btn-link">Delete</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<form action="createupdate" method="post">
	<button type="submit" class="btn-link">Add Update</button>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>


<h2>Body Fat History</h2>
<c:choose>
	<c:when test="${bodyFats.size() == 0}">
		No body fats recorded
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Body Fat%</th>
					<th>Date</th>
					<th colspan="4"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${bodyFats}">
					<tr>
						<td>${row.bodyFatPercentage}</td>
						<td>${row.createDate}</td>
						<td>
							<form action="createbodyfat" method="post">
								<button type="submit" name="bodyFatId" value="${row.bodyFatId}"
									class="btn-link">Edit</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
						<td>
							<form action="deletebodyfat" method="post">
								<button type="submit" name="bodyFatId" value="${row.bodyFatId}"
									class="btn-link">Delete</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<form action="createbodyfat" method="post">
	<button type="submit" class="btn-link">Add Body Fat%</button>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<h2>Supplements</h2>
<c:choose>
	<c:when test="${supplements.size() == 0}">
		No supplements recorded
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th colspan="3"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${supplements}">
					<tr>
						<td>${row.name}</td>
						<td>
							<form action="createsupplement" method="post">
								<button type="submit" name="supplementId"
									value="${row.supplementId}" class="btn-link">Edit</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
						<td>
							<form action="deletesupplement" method="post">
								<button type="submit" name="supplementId"
									value="${row.supplementId}" class="btn-link">Delete</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<form action="createsupplement" method="post">
	<button type="submit" class="btn-link">Add Supplement</button>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<h2>Goals</h2>
<c:choose>
	<c:when test="${goals.size() == 0}">
		No goals recorded
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Goal</th>
					<th>Type</th>
					<th>Description</th>
					<th>Value</th>
					<th>Complete</th>
					<th colspan="7"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${goals}">
					<tr>
						<td>${row.name}</td>
						<td>${row.type}</td>
						<td>${row.description}</td>
						<td>${row.value}</td>
						<td>${row.complete}</td>
						<td>
							<form action="creategoal" method="post">
								<button type="submit" name="goalId" value="${row.goalId}"
									class="btn-link">Edit</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
						<td>
							<form action="deletegoal" method="post">
								<button type="submit" name="goalId" value="${row.goalId}"
									class="btn-link">Delete</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<form action="creategoal" method="post">
	<button type="submit" class="btn-link">Add Goal</button>
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

<h2>My Challenges</h2>
<c:choose>
	<c:when test="${performances.size() == 0}">
		No challenges started or completed
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Level</th>
					<th>Description</th>
					<th>Coins Given</th>
					<th>Experience Given</th>
					<th>Start Date</th>
					<th>Completed Date</th>
					<th>Completed</th>
					<th colspan="10"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${performances}">
					<tr>
						<td>${row.name}</td>
						<td>${row.level}</td>
						<td>${row.description}</td>
						<td>${row.coinsGiven}</td>
						<td>${row.experienceGiven}</td>
						<td>${row.startedDate}</td>
						<c:choose>
							<c:when test="${row.complete == 1}">
								<td>${row.completedDate}</td>
								<td>Yes</td>
							</c:when>
							<c:otherwise>
								<td> -- </td>
								<td>No</td>
								<td>
									<form action="docompleteperformance" method="post">
										<button type="submit" name="performanceId"
											value="${row.performanceId}" class="btn-link">Complete</button>
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
								</td>
							</c:otherwise>
						</c:choose>
						<td>
							<form action="deleteperformance" method="post">
								<button class="btn btn-danger" type="submit" name="performanceId"
									value="${row.performanceId}">Delete</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>

<%@ include file="shared/footer.jspf"%>