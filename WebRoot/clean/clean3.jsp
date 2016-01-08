<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" +"tab/";
%>
<% long order = 1;
   String check_num="";
   String checktype="";
   String cleaner_num="";
   String checkcontent="";
   String checkdate="";
   String checker="";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!----------------------2015.7.15------------------------->
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>保洁管理</title>

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
table.gridtable input:active {
	color: #80bed6;
	background: -webkit-gradient(linear, left top, left bottom, from(#0078a5),
		to(#00adee) );
	background: -moz-linear-gradient(top, #0078a5, #00adee);
	filter: progid :   DXImageTransform.Microsoft.gradient (   startColorstr
		= 
		 '#0078a5', endColorstr =   '#00adee' );
}
table.gridtable input {
	WIDTH: 150px； position :   relative;
	left: -2px;
	top: -2px;
	font-size: 14px;
	line-height: 15px;
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
.optbtn {
	background-color: transparent; /* 背景色透明 */
	border: 0px; /* 边框取消 */
	border-bottom: 1px solid #005aa7; /* 下划线效果 */
}
::-moz-focus-inner {
	border: 0px;
}
.selectcss{
	WIDTH: 150px； position :relative;
	left: -2px;
	top: -2px;
	font-size: 12px;
	line-height: 14px;
	border: 1px;
	color: #909993;
}
</style>

<div id=win style="display: none; position: absolute; left: 50%; top: 40%; width: 370px; height: 320px; margin-left: -300px; margin-top: -200px; border: 1px solid #888; background-color: gray; text-align: center;">
     <a href="javascript:closeLogin();" alien="right" ; class="close">关闭</a>
     <br>
     <span>编辑工作检查信息</span><br><br><br>
     <span>&nbsp;&nbsp;检查编号:</span><span id="showcheck_num" class="winspan"></span><br><br>
     <span>&nbsp;&nbsp;检查类型:</span><input id="showchecktype"></input><br><br>
     <span>&nbsp;&nbsp;保洁员编号:</span><input id="showcleaner_num"></input><br><br>   
     <span>&nbsp;&nbsp;检查内容:</span><input id="showcheckcontent"></input><br><br>
     <span>&nbsp;&nbsp;检查日期:</span><input id="showcheckdate"></input><br><br>
     <span>&nbsp;&nbsp;检查人:</span><input id="showchecker"></input><br><br>
	 <input type="submit" id="editSure" style="position: absolute; left: 45%; top: 85%;" value="确定" onclick="editSured()"></input>
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

<div id=addwin style="display: none; position: absolute; left: 50%; top: 40%; width: 370px; height: 320px; margin-left: -300px; margin-top: -200px; 
		border: 1px solid #888; background-color: gray; text-align: center;">
    <a href="javascript:closeAdd();" alien="right" ; class="close">关闭</a><br>
	<label>添加工作检查信息</label><br></br>
	<label>&nbsp;&nbsp;检查编号:</label><input id="check_numInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;检查类型:</label><input id="checktypeInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;保洁员编号:</label><input id="cleaner_numInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;检查内容:</label><input id="checkcontentInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;检查日期:</label><input id="checkdateInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;检查人:</label><input id="checkerInfo" type="text" style="width:200px"></input><br></br>
	<input type="submit" id="addSure" style="position: absolute; left: 45%; top: 85%;" value="确定" onclick="addSured()"></input>
</div>

<!------------------------ Jquery 2015.7.12 
<script type="text/javascript"
src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js">
</script>
-->
<!--------------------------------JavaScript函数-------------------------------->
<script>		
var selectedId;//被选中的item
var doc=document;

//在表格上跳转到第X页
function jumpTo(){

	 var temp=document.getElementById('jump_to').value;
	 var count = <%=(Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)%>
	 if(temp<=count&&temp>0)
	  	window.location.href="../servlet/Clean3?jump_type=jump_to&to_page="+temp;
}
function closeLogin(){   
    document.getElementById("win").style.display="none";
}
//关闭添加记录窗口 2015.7.14
function closeAdd(){   
	document.getElementById("addwin").style.display="none";
}

function openEdit(id){  	
	var check_num=doc.getElementById("check_num"+id).innerHTML;
	var checktype=doc.getElementById("checktype"+id).innerHTML;
	var cleaner_num=doc.getElementById("cleaner_num"+id).innerHTML;
	var checkcontent=doc.getElementById("checkcontent"+id).innerHTML;
	var checkdate=doc.getElementById("checkdate"+id).innerHTML;
	var checker=doc.getElementById("checker"+id).innerHTML;
	doc.getElementById("showcheck_num").innerHTML=parklot_num;
	doc.getElementById("showchecktype").value=parklot_name;
	doc.getElementById("showcleaner_num").value=location;
	doc.getElementById("showcheckcontent").value=maxinum;
	doc.getElementById("showcheckdate").value=charge;
	doc.getElementById("showchecker").value=checker;
	doc.getElementById("win").style.display="";
	selectedId=id;
}
//确认编辑的修改
function editSured(){ 
   	var isSureEdited=confirm('确定要修改吗？');
    if(isSureEdited==true)
    {  
   
		var Check_num=doc.getElementById("showcheck_num").innerHTML;
	    var updatedChecktype=doc.getElementById("showchecktype").value;
	    var updatedCleaner_num=doc.getElementById("showcleaner_num").value;
	    var updatedCheckcontent=doc.getElementById("showcheckcontent").value;
		var updatedCheckdate=doc.getElementById("showcheckdate").value;
		var updatedChecker=doc.getElementById("showchecker").value;
	    doc.getElementsByName("check_numvalue")[0].value=Check_num;
	    doc.getElementsByName("checktypevalue")[0].value=updatedChecktype;
	    doc.getElementsByName("cleaner_numvalue")[0].value=updatedCleaner_num;
	    doc.getElementsByName("checkcontentvalue")[0].value=updatedCheckcontent;
	    doc.getElementsByName("checkdatevalue")[0].value=updatedCheckdate;
	    doc.getElementsByName("checkervalue")[0].value=updatedChecker;
	    
	    document.getElementById("updateDoneDiv").style.display="";
	    setTimeout(submit,500); //一秒跳转
	    closeLogin();
   }
   else
   	    closeLogin();
}
function submit(){
 	var form=doc.forms("transform");  //对应第一个table form
   	form.action="../servlet/Clean3_Update";
    form.submit();
}

//弹出添加窗口 2015.7.16
function addItem(){
   doc.getElementById("addwin").style.display="";
}

//添加记录确认 2015.7.16
function addSured(){  
	 
	 var isSureAdded=confirm('确定要添加这条记录吗？');
	 var completeInfo="";
	 if(isSureAdded==true){
		var Check_num=doc.getElementById("check_numInfo").value;
		var Checktype=doc.getElementById("checktypeInfo").value;
		var Cleaner_num=doc.getElementById("cleaner_numInfo").value;
		var Checkcontent=doc.getElementById("checkcontentInfo").value;
		var Checkdate=doc.getElementById("checkdateInfo").value;
		var Checker=doc.getElementById("checkerInfo").value;
	    completeInfo=Check_num+"#"+Checktype+"#"+Cleaner_num+"#"+Checkcontent+"#"+Checkdate+"#"+Checker+"#";    
	    if(Check_num==0||Checktype==0||Cleaner_num==0||Checkcontent==0||Checkdate==0||Checker==0)
	    {
	    alert("信息不完整！");
	    return;
	    }
	    document.getElementById("addDoneDiv").style.display=""; 
	    var tip='document.getElementById("addDoneDiv").style.display="none"';
	    setTimeout(tip,2000); 
	    doc.getElementsByName("addSolve")[0].value=completeInfo;
	    var addForm=doc.forms("transForm");   
	    addForm.action="../servlet/Clean3_Insert";
	    addForm.submit(); 
	    closeAdd();    
	 }
	 else
	 {
	    closeAdd();
	 }
}

function delSingleItem(delId){ 
      
    var isSureDeled=confirm('确定要删除这条信息吗？');
    if(isSureDeled){
	    var checkKey=doc.getElementById("check_num"+delId).innerHTML;  	  
	    doc.getElementsByName("delSolve")[0].value=checkKey+'#';//获取房间key值    	   
	    for (i=1;i<cleancheckInfoTable.rows.length;i++){//排序
	        cleancheckInfoTable.rows[i].cells[1].innerHTML=i;
	    }  //for
	      //submit
	    var form=doc.forms("transForm");       
	    form.action="../servlet/Clean3_Delete";
	    form.submit();   
    }//if         
}
function resetAll(){
     var e=doc.getElementsByTagName("input");
     for(i=0;i<e.length;i++){
      if(e[i].type=='text')
        e[i].value="";    
     }
    
}
function delBatItems(){ 

   var batBox=doc.getElementsByName("checkbox"); 
   var len=batBox.length;
   var allKey="";
   for(i=0;i<len;i++)
   {
	    if(batBox[i].checked==true)
	    {   
	        var lotKey = doc.getElementById("parklot_num"+i).innerHTML;
	        allKey+=lotKey+'#';
	    }  
   } 
   if(allKey=="#")
   return;
   doc.getElementsByName("delSolve")[0].value=allKey;
   var keyform=doc.forms("transForm");   
   keyform.action="../servlet/Clean3_Delete";
   keyform.submit();  
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

</head>
<body>
<!-- 隐藏域  2015.7.13-->
<form name="transForm" method="post" action="">
	<input type="hidden" name="delSolve" value=""/>
	<input type="hidden" name="addSolve" value=""/>
	
	<input type="hidden" name="check_numvalue" value=""/>   
	<input type="hidden" name="checktypevalue" value=""/>   
	<input type="hidden" name="cleaner_numvalue" value=""/>   
	<input type="hidden" name="checkcontentvalue" value=""/>   
	<input type="hidden" name="checkdatevalue" value=""/>  
	<input type="hidden" name="checkervalue" value=""/>    
	
</form>
<!-- 隐藏域 end -->

<div class="box1">&nbsp;
	<font size="2" >你当前的位置:</font>
	<font color="blue" size=2pt>[保洁管理]-[工作检查统计]<br ></br> </font>
</div>
<br>
 <form action="../servlet/Clean3_Select" method="post" name="queryform">
			<table class="gridtable" width="98%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td>
							<font size=2>&nbsp;&nbsp;检查编号:</font>
							<input id="check_num" name="check_num" type="text"></input>
						</td>
					   
						<td>
						    <font size=2>检查类型:</font>
							<select id="checktype" name="checktype" class="selectcss">
								<option value="0">
									--选择类型--
								</option>
								<option value="日检">
									日检
								</option>
								<option value="周检">
									周检
								</option>
								<option value="月检">
									月检
								</option>
								<option value="年检">
									年检
								</option>			
							</select>						 			
						</td>
						
					</tr>
											
					<tr>
						<td colspan="3" align="right" class="tdbtn">
							<input type="submit" id="btnQuery" value="查询" class="buttonadd"></input>
							<input type="button" id="btnAdd" value="增加" class="buttonadd" onclick="addItem()"></input>
							<input type="button" id="btnDel" value="删除" class="buttonadd" onclick="delBatItems()"></input>
							<input type="reset" id="btnSet" value="重置" class="buttonadd"></input>
						</td>
					</tr>
				</table>
			</form>
		<br>
			<!----------------------修改结束 2015.7.14------------------------->

			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0" >
							<tr>
								<td width="8" background="<%=basePath%>/images/tab_12.gif">&nbsp</td>
								<td>							 
									<table width="100%" border="0" cellpadding="0" cellspacing="1"
										bgcolor="b5d6e6" onmouseover="changeto()"
										onmouseout="changeback()" id="cleancheckInfoTable">
										<tr>
											<td width="6%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<input type="checkbox" name="checkbox" value="checkbox"
												onclick="clickall()" />
													<span class="STYLE1">全选</span>
                                                 </div>
											</td>
											<td width="3%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">序号</span>
												</div>
											</td>
											<td width="10%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">检查编号</span>
												</div>
											</td>
											<td width="10%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 检查类型</span>
												</div>
											</td>
											<td width="10%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 保洁员编号</span>
												</div>
											</td>
											<td width="10%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 检查内容</span>
												</div>
											</td>
											<td width="18%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 检查日期</span>
												</div>
											</td>
											<td width="10%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 检查人</span>
												</div>
											</td>																												
											<td width="20%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF" class="STYLE1">
												<div align="center">
													基本操作
												</div>
											</td>
										</tr>                                     
										<!-- -循环填表 -->  
							<c:forEach items="${cleancheck_list}" var="clean_check">
											<tr>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<input type="checkbox" name="checkbox" value="checkbox" />
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF" align="center">
												 	<div align="center">
														<span class="STYLE1"><%=order%></span>														
													</div>																					
												</td>
								 							   
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="check_num<%=order%>">${clean_check.check_num}</span>														
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="checktype<%=order%>">${clean_check.checktype}</span>														
													</div>
												</td>
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="cleaner_num<%=order%>">${clean_check.cleaner_num}</span>												
													</div>
												</td>	
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="checkcontent<%=order%>">${clean_check.checkcontent}</span>												
													</div>
												</td>		
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="checkdate<%=order%>">${clean_check.checkdate}</span>												
													</div>
												</td>		
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="checker<%=order%>">${clean_check.checker}</span>												
													</div>
												</td>													
												<td height="20" bgcolor="#FFFFFF" align="center">
													<img src="<%=basePath%>/images/edt.gif" />
													<button type="button" name="btnedit" id="btnedit<%=order%>"
														class="optbtn" onclick="openEdit(<%=order%>)">
														编辑
													</button>
													<img src="<%=basePath%>/images/del.gif" />
													<button type="button" name="btndel" id="btndel<%=order%>"
														class="optbtn" onclick="delSingleItem(<%=order++%>)">
														删除
													</button>
												</td>
											</tr>
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
														    <div align="center"><a href="../servlet/Clean3?jump_type=first"><img src="<%=basePath%>/images/first.gif" width="37" height="15"/></a></div></td>
														</td>
														
														<td width="45">													    
														    <div align="center">
														    <%
														        if(((Integer)session.getAttribute("currentPage")).intValue()>=2){												    	   
														    	    out.print("<a href=\"../servlet/Clean3?jump_type=back\">");
														    	}												    
														    %>														  
														    <img src="<%=basePath%>/images/back.gif" width="43" height="15" /></a></div>								
														</td>
														
														<td width="45">
														    <div align="center">
														   	<%
														     if(((Integer)session.getAttribute("currentPage")).intValue()<((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0))){							    	    
														    	 out.print("<a href=\"../servlet/Clean3?jump_type=next\">");
														     }									  											    
														    %>													  													   	
															<img src="<%=basePath%>/images/next.gif" width="43" height="15" /></a></div>								
														</td>
																					
														<td width="40"><div align="center"><a href="../servlet/Clean3?jump_type=last"><img src="<%=basePath%>/images/last.gif" width="37" height="15" /></a></div>																							
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

