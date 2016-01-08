<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>

<style type="text/css">
<!--
a{text-decoration:none;color:black;}
a:hover{color:blue;}
-->
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #ffffff;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>

<%
	session.setAttribute("currentPage",1);
	session.setAttribute("pageCount",0);
%>
<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="28" background="images/left_bar.jpg"><table width="165" border="0" cellspacing="0" cellpadding="0" height="22">
      <tr>
        <td width="100%" height="20"><span class="STYLE1" color="#ffffff"><b><font color="#ffffff" size=4>&nbsp;『管理菜单』</font></span></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td valign="top"><table width="165" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                <td width="82%" class="STYLE1">1-房产管理模块<br></td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu1" >
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>               
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Building1?jump_type=first&init=1" target="center_right">房间信息管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>                    
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Building2?jump_type=first&init=1" target="center_right">楼宇信息管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>            
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Building3?jump_type=first&init=1" target="center_right">房屋交接管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>                 
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Building4?jump_type=first&init=1" target="center_right">装修信息管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Building5?jump_type=first&init=1" target="center_right">综合信息管理</a></span></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="5"></td>
              </tr>
            </table></div></td>
          </tr>
          
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu2" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(2)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">2-收费管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu2" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <%                                
                            	   session.setAttribute("char_com_name","0");
                            	   session.setAttribute("char_build_num","0");
                           	   	   session.setAttribute("char_unit_num","0");
                           	       session.setAttribute("char_room_num","0");
                            	   session.setAttribute("charge_num","");
                            	   session.setAttribute("charge_type","0");                       
                          	    %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Charge1?jump_type=first" target="center_right">收费记录</span></td>
                              </tr>
                          </table></td>
                        </tr>       
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              	<% 
                              	  session.setAttribute("char3_com_name","0");
                            	  session.setAttribute("char3_build_num","0");
                           		  session.setAttribute("char3_unit_num","0");
                           		  session.setAttribute("char3_room_num","0");
                            	  session.setAttribute("char3_charge_num","");
                            	  session.setAttribute("char3_charge_type","0");	
                            	%>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Charge2?jump_type=first" target="center_right">统计报表</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <% 
                              	  session.setAttribute("char4_com_name","0");
                            	  session.setAttribute("char4_build_num","0");
                           		  session.setAttribute("char4_unit_num","0");
                           		  session.setAttribute("char4_room_num","0");
                            	  session.setAttribute("char4_type","0");
                            	%>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Charge3?jump_type=first" target="center_right">费用结算</span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table>          </td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu3" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(3)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">3-办公管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu3" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                   	 <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                    		<tr>
                    		<td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  			  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                   		    <tr>
                   		    <%                                
                            	 session.setAttribute("department","0");
                            	 session.setAttribute("office_num","");
          					%>
                     	     <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Office1?jump_type=first" target="center_right">部门信息管理</span></td>
                     	   </tr>
                    	</table></td>
                  </tr>
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                           <%                                
                            	session.setAttribute("staff_num","");
                            	session.setAttribute("staff_name","");
                            	session.setAttribute("salary1","");
                            	session.setAttribute("salary2","");
                            	session.setAttribute("department","0");
          					%>
                          <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Office2?jump_type=first" target="center_right">员工信息管理</span></td>
                        </tr>
                    </table></td>
                  </tr>
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                            		session.setAttribute("staff_num","");
                            		session.setAttribute("staff_name","");
          					   %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Office3?jump_type=first" target="center_right">薪资变更记录</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                            		session.setAttribute("train_num","");
                            		session.setAttribute("train_date","");
          					   %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Office4?jump_type=first" target="center_right">培训记录</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
                            		session.setAttribute("staff_num","");
                            		session.setAttribute("exam_name","");
          				      %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Office5?jump_type=first" target="center_right">考核记录</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                            		session.setAttribute("plan_num","");
                            		session.setAttribute("start_time","");
									session.setAttribute("end_time","");
									session.setAttribute("plan_state","");
          					   %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Office6?jump_type=first" target="center_right">工作计划</span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu4" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(4)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">4-文档管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu4" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <%
                               session.setAttribute("doc_num","0");
                               session.setAttribute("upload_person","");
                               session.setAttribute("doc_title","");
                               session.setAttribute("start_time","");
                               session.setAttribute("end_time","");
                               %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Document1?jump_type=first" target="center_right">文档模板管理</span></td>            
                              </tr>                      
                             
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu5" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(5)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">5-停车管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu5" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
	                             session.setAttribute("parklot_num","0");
	                             session.setAttribute("parklot_name","");
	                             session.setAttribute("location","");
	                             session.setAttribute("charge","0");   
                              %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Parking1?jump_type=first" target="center_right">停车场管理</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
	                             session.setAttribute("parking_num","0");
	                             session.setAttribute("state","-1");
                               %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Parking2?jump_type=first" target="center_right">停车位管理</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
	                             session.setAttribute("record_num","0");	                       
	                             session.setAttribute("car_owner","");
	                             session.setAttribute("start_time","");	                            
                               %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Parking3?jump_type=first" target="center_right">租赁信息管理</span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu6" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(6)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">6-产权人管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu6" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              	 <%                                
                            		session.setAttribute("owner_name","");
                            		session.setAttribute("owner_sex","");
          					   %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Owner1?jump_type=first" target="center_right">产权人信息</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                            		session.setAttribute("prpc_num","");
                            		session.setAttribute("meeting_date","");
          						%>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Owner2?jump_type=first" target="center_right">产权人代表大会</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                            		session.setAttribute("comm_num","");
                            		session.setAttribute("name","");
          						%>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Owner3?jump_type=first" target="center_right">产权人委员会</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                            		session.setAttribute("com_num","");
                            		session.setAttribute("meet_date","");
          						%>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Owner4?jump_type=first" target="center_right">产权人委员会会议</span></td>
                              </tr>
                          </table></td>
                        </tr>
                       
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu7" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(7)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">7-保洁管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu7" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
                           		session.setAttribute("cleaner_num","");
                            	session.setAttribute("name","");
                            	session.setAttribute("position","0");
                            	session.setAttribute("work_range","0");            
                              %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Clean1?jump_type=first" target="center_right">保洁信息管理</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
                           		session.setAttribute("cleaner_num","0");
                            	session.setAttribute("work_content","");
                            	session.setAttribute("tools","");
                            	session.setAttribute("work_time","");
                             %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Clean2?jump_type=first" target="center_right">日常保洁记录</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                             <%                                
                           		session.setAttribute("check_num","");
                            	session.setAttribute("checktype","0");
                             %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Clean3?jump_type=first" target="center_right">工作检查统计</span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu8" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(8)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">8-安保管理模块<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu8" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
                                session.setAttribute("cleaner_num","");
                                session.setAttribute("name","");
                                session.setAttribute("position","0");
                                session.setAttribute("work_range","0");
                             %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Security1?jump_type=first" target="center_right">保安信息管理</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
                                 session.setAttribute("cleaner_num","0");
                                 session.setAttribute("work_content","");
                                 session.setAttribute("tools","");
                                 session.setAttribute("work_time","");         
                              %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Security2?jump_type=first" target="center_right">日常安保记录</span></td>
                              </tr>
                          </table></td>
                        </tr>
                        <tr>
                          <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                               <%                                
                                session.setAttribute("check_num","");
                                session.setAttribute("checktype","0");
                                session.setAttribute("currentPage",1);
                              %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/Security3?jump_type=first" target="center_right">工作检查统计</span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="images/left_bar.jpg" id="imgmenu9" class="menu_title" onmouseover="this.className='menu_title2';" onclick="showsubmenu(9)" onmouseout="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td width="18%">&nbsp;<image src="images/edit.gif"></image>&nbsp;</td>
                  <td width="82%" class="STYLE1">9-系统维护<br></td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td  id="submenu9" style="DISPLAY: none"><div class="sec_menu" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                          <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                              <%                                
                                session.setAttribute("datebegin","");
                                session.setAttribute("dateend","");
                              %>
                                <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='0';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3"><a href="servlet/System1?jump_type=first" target="center_right">数据库管理</span></td>
                              </tr>
                          </table></td>
                        </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td height="5"></td>
                  </tr>
                </table>
            </div></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="18" background="images/main_58.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="18" valign="bottom" background="images/left_bar.jpg"><div align="center" class="STYLE3"><font color="#ffffff">版本：2015V1.0</font></div></td>
      </tr>
    </table></td>
  </tr>
</table>
<script>




function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
	eval("submenu" + 1 + ".style.display=\"none\";");
	eval("submenu" + 2 + ".style.display=\"none\";");
	eval("submenu" + 3 + ".style.display=\"none\";");
	eval("submenu" + 4 + ".style.display=\"none\";");
	eval("submenu" + 5 + ".style.display=\"none\";");
	eval("submenu" + 6 + ".style.display=\"none\";");
	eval("submenu" + 7 + ".style.display=\"none\";");
	eval("submenu" + 8 + ".style.display=\"none\";");
	eval("submenu" + 9 + ".style.display=\"none\";");
	eval("submenu" + sid + ".style.display=\"\";");
	imgmenu.background=background="images/left_bar.jpg";
}
else
{
	eval("submenu" + sid + ".style.display=\"none\";");
	imgmenu.background=background="images/left_bar.jpg";
}
}

</script>