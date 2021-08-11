<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>관리자 로그인</h1>
	<br><br>
	${errorMessage }<br>
	<form method="post" action="login">
		<input type="text" name="password"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>