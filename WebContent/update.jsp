<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="insert" action="servlet" method="post"> 
 <div align="center"> 
    <table width="600" border="0" cellpadding="7" > 
        <tr align="center" bgcolor="yellow" height="50"> 
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
              <input type="text" size="40" name="empno" id="empno" maxlength="10" value = "${singlerow.empno}" >
           </td>
        </tr>
         <tr>
           <td>
              <b>사원이름</b>
           </td>
           <td>
              <input type="text"  size="40" name="ename" id="ename" maxlength="10" value= "${singlerow.ename}" >
           </td>
        </tr>
         <tr>
           <td>
              <b>직종</b>
           </td>
           <td>
              <input type="text" size="40" name="job" id="job" maxlength="10" value = "${singlerow.job}" >
           </td>
        </tr>
         <tr>
           <td>
              <b>매니저번호</b>
           </td>
           <td>
              <input type="text" size="40" name="mgr" id="mgr" maxlength="10" value = "${singlerow.mgr}" >
           </td>
        </tr>
         <tr>
           <td>
              <b>고용일</b>
           </td>
           <td>
              <input type="text" size="40" name="hdate" id="hdate" maxlength="10" value = "${singlerow.hiredate}" >
           </td>
        </tr>
         <tr>
           <td>
              <b>월급</b>
           </td>
           <td>
              <input type="text" size="40" name="sal" id="sal" maxlength="10" value = "${singlerow.sal}" >
           </td>
        </tr>
        <tr>
           <td>
              <b>수당</b>
           </td>
           <td>
               <input type="text" size="40" name="comm" id="comm" maxlength="10" value = "${singlerow.comm}" >
           </td>
        </tr>
         <tr>
           <td>
              <b>부서번호</b>
           </td>
           <td>
              <input type="text" size="40" name="deptno" id="deptno" maxlength="10" value = "${singlerow.deptno}" readonly>
           </td>
        </tr>
        <tr bgcolor="yellow">    
        <td colspan="2" align="center" class="c2">           
             <input type = "button" value = "수정하기" id = "update">
          </td>
        </tr>
    </table>
</body>
</html>
