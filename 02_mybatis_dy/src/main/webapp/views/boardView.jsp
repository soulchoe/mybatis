<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:if test="${not empty post }">
		<table class="table">
			<tr>
				<td>번호</td>
				<td>${post.boardNo }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${post.boardTitle }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${post.mem.username } ${post.mem.email }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${post.boardContent }</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${post.boardDate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${post.boardRead }</td>
			</tr>
		</table>
	 	<table class="table-sm">
			<c:forEach var="c" items="${post.comments }">
				<tr>
					<td>${c.boardCommentWriter.userid }</td>
					<td>${c.boardCommentContent }</td>
					<td>${c.boardCommentDate }</td>
				</tr>	
			</c:forEach>
		</table>
	</c:if>
</body>
</html>