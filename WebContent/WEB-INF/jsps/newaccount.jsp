<%@ include file="shared/header.jspf" %>

<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>

<script type="text/javascript">
	function onLoad() {
		$("#password").keyup(checkPasswordsMatch);
		$("#confirmpass").keyup(checkPasswordsMatch)
		
		$("#details").submit(canSubmit);
		
	}
	
	function canSubmit() {
		var password = $("#password").val()
		var confirmpass = $("#confirmpass").val()
		
		if (password != confirmpass) {
			alert("<fmt:message key='UnmatchedPasswords.user.password'/>");
			return flase;
		}
		else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val()
		var confirmpass = $("#confirmpass").val()

		if (password.length > 3 || confirmpass.length > 3) {

			if (password == confirmpass) {
				$("#matchpass").text("<fmt:message key='MatchedPasswords.user.password'/>");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("<fmt:message key='UnmatchedPasswords.user.password'/>");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}
	}
	

	$(document).ready(onLoad);
</script>

<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Create New Account</title>
</head>
<body>
<%@ include file="shared/navigation.jspf" %>
<h1>Create New Account</h1>
	<sf:form id="details" method="post"
		action="${pageContext.request.contextPath}/createaccount"
		commandName="user">

		<table class="formtable">
			<tr>
				<td>Username:</td>
				<td><sf:input class="control" path="username" name="username"
						type="text" /><br />
					<div class="error">
						<sf:errors path="username"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:input class="control" path="email" name="email"
						type="text" /><br />
					<div class="error">
						<sf:errors path="email"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><sf:input id="password" class="control" path="password"
						name="password" type="password" /><br />
					<div class="error">
						<sf:errors path="password"></sf:errors>
					</div></td>
			</tr>
			<tr>
				<td>Confirm Password:</td>
				<td><input id="confirmpass" class="control" name="confirmpass"
					type="password" />
					<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="control" value="Create" type="submit" /></td>
			</tr>
		</table>

	</sf:form>

<%@ include file="shared/footer.jspf" %>