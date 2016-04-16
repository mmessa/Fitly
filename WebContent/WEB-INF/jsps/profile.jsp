<%@ include file="shared/header.jspf" %>
<%@ include file="shared/navigation.jspf" %>


<p>
<a href="<c:url value='/'/>">Home</a>
</p>

<h2>Profile</h2>
First Name = <c:out value='${profile.firstName}' /><br>
Last Name = <c:out value='${profile.lastName}' /><br>
Image = <c:out value='${profile.image}' /><br>
Height Feet = <c:out value='${profile.heightFeet}' /><br>
Height Inches = <c:out value='${profile.heightInches}' /><br>
DOB = <c:out value='${profile.DOB}' /><br>
Gender = <c:out value='${profile.gender}' /><br>
City = <c:out value='${profile.city}' /><br>
State = <c:out value='${profile.state}' /><br>
Zip Code = <c:out value='${profile.zipCode}' /><br>
Gym = <c:out value='${profile.gym}' /><br>
Level = <c:out value='${profile.level}' /><br>
XP = <c:out value='${profile.experiencePoints}' /><br>
Coins = <c:out value='${profile.coins}' /><br><br>

<p>
<a href="<c:url value='editprofile'/>">Edit Profile</a>
</p>
<h2>Weight History</h2>
<table>
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
  					<button type="submit" name="weightId" value="${row.weightId}" class="btn-link">Edit</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
			<td>
				<form action="deleteweight" method="post">
  					<button type="submit" name="weightId" value="${row.weightId}" class="btn-link">Delete</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<form action="createweight" method="post">
  					<button type="submit" class="btn-link">Add Weight</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
	</tbody>
</table>


<h2>Updates</h2>
<table>
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
  					<button type="submit" name="updateId" value="${row.updateId}" class="btn-link">Edit</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
			<td>
				<form action="deleteupdate" method="post">
  					<button type="submit" name="updateId" value="${row.updateId}" class="btn-link">Delete</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<form action="createupdate" method="post">
  					<button type="submit" class="btn-link">Add Update</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
	</tbody>
</table>


<h2>Body Fat History</h2>
<table>
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
  					<button type="submit" name="bodyFatId" value="${row.bodyFatId}" class="btn-link">Edit</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
			<td>
				<form action="deletebodyfat" method="post">
  					<button type="submit" name="bodyFatId" value="${row.bodyFatId}" class="btn-link">Delete</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<form action="createbodyfat" method="post">
  					<button type="submit" class="btn-link">Add Body Fat%</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
	</tbody>
</table>


<h2>Supplements</h2>
<table>
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
  					<button type="submit" name="supplementId" value="${row.supplementId}" class="btn-link">Edit</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
			<td>
				<form action="deletesupplement" method="post">
  					<button type="submit" name="supplementId" value="${row.supplementId}" class="btn-link">Delete</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<form action="createsupplement" method="post">
  					<button type="submit" class="btn-link">Add Supplement</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
	</tbody>
</table>


<h2>Goals</h2>
<table>
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
  					<button type="submit" name="goalId" value="${row.goalId}" class="btn-link">Edit</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
			<td>
				<form action="deletegoal" method="post">
  					<button type="submit" name="goalId" value="${row.goalId}" class="btn-link">Delete</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td>
				<form action="creategoal" method="post">
  					<button type="submit" class="btn-link">Add Goal</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
	</tbody>
</table>

<h2>My Challenges</h2>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Level</th>
			<th>Description</th>
			<th>Coins Given</th>
			<th>Experience Given</th>
			<th>Started Date</th>
			<th>Completed Date</th>
			<th>Completed</th>
			<th colspan="9"></th>
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
			<td>${row.completedDate}</td>
			<td>${row.complete}</td>
			<td>
				<form action="deleteperformance" method="post">
  					<button type="submit" name="performanceId" value="${row.performanceId}" class="btn-link">Delete</button>
  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<%@ include file="shared/footer.jspf" %>