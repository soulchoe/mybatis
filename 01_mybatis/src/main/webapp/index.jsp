<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본mybatis적용하기</title>
</head>
<body>
	<h2>mybatis 실행해보기</h2>
	<h3><a href="${path }/insertStudent.do">학생등록</a></h3>
	<div>
		<form action="${path }/insertStudentByName.do">
			<input type="text" name="name">
			<input type="submit" value="저장">
		</form>
		
	</div>
	
	<h2>학생정보를 입력받아 추가하기</h2>
	<form action="${path }/insertStudentAll.do" method="post">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="phone" placeholder="전화번호"><br>
		<input type="email" name="email" placeholder="이메일"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="submit" value="저장"><br>
	</form>
	
	<h2>학생정보 수정하기</h2>
	<form action="${path }/updateStudent.do" method="post">
		<input type="text" name="no" placeholder="학생번호"><br>
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="phone" placeholder="전화번호"><br>
		<input type="email" name="email" placeholder="이메일"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="submit" value="저장"><br>
	</form>
	
	<h2>학생정보 삭제하기</h2>
	<form action="${path }/deleteStudent.do" method="post">
		<input type="text" name="no" placeholder="학생번호"><br>
		<input type="submit" value="삭제"><br>
	</form>
	
	어쩌구저쩌거

	<h3>학생번호로 조회하기</h3>
	<h4>
		<a href="${path }/student/selectStudent.do?no=1">1번학생조회</a>
	</h4>
	
	<h3>전체학생 조회하기</h3>
	<h4>
		<a href="${path }/student/selectStudentAll.do">전체학생조회</a>
	</h4>
	
	<h3>이름으로 학생조회하기</h3>
	<form action="${path }/student/selectStudentByName.do">
		<input type="text" placeholder="이름" name="searchName">
		<input type="submit" value="검색">
	</form>
	
	<h3>vo를 생성하지 않고 데이터 가져오기</h3>
	<p>map을 이용해서 데이터를 가져올수 있다,</p>
	<a href="${path }/student/selectStudentMap.do?no=1">1번학생</a>
	<p>map으로 다수의 데이터 출력하기</p>
	<h4><a href="${path}/student/selectStudentListMap">전체학생조회</a></h4>
	
	<h3>마이바티스에서 페이징처리</h3>
	<h4><a href="${path }/student/studentPage.do">페이징처리</a></h4>
</body>
</html>