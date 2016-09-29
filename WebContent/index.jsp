<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://code.jquery.com/jquery-2.1.1.js"></script>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>    
  <script type="text/javascript">
  	$(function(){
  		$("#butt").click(function() {
  			location.href="insert.jsp"
  		})
  		/* $.get("servlet?cmd=select", function(data, textStatus, req) {
  			console.log("a");
  		}) */
  	})
  </script>
<title>Insert title here</title>
</head>
<body>
<div><br></div>
<div id="main" style="width: 600px;" class="container">
	<table id="allTable" class="table table-striped">
		<tr><th>사원번호</th><th>이름</th></tr>
		<c:set var="emplist" value="${requestScope.list}"></c:set>
		 <c:forEach var="emp" items="${emplist}">
	 	<tr>
	 		<td><a href="servlet?cmd=SelectSingle&empno=${emp.empno}">${emp.empno}</a></td>
	 		<td>${emp.ename}</td>
	 	</tr>
	 </c:forEach>
	</table>
	
	<input type="button" value="사원추가" id="butt" class="btn btn-primary btn-block">
	<br>
	<br>
</div>
</body>
</html>
