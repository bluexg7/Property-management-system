<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" +"tab/";
%>
<% 
	long order = 1; 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>计划信息管理</title>

<!---------------------------CSS样式------------------------------>
<style type="text/css">	
a{
   text-decoration:none;color:white;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px
}
.STYLE3 {
	font-size: 12px;
	font-weight: bold;
}
.STYLE4 {
	color: #03515d;
	font-size: 12px;
}
.close {
	width: 50px;
	height: 30px;
	text-align: center;
	border-radius: 5px;
	line-height: 30px;
	position: absolute;
	left: 100%;
	margin-left: -60px;
	margin-top: 4px;
}
.close:hover {
	background: #008000;
	color: #FFFFFF;
}
.beautywords {
	font-size: 40px;
	font-family: 方正姚体;
	color: blue;
}
</style>



<!------------------------ Jquery 2015.7.12 -------------------->
<script type="text/javascript"
src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js">
</script>

<div id=win style="display: none; position: absolute; left: 50%; top: 40%; width: 450px; height: 440px; margin-left: -300px; margin-top: -200px; border: 1px solid #888; background-color: #ffffff; text-align: center;">
     
     <table style="background-color:#008080;" width="100%" heigh="20%">
     	<tr>
     		<td width="90%"><span><font color="#f5f5f5" face="microsoft yahei" size="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;产权人信息</font></span></td>
     		<td width="10%"><a href="javascript:closeLogin();" align="right" ; class="close">关闭</a></td>
     	</tr>
     </table>
     <br>
     <span>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</span><input id="showownernum" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br><br>
     <span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</span><input id="showname" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br><br>
     <span>身&nbsp;份&nbsp;证&nbsp;号:</span><input id="showidnum" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br><br>
     <span>出&nbsp;生&nbsp;日&nbsp;期:</span><input id="showbirthday" onclick="WdatePicker()" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br><br>   
     <span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</span><input id="showsex" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br><br>
     <span>籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯:</span><input id="showhometown" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br><br>
     <span>联&nbsp;系&nbsp;方&nbsp;式:</span><input id="showtele" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input ><br><br>
     <span>常&nbsp;住人口数:</span><input id="showpopulation"  style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input> <br><br>

	 <input type="submit" id="editSure" style="position: absolute; left: 20%; top: 85%;background-color:#ff8040" value="                确定               " onclick="editSured()"></input>
</div>
<div style='display: none; position: absolute; left: 40%; top: 14%;'id='updateDoneDiv'>
	<span class="beautywords">修改成功</span>
</div>
		
<div style='display: none; position: absolute; left: 40%; top: 14%;'id='delDoneDiv'>
	<span class="beautywords">删除成功！</span>
</div>	

<div style='display: none; position: absolute; left: 40%; top: 14%;'id='addDoneDiv'>
	<span class="beautywords">添加成功！</span>
</div>

<div id=addwin style="display: none; position: absolute; left: 50%; top: 40%; width: 420px; height: 440px; margin-left: -300px; margin-top: -200px; 
		border: 1px solid #888; background-color: #ffffff; text-align: center;" >
		<table style="background-color:#008080;" width="100%" heigh="20%">
			<tr>
				<td width="90%"><label><font color="#f5f5f5" face="microsoft yahei" size="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加产权人信息</font></label></td>
				<td width="10%"><a href="javascript:closeAdd();" alien="right" ; class="close">关闭</a></td>
			</tr>
		</table>
		
		
    <br>
	<label>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label><input id="ownernum_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>
	<label>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label><input id="name_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>
	<label>身&nbsp;份&nbsp;证&nbsp;号:</label><input id="idnum_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>
	<label>出&nbsp;生&nbsp;日&nbsp;期:</label><input id="birthday_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000" onclick="WdatePicker()"></input><br></br>
	<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label><input id="sex_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>
	<label>籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;贯:</label><input id="hometown_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>
	<label>联&nbsp;系&nbsp;方&nbsp;式:</label><input id="tele_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>
	<label>常&nbsp;住人口数:</label><input id="population_info" type="text" style="width:160px; height:15px; background-color:#ffffff; border:solid 1px #7dbad7; font-size:12px; color:#000000"></input><br></br>

	<input type="submit" id="addSure" style="position: absolute; left: 19%; top: 85%; background-color:#ff8040" value="                确定               " onclick="addSured()"></input>
</div>
<!---------------------------------Jquery end 2015.7.12---------------------------->

<!--------------------------------JavaScript函数-------------------------------->
<script type="text/javascript" src="../js/WdatePicker.js"></script>
<script>		
var selectedId;//被选中的item
var doc=document;

function openEdit(id){  
   
   	var ownernum=doc.getElementById("ownernum"+id).innerHTML;
   	var name=doc.getElementById("ownername"+id).innerHTML;
   	var idnum=doc.getElementById("idnum"+id).innerHTML;
   	var birthday=doc.getElementById("birthday"+id).innerHTML;	
	var hometown=doc.getElementById("hometown"+id).innerHTML;
	var sex=doc.getElementById("ownersex"+id).innerHTML;
	var tele=doc.getElementById("tele"+id).innerHTML;
	var population=doc.getElementById("population"+id).innerHTML;
	
	
	doc.getElementById("showownernum").value=ownernum;
	doc.getElementById("showname").value=name;
	doc.getElementById("showidnum").value=idnum;
	doc.getElementById("showbirthday").value=birthday;
	doc.getElementById("showhometown").value=hometown;
	doc.getElementById("showsex").value=sex;
	doc.getElementById("showtele").value=tele;
	doc.getElementById("showpopulation").value=population;
	doc.getElementById("win").style.display="";
	selectedId=id;
}
//在表格上跳转到第X页
function jumpTo(){

	 var temp=document.getElementById('jump_to').value;
	 var count = <%=(Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)%>
	 if(temp<=count & temp>0)
	  	window.location.href="../servlet/Owner1?jump_type=jump_to&to_page="+temp;
}
function closeLogin(){   
    document.getElementById("win").style.display="none";
}
//关闭添加记录窗口 2015.7.14
function closeAdd(){   
	document.getElementById("addwin").style.display="none";
}
//添加记录确认 2015.7.14
function addSured(){  
	 
	 var isSureAdded=confirm('确定要添加这条记录吗？');
	 var completeInfo="";
	 if(isSureAdded==true){
	 	var addedownernum=doc.getElementById("ownernum_info").value;
		 completeInfo+=addedownernum+'#';
		 var addedname=doc.getElementById("name_info").value;
		 completeInfo+=addedname+'#';
		 var addedidnum=doc.getElementById("idnum_info").value;
		 completeInfo+=addedidnum+'#';
		 var addedbirthday=doc.getElementById("birthday_info").value;
		 completeInfo+=addedbirthday+'#';
		  var addedsex=doc.getElementById("sex_info").value;
		 completeInfo+=addedsex+'#';
		  var addedhometown=doc.getElementById("hometown_info").value;
		 completeInfo+=addedhometown+'#';
		  var addedtele=doc.getElementById("tele_info").value;
		 completeInfo+=addedtele+'#';
	     var addedpopulation=doc.getElementById("population_info").value;
	     completeInfo+=addedpopulation+'#';  
	  
	     document.getElementById("addDoneDiv").style.display=""; 
	     var tip='document.getElementById("addDoneDiv").style.display="none";'
	     setTimeout(tip,2000); 
	     doc.getElementsByName("addSolve")[0].value=completeInfo;
	     var addForm=doc.forms("transForm");   
	     addForm.action="../servlet/Owner1_Insert";
	     addForm.submit(); 
	     closeAdd();    
	 }
	 else
	 {
	    closeAdd();
	 }
}
//确认编辑的修改
function editSured(){ 
   
   	var isSureEdited=confirm('确定要修改吗？');
    if(isSureEdited==true)
    {
    	var updatedownernum=doc.getElementById("showownernum").value;
	   var updatedname=doc.getElementById("showname").value;
	   var updatedidnum=doc.getElementById("showidnum").value;
	   var updatedbirthday=doc.getElementById("showbirthday").value;
	   var updatedsex=doc.getElementById("showsex").value;
	   var updatedhometown=doc.getElementById("showhometown").value;
	   var updatedtele=doc.getElementById("showtele").value;
	   var updatedpopulation=doc.getElementById("showpopulation").value;

	   
	   doc.getElementsByName("ownernumvalue")[0].value=updatedownernum;
	   doc.getElementsByName("namevalue")[0].value=updatedname;
	   doc.getElementsByName("idnumvalue")[0].value=updatedidnum;
	   doc.getElementsByName("birthdayvalue")[0].value=updatedbirthday;
	   doc.getElementsByName("sexvalue")[0].value=updatedsex;
	   doc.getElementsByName("hometownvalue")[0].value=updatedhometown;
	   doc.getElementsByName("televalue")[0].value=updatedtele;
	   doc.getElementsByName("populationvalue")[0].value=updatedpopulation;
	   document.getElementById("updateDoneDiv").style.display="";
	   var tip='document.getElementById("updateDoneDiv").style.display="none";'
	   setTimeout(tip,2000); 
	   var form=doc.forms("transform");  //对应第一个table form
	   form.action="../servlet/Owner1_Update";
	   form.submit();
	   closeLogin();
   }
   else
   	   closeLogin();
}
//删除单个项目 2015.7.13
function delSingleItem(delId){ 
      
    var isSureDeled=confirm('确定要要删除这条信息吗？');
    if(isSureDeled){
	    var examKey=doc.getElementById("ownernum"+delId).innerHTML;    	  
	    doc.getElementsByName("delSolve")[0].value=examKey+'#';//获取key值    	   
	    for (i=1;i<ownertable.rows.length;i++){//排序
	        ownertable.rows[i].cells[1].innerHTML=i;
	    }  //for
	      //submit
	    var form=doc.forms("transForm");       
	    form.action="../servlet/Owner1_Delete";
	    form.submit();   
    }//if         
}
//批量删除函数 2015.7.13
function delBatItems(){
	

   var batBox=doc.getElementsByName("checkbox"); 
   var len=batBox.length;
   var rowIndex;
   var allKey="";

   for(i=0;i<len;i++)
   {
	    if(batBox[i].checked==true)
	    {   
	        var Key = doc.getElementById("ownernum"+i).innerHTML;
	        allKey+=Key+'#';
	    }  
   } 
   doc.getElementsByName("delSolve")[0].value=allKey;
   var keyform=doc.forms("transForm");   
   keyform.action="../servlet/Owner1_Delete";
   keyform.submit();  
}
//弹出添加窗口 2015.7.14
function addItem(){
   doc.getElementById("addwin").style.display="";
}
</script>


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
	
	if (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
		return
	if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
		//source.style.backgroundColor=originalcolor
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor="";
	}
}

function  clickto(){
	source=event.srcElement;
	if(source.tagName=="TR"||source.tagName=="TABLE")
		return;
	while(source.tagName!="TD")
	source=source.parentElement;
	source=source.parentElement;
	cs  =  source.children;
	//alert(cs.length);
	if(cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor=clickcolor;
		}
	else
		for(i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
}
//全选功能  2015.7.12
var isSelected=1;
function clickall(){
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
<!----------------------修改由此开始 ------------------------->
<style type="text/css">
table.gridtable {
	margin: auto;
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-color: #999999;
	border-collapse: collapse;
}
table.gridtable td {
	background: #b5cfd2 url('<%=basePath%>/images/tab_05.gif');
	border-width: 1px;
	border: 1px;
	padding: 3px;
	border-style: solid;
	border-color: #999999;
}
table.gridtable td.tdbtn input {
	color: #d9eef7;
	border: solid 1px #0076a3;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5) );
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	filter: progid :   DXImageTransform.Microsoft.gradient (   startColorstr
		= 
		 '#00adee', endColorstr =   '#0078a5' );
}
table.gridtable td.tdbtn input:hover {
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e) );
	background: -moz-linear-gradient(top, #0095cc, #00678e);
	filter: progid :   DXImageTransform.Microsoft.gradient (   startColorstr
		= 
		 '#0095cc', endColorstr =   '#00678e' );
}
table.gridtable td.tdbtn input:active {
	color: #80bed6;
	background: -webkit-gradient(linear, left top, left bottom, from(#0078a5),
		to(#00adee) );
	background: -moz-linear-gradient(top, #0078a5, #00adee);
	filter: progid :   DXImageTransform.Microsoft.gradient (   startColorstr
		= 
		 '#0078a5', endColorstr =   '#00adee' );
}
table.gridtable select {
	WIDTH: 150px； position :   relative;
	left: -2px;
	top: -2px;
	font-size: 12px;
	line-height: 14px;
	border: 1px;
	color: #909993;
}
table.gridtable input[type=text] {
	border: 2px solid #F4F5F3;
	width: 150px;
	font-size: 16px;
	font-weight: bold;
	left: -2px;
	top: -2px;
	line-height: 14px;
	height: 14px;
}
.box1 {
	background: url('<%=basePath%>/images/tab_05.gif');
	height: 20px;
}
</style>

<style>
.optbtn {
	background-color: transparent; /* 背景色透明 */
	border: 0px; /* 边框取消 */
	border-bottom: 1px solid #005aa7; /* 下划线效果 */
}
::-moz-focus-inner {
	border: 0px;
}
</style>
</head>


<body>
<!-- 隐藏域  2015.7.13-->
<form name="transForm" method="post" action="">
	<input type="hidden" name="delSolve" value=""/>
	<input type="hidden" name="addSolve" value=""/>
	<input type="hidden" name="ownernumvalue" value=""/>
	<input type="hidden" name="namevalue" value=""/>
	<input type="hidden" name="idnumvalue" value=""/>
	<input type="hidden" name="birthdayvalue" value=""/>   
	<input type="hidden" name="sexvalue" value=""/>   
	<input type="hidden" name="hometownvalue" value=""/>   
	<input type="hidden" name="televalue" value=""/>   
	<input type="hidden" name="populationvalue" value=""/>        
	
</form>
<!-- 隐藏域 end -->

<div class="box1">&nbsp;
	<font size="2">你当前的位置:</font>
	<font color="blue" size=2pt><%=session.getAttribute("Present_Location")%><br /> <br /> </font>
</div>
<br>
<form action="../servlet/Owner1_Select" method="post">

<table  class="gridtable" width="98%" border="0" cellspacing="0" cellpadding="0">


<tr>
	<td width="50%">
	<font size=2>&nbsp;&nbsp;产权人姓名:</font>
	<input type="text" id="owner_name" name="owner_name"></input>
	</td>
	
	<td width="50%">
	<font size=2>&nbsp;&nbsp;性别:</font>
	<input type="text" id="owner_sex" name="owner_sex"></input>
	</td>
	
</tr>

<tr>
  <td colspan="3"  align="right" class="tdbtn">
            <input type="submit" id="btnAdd" value="查询" class="buttonadd"></input>
  			<input type="button" id="btnAdd" value="增加" class="buttonadd" onclick="addItem()"></input>
  			<input type="button" id="btnAdd" value="删除" class="buttonadd" onclick="delBatItems()"></input>
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
										onmouseout="changeback()" id="ownertable">
										<tr>
											<td width="5%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<input type="checkbox" name="checkbox" value="checkbox"
														onclick="clickall()" />
													<span class="STYLE1">全选</span>
												</div>
											</td>
											<td width="3%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">序号</span>
												</div>
											</td>
											<td width="8%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">产权人编号</span>
												</div>
											</td>
											<td width="6%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">姓名</span>
												</div>
											</td>
											<td width="15%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">身份证号</span>
												</div>
											</td>
											<td width="10%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">出生日期</span>
												</div>
											</td>
											<td width="5%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">性别</span>
												</div>
											</td>
											<td width="10%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">籍贯</span>
												</div>
											</td>
											<td width="10%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">联系方式</span>
												</div>
											</td>
											<td width="8%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">家庭常住人口数</span>
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
										<c:forEach items="${owner1}" var="owner1">
											<tr>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<input type="checkbox" name="checkbox" value="checkbox" />
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF" align="center">
												<span class="STYLE1"><%=order%>											
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center" class="STYLE1">
														<span id="ownernum<%=order %>">${owner1.owner_num}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center" class="STYLE1">
														<span id="ownername<%=order %>">${owner1.owner_name}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="idnum<%=order %>">${owner1.id_num}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center" id="floortip">
														<span class="STYLE1" id="birthday<%=order %>">${owner1.birthday}
														</span>
													</div>
												</td>
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="ownersex<%=order %>">${owner1.owner_sex}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="hometown<%=order %>">${owner1.hometown}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="tele<%=order %>">${owner1.tele}</span>
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="population<%=order %>">${owner1.population}</span>
													</div>
												</td>

												<td height="20" bgcolor="#FFFFFF" align="center">
													<img src="<%=basePath%>/images/edt.gif" />
													<button type="button" name="btnedit" id="btnedit"
														class="optbtn" onclick="openEdit(<%=order %>)">
														编辑
													</button>
													<img src="<%=basePath%>/images/del.gif" />
													<button type="button" name="btndel" id="btndel"
														class="optbtn" onclick="delSingleItem(<%=order++%>)">
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
												&nbsp;&nbsp;共有<%=session.getAttribute("pageCount")%>条记录，当前第 <%=session.getAttribute("currentPage")%>/<%=(Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)%>页
											</td>
											<td>
												<table border="0" align="right" cellpadding="0" cellspacing="0">					  
													<tr>
														<td width="40">	
														<div align="center">
														<%
														      if(((Integer)session.getAttribute("currentPage")).intValue()!=0){												    	   
														    	  out.print("<a href=\"../servlet/Owner1?jump_type=first\">");
														      }												    
														%>										
														<img src="<%=basePath%>/images/first.gif" width="37" height="15"/></a></div>
														</td>
														
														<td width="45">													    
														    <div align="center">
														    <%
														        if(((Integer)session.getAttribute("currentPage")).intValue()>=2){												    	   
														    	    out.print("<a href=\"../servlet/Owner1?jump_type=back\">");
														    	}												    
														    %>														  
														    <img src="<%=basePath%>/images/back.gif" width="43" height="15" /></a></div>								
														</td>
														
														<td width="45">
														    <div align="center">
														   	<%
														     if(((Integer)session.getAttribute("currentPage")).intValue()<((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0))){							    	    
														    	 out.print("<a href=\"../servlet/Owner1?jump_type=next\">");
														     }									  											    
														    %>													  													   	
															<img src="<%=basePath%>/images/next.gif" width="43" height="15" /></a></div>								
														</td>
																					
														<td width="40"><div align="center">
														<%
														     if(((Integer)session.getAttribute("currentPage")).intValue()!=0){												    	   
														    	 out.print("<a href=\"../servlet/Owner1?jump_type=last\">");
														     }												    
														%>										
														<img src="<%=basePath%>/images/last.gif" width="37" height="15" /></a></div>																							
														</td>
												
														<td width="100">
															<div align="center">
																<span class="STYLE1">转到第 <input name="textfield" id="jump_to"
																		type="text" size="4"
																		style="height: 12px; width: 20px; border: 1px solid #999999;" />
																	页 </span>
															</div>
														</td>
														<td width="40">
															<div align="center"><a href="javascript:jumpTo()" onclick="jumpTo()"><img src="<%=basePath%>/images/go.gif" width="37" height="15" /></a></div>
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

