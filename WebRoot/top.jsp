<%@ page language="java" import="java.util.*" pageEncoding="gb18030"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title></title>
<head>
<title>6666</title>

<style type="text/css">
a{text-decoration:none;color:white;}

<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE2 {font-size: 9px}
.STYLE3 {
	color: #033d61;
	font-size: 12px;
}
-->
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="60" style="background-color=#0080aa"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="20"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr width="100%"><br></tr>
          <tr>
            <td width="100" height="15" >&nbsp;</td>
            <td width="505" >&nbsp;<font size ="6" color = "#ffffff" face ="隶书"><strong>物业信息管理系统</strong></font></td>
            <td align="right">
            <script language=JavaScript>
				today=new Date();
				function initArray()
					{
						this.length=initArray.arguments.length;
						for(var i=0;i<this.length;i++)
							this[i+1]=initArray.arguments[i] 
					}
				var d=new  initArray(
				"星期日",
				"星期一",
				"星期二",
				"星期三",
				"星期四",
				"星期五",
				"星期六");
				document.write(
				"<font color=#ffffff style='font-size:10pt;font-family: 宋体'> ",
				today.getFullYear(),"年",
				today.getMonth()+1,"月",
				today.getDate(),"日 ",
				d[today.getDay()+1],
				" </font>" ); 
			</script>
            </td>
            <td>&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr height="0">
        <td ><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="270"  >&nbsp;</td>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0" height="15">
              <tr>
                <td width="77%" height="15" valign="bottom"><br></td>
		<td width="100%" valign="bottom"  nowrap="nowrap"><div align="right"><span class="STYLE1"><span class="STYLE2"></span>
			
              </span></div></td>
               <td width="60"><div align="center"><a href="main.jsp" target = "_top" ><img src="images/main_18.gif" width="48" height="17"></a></div></td>
                    <td width="60"><div align="center"><a href="login.jsp" target = "_top" ><img src="images/main_20.gif" width="48" height="17"></a></div></td>
                    <td>&nbsp;</td>
              </tr>
            </table></td>
            
          </tr>
        </table>
      </tr>
      <tr>
        
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="28" background="images/left_bar.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="177" height="28" background="images/left_bar.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="60%" valign="bottom"><div align="center" class="STYLE1"><font color = "FFFFFF">欢迎!当前用户:<b><font color="red" size=4>${usname}</font></div></td>
            <td width="21%">&nbsp;</td> 
          </tr>
         
        </table></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table></td>
        <td width="22"><img src="images/left_bar.jpg" width="100%" height="100%"></td> 
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
