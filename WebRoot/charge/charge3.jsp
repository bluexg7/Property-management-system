<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" +"tab/";
%>
<% long order = 1;
   String room="";
   String floor="";
   String size="";
   String layout="";
   String state="";  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>房间信息管理</title>

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

<div id=win style="display: none; position: absolute; left: 50%; top: 40%; width: 450px; height: 340px; margin-left: -300px; margin-top: -200px; border: 1px solid #888; background-color: gray; text-align: center;">
     <a href="javascript:closeLogin();" alien="right" ; class="close">关闭</a>
     <br>
     <span>物业管理系统</span><br><br><br>
     <span>收费编号:</span><input id="showroom"></input><br><br>
     <span>楼&nbsp;&nbsp;&nbsp;层:</span><input id="showfloor"></input><br><br>
     <span>面&nbsp;&nbsp;&nbsp;积:</span><input id="showsize"></input><br><br>   
     <span>房&nbsp;&nbsp;&nbsp;价:</span><input id="showprice"></input> <br> <br>
     <span>布&nbsp;&nbsp;&nbsp;局:</span><input id="showlayout"></input><br><br>
     <span>售出状态:</span><input id="showstate"></input> <br>
	 <input type="submit" id="editSure" style="position: absolute; left: 45%; top: 90%;" value="确定" onclick="editSured()"></input>
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
<script type="text/javascript" src="../tab/js111/WdatePicker.js"></script>
<div id=addwin style="display: none; position: absolute; left: 50%; top: 40%; width: 420px; height: 400px; margin-left: -300px; margin-top: -200px; 
		border: 1px solid #888; background-color: gray; text-align: center;">
    <a href="javascript:closeAdd();" alien="right" ; class="close">关闭</a><br>
	<label>添加收费信息</label><br></br>
	<label>收费编号：</label><input id="chargNumInfo" type="text" style="width:200px"></input><br></br>
	<label>小区名称：</label><input id="comInfo" type="text" style="width:200px"></input><br></br>
	<label>楼宇编号：</label><input id="buildInfo" type="text" style="width:200px"></input><br></br>
	<label>单元编号：</label><input id="unitInfo" type="text" style="width:200px"></input><br></br>
	<label>房间编号：</label><input id="roomInfo" type="text" style="width:200px"></input><br></br>	
	<label>上次缴费：</label><input id="lasDateInfo" type="text" style="width:200px" onClick="WdatePicker()"></input><br></br>
	<label>截止时间：</label><input id="dateInfo" type="text" style="width:200px" onClick="WdatePicker()"></input><br></br>
	<label>收费金额：</label><input id="amountInfo" type="text" style="width:200px"></input><br></br>
	<label>收费类型：</label><input id="typeInfo" type="text" style="width:200px"></input><br></br>
	<input type="submit" id="addSure" style="position: absolute; left: 45%; top: 90%;" value="确定" onclick="addSured()"></input>
</div>
<!---------------------------------Jquery end 2015.7.12---------------------------->

<!--------------------------------JavaScript函数-------------------------------->
<script>		
var selectedId;//被选中的item
var doc=document;
/*这是房间信息表的,每个信息项的编辑功能的调用函数,可编辑房价和售出状态*/
function openEdit(id){  
   
 
	var room=doc.getElementById("room"+id).innerHTML;
	
	var floor=doc.getElementById("floor"+id).innerHTML;
	var size=doc.getElementById("size"+id).innerHTML;
	var price=doc.getElementById("price"+id).innerHTML;
	var layout=doc.getElementById("layout"+id).innerHTML;
	var isselled=doc.getElementById("selled"+id).innerHTML;
	doc.getElementById("showroom").value=room;
	doc.getElementById("showfloor").value=floor;
	doc.getElementById("showsize").value=size;
	doc.getElementById("showprice").value=price;
	doc.getElementById("showlayout").value=layout;
	doc.getElementById("showstate").value=isselled;
	doc.getElementById("win").style.display="";
	selectedId=id;
}
//在表格上跳转到第X页
function jumpTo(){

	 var temp=document.getElementById('jump_to').value;
	 var count = <%=(Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)%>
	 if(temp<=count && temp>0)
	  	window.location.href="../servlet/Charge3?jump_type=jump_to&to_page="+temp;
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
	 	
	 	 var addedRoom=doc.getElementById("chargNumInfo").value;
		 completeInfo+=addedRoom+'#';
		
		 var addedRoom=doc.getElementById("comInfo").value;
		 completeInfo+=addedRoom+'#';
		 
		  var addedRoom=doc.getElementById("buildInfo").value;
		 completeInfo+=addedRoom+'#';
		  var addedRoom=doc.getElementById("unitInfo").value;
		 completeInfo+=addedRoom+'#';
		  var addedRoom=doc.getElementById("roomInfo").value;
		 completeInfo+=addedRoom+'#';
	     var addedSize=doc.getElementById("lasDateInfo").value;
	     completeInfo+=addedSize+'#';
		 var addedPrice=doc.getElementById("dateInfo").value;
		   completeInfo+=addedPrice+'#';
	     var addedState=doc.getElementById("amountInfo").value;
	     completeInfo+=addedState+'#'; 
	  	 var addedLayout=doc.getElementById("typeInfo").value;
	       completeInfo+=addedLayout+'#';
	      
	     document.getElementById("addDoneDiv").style.display=""; 
	     var tip='document.getElementById("addDoneDiv").style.display="none";'
	     setTimeout(tip,2000); 
	     doc.getElementsByName("addSolve")[0].value=completeInfo;
	     var addForm=doc.forms("transForm");   
	     addForm.action="../servlet/Charge3_Insert";
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
	   var updatedPrice=doc.getElementById("showprice").value;
	   var updatedState=doc.getElementById("showstate").value;
	   var updatedLayout=doc.getElementById("showlayout").value;
	   var updatedSize=doc.getElementById("showsize").value;
	   var updatedFloor=doc.getElementById("showfloor").value;
	   var updatedRoom=doc.getElementById("showroom").value;
	   doc.getElementsByName("roomvalue")[0].value=updatedRoom;
	   doc.getElementsByName("pricevalue")[0].value=updatedPrice;
	   doc.getElementsByName("selledvalue")[0].value=updatedState;
	   doc.getElementsByName("layoutvalue")[0].value=updatedLayout;
	   doc.getElementsByName("sizevalue")[0].value=updatedSize;
	   doc.getElementsByName("floorvalue")[0].value=updatedFloor;
	   document.getElementById("updateDoneDiv").style.display="";
	   var tip='document.getElementById("updateDoneDiv").style.display="none";'
	   setTimeout(tip,2000); 
	   var form=doc.forms("transform");  //对应第一个table form
	   form.action="../servlet/Charge3_Update";
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
	    var roomKey=doc.getElementById("chargeNum"+delId).innerHTML;  	  
	    doc.getElementsByName("delSolve")[0].value=roomKey+'#';//获取收費key值    	   
	    var form=doc.forms("transForm");       
	    form.action="../servlet/Charge3_Delete";
	    form.submit();   
    }//if         
}
//批量删除函数 2015.7.13
function delBatItems(){ 
	var isSureDeled=confirm('确定要要删除这些信息吗？');
	if(isSureDeled){
	 
   var batBox=doc.getElementsByName("checkbox"); 
   
   var len=batBox.length;
   var rowIndex;
   var allKey="";
   for(i=0;i<len;i++)
   {
   		
	    if(batBox[i].checked==true)
	    {   
	        var roomKey = doc.getElementById("chargeNum"+(i)).innerHTML; 
	        allKey+=roomKey+'#';
	    }  
   } 
   doc.getElementsByName("delSolve")[0].value=allKey;
   var keyform=doc.forms("transForm");   
   keyform.action="../servlet/Charge3_Delete";
   keyform.submit(); 
   } 
  
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
	<input type="hidden" name="delSolve" id="delSolve" value=""/>
	<input type="hidden" name="addSolve" value=""/>
	<input type="hidden" name="roomvalue" value=""/>   
	<input type="hidden" name="floorvalue" value=""/>   
	<input type="hidden" name="sizevalue" value=""/>   
	<input type="hidden" name="pricevalue" value=""/>   
	<input type="hidden" name="layoutvalue" value=""/>  
	<input type="hidden" name="selledvalue" value=""/>    
	
</form>
<!-- 隐藏域 end -->

<div class="box1">&nbsp;
	<font size="2" >你当前的位置:</font>
	<font color="blue" size=2pt><%=session.getAttribute("Present_Location")%><br /> <br /> </font>
</div>
<br>
<form action="../servlet/Charge3_Select" method="post" name="queryform">
			<table class="gridtable" width="98%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="20%">
							<font size=2>小区名:</font>
							<select id="char_com_name" name="char_com_name">
								<option value="0">
									--选择小区--
								</option>
								<option value="水云间">
									水云间
								</option>
								<option value="香宇城">
									香宇城
								</option>
								<option value="翌景嘉园">
									翌景嘉园
								</option>
								<option value="藕花深处">
									藕花深处
								</option>
								
							</select>
						</td>
						<td width="20%">
							<font size=2>楼宇号:</font>
							<select id="char_build_num" name="char_build_num">
								<option value="0">
									--选择楼号--
								</option>
								<option value="A01">
									A01
								</option>
								<option value="A02">
									A02
								</option>
								<option value="B01">
									B01
								</option>
								<option value="B02">
									B02
								</option>
								<option value="C01">
									C01
								</option>
								<option value="D01">
									D01
								</option>
							</select>
						</td>
						<td width="20%">
							<font size=2>单 元 号 : </font>
							<select id="char_unit_num" name="char_unit_num">
								<option value="0">
									--选择单元号--
								</option>
								<option value="1单元">
									1单元
								</option>
								<option value="2单元">
									2单元
								</option>
								<option value="3">
									3
								</option>
								<option value="4">
									4
								</option>
								<option value="5">
									5
								</option>
								<option value="6">
									6
								</option>
							</select>
						</td>
						<td width="20%">
							<font size=2>房间号:</font>
							<select id="char_room_num" name="char_room_num">
								<option value="0">
									--选择房间--
								</option>
								<option value="101">
									101
								</option>
								<option value="201">
									201
								</option>
								<option value="102">
									102
								</option>
								<option value="4">
									4
								</option>
								<option value="5">
									5
								</option>
								<option value="6">
									6
								</option>
							</select>
						</td>
						<td width="20%"><font size=2>&nbsp;&nbsp;类型:</font>
							<select id="charge_type" name="charge_type">
								<option value="0">
									--选择状态--
								</option>
								<option value="水费">
									水费
								</option>
								<option value="电费">
									电费
								</option>
								<option value="物业费">
									物业费
								</option>
							</select></td>
						
					</tr>
					
					<tr>
						<td colspan="5" align="right" class="tdbtn">
							<input type="submit" id="btnQuery" value="查询" class="buttonadd"></input>
							<input type="button" id="btnAdd" value="增加" class="buttonadd" onclick="addItem()"></input>
							<input type="button" id="btnDel" value="删除" class="buttonadd" onclick="delBatItems()"></input>
							<input type="reset" id="btnSet" value="重置" class="buttonadd"></input>
						</td>
					</tr>
				</table>
</form>
	<br>
			<!----------------------修改结束 2015.7.11------------------------->

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							<tr>
								<td width="8" background="<%=basePath%>/images/tab_12.gif">&nbsp;
									
								</td>
								<td>							 
									<table width="100%" border="0" cellpadding="0" cellspacing="1"
										bgcolor="b5d6e6" onmouseover="changeto()"
										onmouseout="changeback()" id="roomInfoTable">
										<tr>
											<td width="9%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<input type="checkbox" name="checkbox" value="checkbox"
														onclick="clickall()" />
													<span class="STYLE1">全选</span>
												</div>
											</td>
											<td width="14%" height="22" 22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">序号</span>
												</div>
											</td>
											<td width="24%" height="22" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center"><span class="STYLE1">房间</div>
											</td>
											<td width="20%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center"><span class="STYLE1">类型</div>
											</td>
											<td width="18%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center"><span class="STYLE1">总额</div>
											</td>
										</tr>                                     
										<!-- -循环填表 -->  
										<c:forEach items="${list}" var="charge">
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
													<div align="center" id="floortip">
														<span class="STYLE1" id="comName<%=order%>">${charge.com_name}-${charge.build_num}-${charge.unit_num}-${charge.room_num}</span>
														
													</div>
												</td>
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="cahrgeType<%=order%>">${charge.charge_type}</span>
														
													</div>
												</td>
												<td bgcolor="#FFFFFF">
													<div align="center">
													<span class="STYLE1" id="chargePrice<%=order%>">${charge.charge_price}</span>
													</div>
												</td>
											</tr>
										<%order++;%>
										</c:forEach>

									</table>
							
	              					</td>
								<td width="8" background="<%=basePath%>/images/tab_15.gif">&nbsp;
									
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
														    	  out.print("<a href=\"../servlet/Charge3?jump_type=first\">");
														      }												    
														%>										
														<img src="<%=basePath%>/images/first.gif" width="37" height="15"/></a></div>
														</td>
														
														<td width="45">													    
														    <div align="center">
														    <%
														        if(((Integer)session.getAttribute("currentPage")).intValue()>=2){												    	   
														    	    out.print("<a href=\"../servlet/Charge3?jump_type=back\">");
														    	}												    
														    %>														  
														    <img src="<%=basePath%>/images/back.gif" width="43" height="15" /></a></div>								
														</td>
														
														<td width="45">
														    <div align="center">
														   	<%
														     if(((Integer)session.getAttribute("currentPage")).intValue()<((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0))){							    	    
														    	 out.print("<a href=\"../servlet/Charge3?jump_type=next\">");
														     }									  											    
														    %>													  													   	
															<img src="<%=basePath%>/images/next.gif" width="43" height="15" /></a></div>								
														</td>
																					
														<td width="40"><div align="center">
														<%
														     if(((Integer)session.getAttribute("currentPage")).intValue()!=0){												    	   
														    	 out.print("<a href=\"../servlet/Charge3?jump_type=last\">");
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

