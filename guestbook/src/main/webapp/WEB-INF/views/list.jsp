<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
</head>
<body>
	<h1>방명록</h1>
	<br>
	방명록 전체 수 : ${count }, 방문한 수 : ${cookieCount }
	<br>
	<br>
	<c:forEach items="${guestbooks}" var="guestbook">
		id : ${guestbook.id }<br>
		name : ${guestbook.name }<br>
		message : ${guestbook.content }<br>
		날짜 : ${guestbook.regdate }<br>
		<c:if test="${sessionScope.isAdmin=='true' }"><a href="delete?id=${guestbook.id }">삭제</a><br></c:if>
		<br>
	</c:forEach>
	<br>
	<c:forEach items="${pageStartList }" var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex }">${status.index + 1 }</a>&nbsp; &nbsp;
	</c:forEach>
	<br><br>
	<form method="post" action="write">
		name : <input type="text" name="name"><br><br>
		message<br>
		<textarea name="content" cols="60" row="6"></textarea><br>
		<input type="submit" value="등록">
	</form>
	
</body>
</html>