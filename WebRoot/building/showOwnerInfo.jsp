<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" +"tab/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>房间信息管理</title>

</head>


<body>
<!-------------------------------------表格表头构造 ------------------------------------>
<a href="../building/building5.jsp">返回</a>
<BR>
<br>

<h2 align="center">产权人信息</h2><br>

<table border=1 align="center"> 
   <tr>
      <td width=100 align="center"><b>姓名 </td>
	  <td width=200 align="center"><b>身份证号</td>
	  <td width=100 align="center"><b>出生日期</td> 
	  <td width=100 align="center"><b>性别</td>
	  <td width=100 align="center"><b>籍贯</td>
	  <td width=150 align="center"><b>联系方式</td>
	  <td width=100 align="center"><b>常住人口数</td>

   <tr>
   <tr>
   <c:forEach items="${list2}" var="info">
   	  <td align="center">${info.owner_name}</td>
   	  <td align="center">${info.id_num}</td>
   	  <td align="center">${info.birthday}</td>
   	  <td align="center">${info.owner_sex}</td>
   	  <td align="center">${info.hometown}</td>
   	  <td align="center">${info.tele}</td>	  
   	  <td align="center">${info.population}</td>	  
   </c:forEach>
   </tr>
   
   
</table>

<body>
</html>

