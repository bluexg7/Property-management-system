<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" +"tab/";
%>
<%long order = 1;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
-->
</style>

<script>
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
var isSelected=1;
function clickall(){//全选功能  2015.7.12
   var el = document.getElementsByTagName('input'); 
   var len = el.length; 
   for(var i=0; i<len; i++) { 
   if((el[i].type=="checkbox")) { 
     if(isSelected==1)
     el[i].checked = true;
     else
     el[i].checked = false;
  } //if
} //for
   isSelected++;
   isSelected=isSelected%2;
}
</script>
<!-- --------------------修改由此开始 ------------------------->
<style type="text/css">
table.gridtable {
    margin: auto;
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;	
	border-color: #999999;
	border-collapse:collapse;
	
}
table.gridtable td {
    background:#b5cfd2 url('images/tab_images/tab_05.gif');
	border-width: 1px;
	border:1px;
	padding:3px;
	border-style: solid;
	border-color: #999999;
}
table.gridtable td.tdbtn input{
color: #d9eef7; 
border: solid 1px #0076a3; 
background: #0095cd; 
background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5)); 
background: -moz-linear-gradient(top, #00adee, #0078a5); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00adee', endColorstr='#0078a5'); 
}
table.gridtable td.tdbtn input:hover { 
background: #007ead; 
background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e)); 
background: -moz-linear-gradient(top, #0095cc, #00678e); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0095cc', endColorstr='#00678e'); 
} 
table.gridtable td.tdbtn input:active { 
color: #80bed6; 
background: -webkit-gradient(linear, left top, left bottom, from(#0078a5), to(#00adee)); 
background: -moz-linear-gradient(top, #0078a5, #00adee); 
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#0078a5', endColorstr='#00adee'); 
} 
table.gridtable select{
  WIDTH: 150px；
  position:relative;
  left:-2px;top:-2px;
  font-size:12px;
  line-height:14px;
  border:1px;
  color:#909993;
}
table.gridtable input[type=text]{
  border:2px solid #F4F5F3; 
  width:150px; 
  font-size:16px; 
  font-weight:bold; 
  left:-2px;top:-2px;
  line-height:14px; 
  height:14px;
}
.box1{
 background:url('images/tab_05.gif');
 height:20px;
}

</style>
<style>
.optbtn{
 background-color:transparent;  /* 背景色透明 */
 border:0px;       /* 边框取消 */
 border-bottom:1px solid #005aa7; /* 下划线效果 */
 
}
</style>
</head>
<body>
<div class="box1">&nbsp;
<font face="黑体" size="2" color="gray">你当前的位置:</font>
<font color="blue" size=2pt>[业务中心]-[我的邮件]<br /><br /></font>
</div>
<br/>


<form action="../servlet/Owner6_Select" method="post">

<table  class="gridtable" width="98%" border="0" cellspacing="0" cellpadding="0">

<tr align="center">
	<td width="50%">
	<font size=2>建议人姓名:</font>
	<input type="text" id="suggestor" name="suggestor"></input>
	</td>
	
	<td width="50%">
	<font size=2>建议时间:</font>
	<input type="text" id="time" name="time"></input>
	</td>
	
</tr>
		


<tr>
  <td colspan="3"  align="right" class="tdbtn">
  <input type="submit" id="btnAdd" value="增加" class="buttonadd"></input>
  <input type="submit" id="btnAdd" value="删除" class="buttonadd"></input>
  <input type="submit" id="btnAdd" value="查询" class="buttonadd"></input>
  <input type="reset" id="btnAdd" value="重置" class="buttonadd"></input>
  </td>
</tr>
</table>
</form>
<br>

<!-- --------------------修改结束 2015.7.11------------------------->

<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="8" background="<%=basePath%>/images/tab_12.gif">
									&nbsp;
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="1"
										bgcolor="b5d6e6" onmouseover="changeto()"
										onmouseout="changeback()">
										<tr>
											<td width="5%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<input type="checkbox" name="checkbox" value="checkbox"
														onclick="clickall()" />
													<span class="STYLE1">全选</span>
												</div>
											</td>
											<td width="5%" height="eight=" 22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">建议编号</span>
												</div>
											</td>
											<td width="7%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">建议人姓名</span>
												</div>
											</td>
											<td width="10%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">整体印象</span>
												</div>
											</td>
											<td width="8%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">保洁</span>
												</div>
											</td>
											<td width="8%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">安保</span>
												</div>
											</td>
											<td width="7%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">维修</span>
												</div>
											</td>
											<td width="8%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">车辆管理</span>
												</div>
											</td>
											<td width="7%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">绿化</span>
												</div>
											</td>
											<td width="5%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">社区文化</span>
												</div>
											</td>
											<td width="10%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">建议时间</span>
												</div>
											</td>
											
										
											
											<td width="20%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF" class="STYLE1">
												<div align="center">
													基本操作
												</div>
											</td>
										</tr>

										<!-- -循环填表 -->
										<c:forEach items="${owner6}" var="owner6">
											<tr>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<input type="checkbox" name="checkbox2" value="checkbox" />
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center" class="STYLE1">
														<div align="center">${owner6.sug_num}</div>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.suggestor}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center" id="floortip">
														<span class="STYLE1" >${owner6.wholeimpress}
														</span>
													</div>
												</td>
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.cleaning}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.security}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.maintain}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.carmanage}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.green}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.culture}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" >${owner6.sug_date}</span>
													</div>
												</td>


												<td height="20" bgcolor="#FFFFFF" align="center">
													<img src="<%=basePath%>/images/edt.gif" />
													<button type="button" name="btnedit" id="btnedit"
														class="optbtn" onclick="openEdit()">
														编辑
													</button>
													<img src="<%=basePath%>/images/del.gif" />
													<button type="button" name="btndel" id="btndel"
														class="optbtn">
														删除
													</button>
												</td>
											</tr>
										</c:forEach>

									</table>
								</td>
								<td width="8" background="<%=basePath%>/images/tab_15.gif">
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="35" background="<%=basePath%>/images/tab_19.gif">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="12" height="35">
									<img src="<%=basePath%>/images/tab_18.gif" width="12" height="35" />
								</td>
								<td>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td class="STYLE4">
												&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页
											</td>
											<td>
												<table border="0" align="right" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="40">
															<img src="<%=basePath%>/images/first.gif" width="37" height="15" />
														</td>
														<td width="45">
															<img src="<%=basePath%>/images/back.gif" width="43" height="15" />
														</td>
														<td width="45">
															<img src="<%=basePath%>/images/next.gif" width="43" height="15" />
														</td>
														<td width="40">
															<img src="<%=basePath%>/images/last.gif" width="37" height="15" />
														</td>
														<td width="100">
															<div align="center">
																<span class="STYLE1">转到第 <input name="textfield"
																		type="text" size="4"
																		style="height: 12px; width: 20px; border: 1px solid #999999;" />
																	页 </span>
															</div>
														</td>
														<td width="40">
															<img src="<%=basePath%>/images/go.gif" width="37" height="15" />
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
								<td width="16">
									<img src="<%=basePath%>/images/tab_20.gif" width="16" height="35" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
	</body>
</html>