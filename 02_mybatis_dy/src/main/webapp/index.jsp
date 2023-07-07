<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스 동적쿼리</title>
</head>

<body>
	<a href="${path }/emp/selectAll.do">전체 사원 조회</a>
	<a href="${path }/emp/selectEmpPage.do">전체 사원 페이지별 조회</a>
	
	<h2>데이터 연관관계 설정하기</h2>
	<h3>
		<a href="${path }/emp/association.do">join으로 객체 가져오기</a>
	</h3>
	
	<h2>부서 조회하기</h2>
	<h3>
		<a href="${path }/selectDeptAll.do">전체부서 가져오기</a>
	</h3>
	
	<h2>다른환경 접속하기</h2>
	<h3>
		<a href="${path}/member.do">회원 가져오기</a>
	</h3>
	<h2>게시글 가져오기</h2>
	<h3>
		<a href="${path}/board.do?no=33">33번 게시글 가져오기+댓글, 작성자이름, 이메일</a>
	</h3>
</body>
</html>