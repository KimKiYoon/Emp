<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:set var = "singlerow" value = "${requestScope.singlerow}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<script type="text/javascript">
$(function(){
	$('#delete').click(function() {
	location.href="servlet?cmd=delete&empno="+${singlerow.empno};
	})
})
</script>

<div style="margin-top:70px;"></div> 
<form name="insert" action="servlet?cmd=update" method="post"> 
 <div  style="width: 600px" class="container"> 
    <table width="600" border="0" cellpadding="7"  class="table"> 
        <tr align="center" height="50" class="success"> 
            <td colspan="2"> 
                <b> 
                      사원정보
                </b> 
            </td> 
        </tr>
        <tr>
           <td>
              <b>사원번호</b>
           </td>
           <td>
              <input type="text" size="40" name="empno" id="empno" maxlength="10" value = "${singlerow.empno}" class="form-control">
           </td>
        </tr>
         <tr>
           <td>
              <b>사원이름</b>
           </td>
           <td>
              <input type="text"  size="40" name="ename" id="ename" maxlength="10" value= "${singlerow.ename}" class="form-control">
           </td>
        </tr>
         <tr>
           <td>
              <b>직종</b>
           </td>
           <td>
              <input type="text" size="40" name="job" id="job" maxlength="10" value = "${singlerow.job}" class="form-control">
           </td>
        </tr>
         <tr>
           <td>
              <b>매니저번호</b>
           </td>
           <td>
              <input type="text" size="40" name="mgr" id="mgr" maxlength="10" value = "${singlerow.mgr}" class="form-control">
           </td>
        </tr>
         <tr>
           <td>
              <b>고용일</b>
           </td>
           <td>
              <input type="text" size="40" name="hdate" id="hdate" maxlength="10" value = "${singlerow.hiredate}" class="form-control">
           </td>
        </tr>
         <tr>
           <td>
              <b>월급</b>
           </td>
           <td>
              <input type="text" size="40" name="sal" id="sal" maxlength="10" value = "${singlerow.sal}" class="form-control">
           </td>
        </tr>
        <tr>
           <td>
              <b>수당</b>
           </td>
           <td>
               <input type="text" size="40" name="comm" id="comm" maxlength="10" value = "${singlerow.comm}" class="form-control">
           </td>
        </tr>
         <tr>
           <td>
              <b>부서번호</b>
           </td>
           <td>
              <input type="text" size="40" name="deptno" id="deptno" maxlength="10" value = "${singlerow.deptno}" class="form-control">
           </td>
        </tr>
        <tr  class="success">    
        <td colspan="2" align="center" class="c2">           
             <input type = "submit" value = "수정하기" id = "update"  class="btn btn-primary ">
         	<input type = "button" value = "삭제하기" id = "delete" class="btn btn-primary ">
          </td>
        </tr>
    </table>
   </div>
</form>    

</body>
</html>