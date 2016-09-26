<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>사원정보 추가Page</title>
   <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
   <script type="text/javascript">   </script>
</head>

<body>
<div style="margin-top:70px;"></div> 
<form name="insert" action="servlet?cmd=insert" method="post"> 
 <div align="center"> 
    <table width="600" border="0" cellpadding="7" > 
        <tr align="center" bgcolor="yellow" height="50"> 
            <td colspan="2"> 
                <b> 
                      사원정보 추가
                </b> 
            </td> 
        </tr>
        <tr>
           <td>
              <b>사원번호</b>
           </td>
           <td>
              <input type="text" size="40" name="empno" id="empno" maxlength="10" >
           </td>
        </tr>
         <tr>
           <td>
              <b>사원이름</b>
           </td>
           <td>
              <input type="text"  size="40" name="ename" id="ename" maxlength="10">
           </td>
        </tr>
         <tr>
           <td>
              <b>직종</b>
           </td>
           <td>
              <input type="text" size="40" name="job" id="job" maxlength="10">
           </td>
        </tr>
         <tr>
           <td>
              <b>매니저번호</b>
           </td>
           <td>
              <input type="text" size="40" name="mgr" id="mgr" maxlength="10">
           </td>
        </tr>
         <tr>
           <td>
              <b>고용일</b>
           </td>
           <td>
              <input type="text" size="40" name="hdate" id="hdate" maxlength="10">
           </td>
        </tr>
         <tr>
           <td>
              <b>수당</b>
           </td>
           <td>
              <input type="text" size="40" name="sal" id="sal" maxlength="10">
           </td>
        </tr>
        <tr>
           <td>
              <b>월급</b>
           </td>
           <td>
              <input type="text" size="40" name="comm" id="comm" maxlength="10">
           </td>
        </tr>  
         <tr>
           <td>
              <b>부서번호</b>
           </td>
           <td>
              <input type="text" size="40" name="deptno" id="deptno" maxlength="10">
           </td>
        </tr>
        <tr bgcolor="yellow">    
        <td colspan="2" align="center" class="c2">           
             <input type="submit" value="완료" id="btn">
             <input type="reset" value="취소">
          </td>
        </tr>
    </table>
   </div>
</form>    
   
</body>
</html>