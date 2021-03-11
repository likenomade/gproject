<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MemberList **</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/myStyle.css">
</head>
<body>
<h2>** Spring Mybatis MemberList_Paging **</h2>
<c:if test="${message!=null}">
=> ${message}
</c:if>
<hr>
<table width=800 border="1" >
	<tr align="center" height="30" bgcolor="Lavender">
	<td>I D</td><td>Password</td><td>Name</td><td>Level</td><td>Birthday</td>
	<td>Point</td><td>Weight</td><td>추천인</td><td>Image</td>
	</tr>
  <c:forEach var="row" items="${Banana}">
	<tr>
	<td><a href="mdetail?id=${row.id}">${row.id}</a></td>
	<td>${row.password}</td><td>${row.name}</td><td>${row.lev}</td>
	<td>${row.birthd}</td><td>${row.point}</td><td>${row.weight}</td>
	<td>${row.rid}</td>
	<td><img src="${row.uploadfile}" width="70" height="70">        </td>
	</tr>
  </c:forEach>
</table><br>
<div  align="center">
  <c:choose>    
  	<c:when test="${sPageNo>pageNoCount}">
  		<a href="mpage?currPage=1">First</a>&nbsp;
  		<a href="mpage?currPage=${sPageNo-1}">&lt;</a>&nbsp;&nbsp;
  	</c:when>
  	<c:otherwise>
  		<font color="gray">First &lt;&nbsp;&nbsp;</font>
  	</c:otherwise>
  </c:choose>
  
  <c:forEach var="i" begin="${sPageNo}" end="${ePageNo}">
  	<c:if test="${i==currPage}">
     	<font size="5" color="Orange">${i}&nbsp;</font>  
    </c:if>
    <c:if test="${i!=currPage}">
     	<a href="mpage?currPage=${i}">${i}&nbsp;</a>  
    </c:if>
  </c:forEach>
  
  <c:choose>   
  	<c:when test="${ePageNo<totalPageNo}">
  		<a href="mpage?currPage=${ePageNo+1}">&nbsp;&nbsp;&gt;&nbsp;</a>
  		<a href="mpage?currPage=${totalPageNo}">Last</a>
  	</c:when>
  	<c:otherwise>
  		<font color="gray">&nbsp;&nbsp;&gt;&nbsp; Last</font>
  	</c:otherwise>
  </c:choose>
</div>

<hr><a href="home">[Home]</a>
</body>
</html>