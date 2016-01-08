<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/" +"tab/";
%>
<% long order = 1;
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
.winspan {
 background-color:#bbcc00; 
 width:150px;
 text-alien:left;
 display:-moz-inline-box; 
 display:inline-block;
 }
</style>

<div id=win style="display: none; position: absolute; left: 50%; top: 40%; width: 370px; height: 320px; margin-left: -300px; margin-top: -200px; border: 1px solid #888; background-color: gray; text-align: center;">
     <a href="javascript:closeLogin();" alien="right" ; class="close">关闭</a>
     <br>
     <span>编辑停车场信息</span><br><br><br>
     <span>&nbsp;&nbsp;停车场编号:</span><span id="showpid" class="winspan"></span><br><br>
     <span>&nbsp;&nbsp;停车场名称:</span><input id="showpname"></input><br><br>
     <span>&nbsp;&nbsp;停车场位置:</span><input id="showloc"></input><br><br>   
     <span>最大停车容量:</span><input id="showmax"></input> <br> <br>
     <span>&nbsp;&nbsp;停车场费用:</span><input id="showcharge"></input><br><br>
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
	<label>添加停车场信息</label><br></br>
	<label>&nbsp;&nbsp;停车场编号:</label><input id="pidInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;停车场名称:</label><input id="lotnameInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;停车场位置:</label><input id="locInfo" type="text" style="width:200px"></input><br></br>
	<label>最大停车容量:</label><input id="maxInfo" type="text" style="width:200px"></input><br></br>
	<label>&nbsp;&nbsp;停车场费用:</label><input id="chargeInfo" type="text" style="width:200px"></input><br></br>
	<input type="submit" id="addSure" style="position: absolute; left: 45%; top: 85%;" value="确定" onclick="addSured()"></input>
</div>

<!--------------------------------JavaScript函数-------------------------------->
<script>		
var selectedId;//被选中的item
var doc=document;

//在表格上跳转到第X页
function jumpTo(){

	 var temp=document.getElementById('jump_to').value;
	 var count = <%=(Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0)%>
	 if(temp<=count&&temp>0)
	  	window.location.href="../servlet/Parking1?jump_type=jump_to&to_page="+temp;
}
function closeLogin(){   
    document.getElementById("win").style.display="none";
}
//关闭添加记录窗口 2015.7.14
function closeAdd(){   
	document.getElementById("addwin").style.display="none";
}

function openEdit(id){  	
	var parklot_num=doc.getElementById("parklot_num"+id).innerHTML;
	var parklot_name=doc.getElementById("parklot_name"+id).innerHTML;
	var location=doc.getElementById("location"+id).innerHTML;
	var maxinum=doc.getElementById("maxinum"+id).innerHTML;
	var charge=doc.getElementById("charge"+id).innerHTML;
	doc.getElementById("showpid").innerHTML=parklot_num;
	doc.getElementById("showpname").value=parklot_name;
	doc.getElementById("showloc").value=location;
	doc.getElementById("showmax").value=maxinum;
	doc.getElementById("showcharge").value=charge;
	doc.getElementById("win").style.display="";
	selectedId=id;
}
//确认编辑的修改
function editSured(){ 
   	var isSureEdited=confirm('确定要修改吗？');
    if(isSureEdited==true)
    {  
   
		var Pid=doc.getElementById("showpid").innerHTML;
	    var updatedParklot_name=doc.getElementById("showpname").value;
	    var updatedLocation=doc.getElementById("showloc").value;
	    var updatedMaxinum=doc.getElementById("showmax").value;
		var updatedCharge=doc.getElementById("showcharge").value;
	    doc.getElementsByName("pidvalue")[0].value=Pid;
	    doc.getElementsByName("lotnamevalue")[0].value=updatedParklot_name;
	    doc.getElementsByName("locvalue")[0].value=updatedLocation;
	    doc.getElementsByName("maxvalue")[0].value=updatedMaxinum;
	    doc.getElementsByName("chargevalue")[0].value=updatedCharge;
	    
	    document.getElementById("updateDoneDiv").style.display="";
	    setTimeout(submit,500); //一秒跳转
	    closeLogin();
   }
   else
   	    closeLogin();
}
function submit(){
 	var form=doc.forms("transform");  //对应第一个table form
   	form.action="../servlet/Parking1_Update";
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
		var Pid=doc.getElementById("pidInfo").value;
		var LotnameInfo=doc.getElementById("lotnameInfo").value;
		var Loc=doc.getElementById("locInfo").value;
		var Max=doc.getElementById("maxInfo").value;
		var Charge=doc.getElementById("chargeInfo").value;
	    completeInfo=Pid+"#"+LotnameInfo+"#"+Loc+"#"+Max+"#"+Charge+"#";    
	    if(Pid==0||lotnameInfo==0||Loc==0||Max==0||Charge==0)
	    {
	    alert("信息不完整！");
	    return;
	    }
	    document.getElementById("addDoneDiv").style.display=""; 
	    var tip='document.getElementById("addDoneDiv").style.display="none"';
	    setTimeout(tip,2000); 
	    doc.getElementsByName("addSolve")[0].value=completeInfo;
	    var addForm=doc.forms("transForm");   
	    addForm.action="../servlet/Parking1_Insert";
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
	    var lotKey=doc.getElementById("parklot_num"+delId).innerHTML;  	  
	    doc.getElementsByName("delSolve")[0].value=lotKey+'#';//获取房间key值    	   
	    for (i=1;i<parkInfoTable.rows.length;i++){//排序
	        parkInfoTable.rows[i].cells[1].innerHTML=i;
	    }  //for
	      //submit
	    var form=doc.forms("transForm");       
	    form.action="../servlet/Parking1_Delete";
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
   keyform.action="../servlet/Parking1_Delete";
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
	
	<input type="hidden" name="pidvalue" value=""/>   
	<input type="hidden" name="lotnamevalue" value=""/>   
	<input type="hidden" name="locvalue" value=""/>   
	<input type="hidden" name="maxvalue" value=""/>   
	<input type="hidden" name="chargevalue" value=""/>  

</form>
<!-- 隐藏域 end -->

<div class="box1">&nbsp;
	<font size="2">你当前的位置:</font>
	<font color="blue" size=2pt>[停车管理]-[停车场管理]<br ></br> </font>
</div>
<br>
 <form action="../servlet/Parking1_Select" method="post" name="queryform">
			<table class="gridtable" width="98%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td>
							<font size=2>&nbsp;&nbsp;停车场序号:</font>
							<input id="parklot_num" name="parklot_num" type="text"
							value=<%if(session.getAttribute("parklot_num_tran")!=null) 
							out.print(session.getAttribute("parklot_num_tran"));session.setAttribute("parklot_num_tran","");%>
							></input>
						</td>
					   <td>
							<font size=2>&nbsp;&nbsp;停车场名称:</font>
                            <input id="parklot_name" name="parklot_name" type="text"
                            value=<%if(session.getAttribute("parklot_name_tran")!=null) 
							out.print(session.getAttribute("parklot_name_tran"));session.setAttribute("parklot_name_tran","");%>
                            
                            ></input>
						</td>
						
					</tr>
					<tr>
						<td>
							<font size=2>&nbsp;&nbsp;停车场位置:</font>
							<input id="location" name="location" type="text"
							value=<%if(session.getAttribute("location_tran")!=null) 
							out.print(session.getAttribute("location_tran"));session.setAttribute("location_tran","");%>
							></input>
						</td>
						<td>
							<font size=2>&nbsp;&nbsp;停车场费用:</font>
							<input id="charge" name="charge" type="text"
							value=<%if(session.getAttribute("charge_tran")!=null) 
							out.print(session.getAttribute("charge_tran"));session.setAttribute("charge_tran","");%>						
							></input>
						</td>
						
					</tr>					
				
					<tr>
						<td colspan="3" align="right" class="tdbtn">
							<input type="submit" id="btnQuery" value="查询" class="buttonadd"></input>
							<input type="button" id="btnAdd" value="增加" class="buttonadd" onclick="addItem()"></input>
							<input type="button" id="btnDel" value="删除" class="buttonadd" onclick="delBatItems()"></input>
							<input type="button" id="btnSet" value="重置" class="buttonadd" onclick="resetAll()"></input>
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
										onmouseout="changeback()" id="parkInfoTable">
										<tr>
											<td width="6%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<input type="checkbox" name="checkbox" value="checkbox"
												onclick="clickall()" />
													<span class="STYLE1">全选</span>
                                                 </div>
											</td>
											<td width="2%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">序号</span>
												</div>
											</td>
											<td width="10%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">停车场编号</span>
												</div>
											</td>
											<td width="23%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 停车场名称</span>
												</div>
											</td>
											<td width="24%" height="20" background="<%=basePath%>/images/bg.gif"
												bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1"> 停车场位置</span>
												</div>
											</td>
											<td width="8%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">最大停车容量</span>
												</div>
											</td>
											<td width="12%" background="<%=basePath%>/images/bg.gif" bgcolor="#FFFFFF">
												<div align="center">
													<span class="STYLE1">停车场费用(元)</span>
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
							<c:forEach items="${park_list}" var="p">
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
													<div align="center">
														<span class="STYLE1" id="parklot_num<%=order%>">${p.parklot_num}</span>														
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="parklot_name<%=order%>">${p.parklot_name}</span>														
													</div>
												</td>
												<td bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="location<%=order%>">${p.location}</span>												
													</div>
												</td>
												<td height="20" bgcolor="#FFFFFF">
													<div align="center">
														<span class="STYLE1" id="maxinum<%=order%>">${p.maxinum}</span>												   
													</div>
												</td>																							
								                <td height="20" bgcolor="#FFFFFF" >
												  <div align="center">
														<span class="STYLE1" id="charge<%=order%>">${p.charge}</span>												   
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
														    <div align="center"><a href="../servlet/Parking1?jump_type=first"><img src="<%=basePath%>/images/first.gif" width="37" height="15"/></a></div></td>
														</td>
														
														<td width="45">													    
														    <div align="center">
														    <%
														        if(((Integer)session.getAttribute("currentPage")).intValue()>=2){												    	   
														    	    out.print("<a href=\"../servlet/Parking1?jump_type=back\">");
														    	}												    
														    %>														  
														    <img src="<%=basePath%>/images/back.gif" width="43" height="15" /></a></div>								
														</td>
														
														<td width="45">
														    <div align="center">
														   	<%
														     if(((Integer)session.getAttribute("currentPage")).intValue()<((Integer)session.getAttribute("pageCount")/15+((Integer)session.getAttribute("pageCount")%15!=0?1:0))){							    	    
														    	 out.print("<a href=\"../servlet/Parking1?jump_type=next\">");
														     }									  											    
														    %>													  													   	
															<img src="<%=basePath%>/images/next.gif" width="43" height="15" /></a></div>								
														</td>
																					
														<td width="40"><div align="center"><a href="../servlet/Parking1?jump_type=last"><img src="<%=basePath%>/images/last.gif" width="37" height="15" /></a></div>																							
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

