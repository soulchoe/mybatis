<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 조회 결과</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath }/searchEmp.do" method="post">
		<table class="table">
			<tr>
				<td>
					<select name="type">
						<option value="emp_id">사원번호</option>
						<option value="emp_name">사원이름</option>
						<option value="email">이메일</option>
						<option value="phone">전화번호</option>
					</select>
				</td>
				<td>
					<input type="text" name="keyword"/>
				</td>
				<td>
					<input type="submit" value="검색"/>
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label>
						<input type="radio" name="gender" value="M"/>남
						<input type="radio" name="gender" value="F"/>여
					</label>
				</td>
			</tr>
			<tr>
				<td>급여</td>
				<td>
					<input type="number" name="salary" step="500000" min="1200000"/>
					<label><input type="radio" name="salFlag" value="ge"/>이상</label>
					<label><input type="radio" name="salFlag" value="le"/>이하</label>
				</td>
			</tr>
			<tr>
				<td>부서</td>
				<td>
					<label><input type="checkbox" name="deptCode" value="D9">총무부</label>
					<label><input type="checkbox" name="deptCode" value="D8">기술지원부</label>
					<label><input type="checkbox" name="deptCode" value="D1">인사관리부</label>
					<label><input type="checkbox" name="deptCode" value="D3">마케팅부</label>
					<label><input type="checkbox" name="deptCode" value="D4">국내영업부</label>
					<label><input type="checkbox" name="deptCode" value="D2">회계관리부</label>
					<label><input type="checkbox" name="deptCode" value="D5">해외영업1부</label>
					<label><input type="checkbox" name="deptCode" value="D6">해외영업2부</label>
					<label><input type="checkbox" name="deptCode" value="D7">해외영업3부</label>
				</td>
			</tr>
			<tr>
				<td>직책</td>
				<td>
					<label><input type="checkbox" name="jobCode" value="J1">대표</label>
					<label><input type="checkbox" name="jobCode" value="J2">부사장</label>
					<label><input type="checkbox" name="jobCode" value="J3">부장</label>
					<label><input type="checkbox" name="jobCode" value="J4">차장</label>
					<label><input type="checkbox" name="jobCode" value="J5">과장</label>
					<label><input type="checkbox" name="jobCode" value="J6">대리</label>
					<label><input type="checkbox" name="jobCode" value="J7">사원</label>
				</td>
			</tr>
			<tr>
				<td>입사일</td>
				<td>
					<input type="date" name="hireDate"/>
					<label><input type="radio" name="hDFlag" value="before"/>이전</label>
					<label><input type="radio" name="hDFlag" value="after"/>이후</label>
				</td>
			</tr>
		</table>
	</form>
	<table class="table">
		<tr>
			<th>사원번호</th>
			<th>이름</th>
 			<th>성별</th>
			<th>주민번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>업무코드</th>
			<th>급여수준</th>
			<th>급여</th>
			<th>보너스</th>
			<th>매니저사번</th>
			<th>입사일</th>
			<th>퇴사일</th>
			<th>퇴사여부</th>
		</tr>
		<c:if test="${empty list }">
			<tr>
				<td colspan="14">조회된 사원이 없습니다</td>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="e" items="${list }">
				<tr>
					<td>${e.empId }</td>
					<td>${e.empName }</td>
					<td>${e.gender=='F'?"여":"남" }</td>
					<td>${e.empNo }</td>
					<td>${e.email }</td>
					<td>${e.phone }</td>
					<td>${e.deptCode }</td>
					<td>${e.jobCode }</td>
					<td>${e.salLevel }</td>
					<td>${e.salary }</td>
					<td>${e.bonus }</td>
					<td>${e.managerId }</td>
					<td>${e.hireDate }</td>
					<td>${e.entDate }</td>
					<td>${e.entYn }</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>