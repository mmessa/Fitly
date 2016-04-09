<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fitly Profile</title>
</head>
<body>


<p>
<a href="<c:url value='/home'/>">Home</a>
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
<c:forEach var="row" items="${weights}">
	weight: ${row.weight}<br/>
 	created date: ${row.createDate}<br/>
 	<a href="<c:url value='createweight?weightId=${row.weightId}'/>">Edit</a><br/>
    <br>
</c:forEach>

<p>
<a href="<c:url value='createweight'/>">Add Weight</a>
</p>

<h2>Updates</h2>
<c:forEach var="row" items="${updates}">
	notes: ${row.notes}<br/>
 	created date: ${row.createDate}<br/>
    <br>
</c:forEach>

<p>
<a href="<c:url value='createupdate'/>">Add Update</a>
</p>

<h2>Body Fat History</h2>
<c:forEach var="row" items="${bodyFats}">
	weight: ${row.bodyFatPercentage}<br/>
 	created date: ${row.createDate}<br/>
    <br>
</c:forEach>

<p>
<a href="<c:url value='createbodyfat'/>">Add Body Fat%</a>
</p>

<h2>Supplements</h2>
<c:forEach var="row" items="${supplements}">
	name: ${row.name}<br/>
    <br>
</c:forEach>
<p>
<a href="<c:url value='createsupplement'/>">Add Supplement</a>
</p>

<h2>Goals</h2>
<c:forEach var="row" items="${goals}">
	Goal: ${row.name}<br/>
	Type: ${row.type}<br/>
	Description: ${row.description}<br/>
	Value: ${row.value}<br/>
	Complete: ${row.complete}<br/>
    <br>
</c:forEach>
<p>
<a href="<c:url value='creategoal'/>">Add Goal</a>
</p>


</body>
</html>