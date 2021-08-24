<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post" action="/securityexam/members/join">
		<div>
			<label>이름</label>
			<input type="text" name="name">
		</div>
		<div>
			<label>비밀번호</label>
			<input type="text" name="password">
		</div>
		<div>
			<label>이메일</label>
			<input type="text" name="email">
		</div>
		<div>
			<input type="submit" value="회원가입">
		</div>
	</form>
</body>
</html>