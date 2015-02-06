<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Login - Nebula</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<jsp:include page="plantilla/css_login.jsp"></jsp:include>
</head>
<body>
	<div class="account-container">
		<div class="content clearfix">
			<form action="SLogin" method="post">
				<input type="hidden" id="accion" name="accion" value="login">
				<h1>
					<img src="${pageContext.request.contextPath}/img/logo.png" height="52px" />
				</h1>
				<div class="login-fields">
					<p>Por favor ingrese usuario y password</p>
					<div class="field">
						<label for="username">Usuario</label> <input type="text"
							id="user" name="user" value="" placeholder="Usuario"
							class="login username-field" />
					</div>
					<!-- /field -->
					<div class="field">
						<label for="password">Password:</label> <input type="password"
							id="pass" name="pass" value="" placeholder="Password"
							class="login password-field" />
					</div>
					<!-- /password -->
				</div>
				<!-- /login-fields -->
				<div class="login-actions">
					<button class="button btn btn-success btn-large">Ingresar</button>
				</div>
				<!-- .actions -->
				<span style="color: #E2302F;">${mensajeError}</span>
			</form>
		</div>
		<!-- /content -->
	</div>
	<!-- /account-container -->
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/js/signin.js"></script>
</body>
</html>
