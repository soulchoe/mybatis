<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty depts }">
		<c:forEach var="d" items="${depts }">
			<ul>
				<li>${d.deptId }</li>
				<li>${d.deptTitle } 인원수:${d.employees.size() }</li>
				<li>
					<c:if test="${not empty d.employees }">
						<c:forEach var="e" items="${d.employees }">
							<table>
								<tr>
									<td>${e.empName }</td>
									<td>${e.jobCode }</td>
									<td>${e.salary }</td>
								</tr>
							</table>
						</c:forEach>
					</c:if>
				</li>
				<li>${d.locationId }</li>
			</ul>
		</c:forEach>
	</c:if>
</body>
</html>