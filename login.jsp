<%-- 
    Document   : User Login Page
    Created on : Dec 15, 2010, 1:16:49 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="css/css.css" >
        
        <style type="text/css">
<!--
#apDiv2 {
	position:absolute;
	left:4px;
	top:187px;
	width:149px;
	height:39px;
	z-index:1;
}
#apDiv3 {
	position:absolute;
	left:5px;
	top:247px;
	width:191px;
	height:48px;
	z-index:2;
}
#apDiv4 {
	position:absolute;
	left:6px;
	top:575px;
	width:186px;
	height:45px;
	z-index:3;
}
#apDiv5 {
	position:absolute;
	left:5px;
	top:505px;
	width:193px;
	height:40px;
	z-index:4;
}
#apDiv6 {
	position:absolute;
	left:5px;
	top:378px;
	width:178px;
	height:39px;
	z-index:5;
}
#apDiv7 {
	position:absolute;
	left:4px;
	top:443px;
	width:176px;
	height:39px;
	z-index:6;
}
#apDiv8 {
	position:absolute;
	left:5px;
	top:308px;
	width:140px;
	height:46px;
	z-index:7;
}
.style4 {font-size: 15px}
-->
        </style>
</head>
    <body>
        <%--
         Dynamic Links in from struts html tag
        --%>
<div id="apDiv2"><html:link href="/RealtorsPortal/index.jsp">
        <img src="images/buttons/realtorshome.jpg" alt="Home" width="192" height="44"></html:link></div>
<div id="apDiv3"><html:link action="/all_ads">
                <img src="images/buttons/browse.jpg" alt="Browse Properties" width="192" height="44"></html:link></div>
<div id="apDiv4"><html:link href="/RealtorsPortal/aboutus.jsp">
        <img src="images/buttons/about_us.jpg" alt="About Us" width="192" height="44"></html:link></div>
<div id="apDiv5"><html:link href="/RealtorsPortal/faq.jsp">
        <img src="images/buttons/faq.jpg" alt="FAQ" width="192" height="44"></html:link></div>
<div id="apDiv6">
  <html:link action="/LoadRegister">
    <img src="images/buttons/register.jpg" alt="Register" width="192" height="44"></html:link></div>
<div id="apDiv7"><html:link href="/RealtorsPortal/morgagecalc.jsp">
        <img src="images/buttons/mortgage.jpg" alt="Mortgage Calculator" width="192" height="44"></html:link></div>
<div id="apDiv8"><html:link href="/RealtorsPortal/login.jsp">
        <img src="images/buttons/log_in.jpg" alt="Log in" width="192" height="44"></html:link></div>
<div id=WholePage>
	<div id="Container">
      <div id="header_container">
          <div id="Top">
            <div id="Header"> 
              <div align="center"><span class="name"> Realtors Portal</span><br />
                </div>
            </div>
        </div>
      </div>
<div class="name">
	      <div align="center" class="style3">Login Page</div>
      </div>
<div id="Middle">
          <div id="Page">
            <div id="Content">
                <div align="center">
        <html:form action="/login" >
            <%--
            Notification if  a new account is created
            --%>
            <br/><i>${requestScope['accountcreated']}</i>
             <div style="color:red" align="center"><html:errors property="emptyfield"/></div>
            <table border="1" align="center" class="table">
            <tr>
                <td>Username: </td>
                <td><html:text property="username"/></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><html:password property="password"/></td>
            </tr>
            <tr>
                <td align="left"><html:reset/></td>
                <td align="right"><html:submit style="text-align:right"/></td>
            </tr>
           </table>
            <p>&nbsp;</p>
            </html:form>
              </div>
              <p class="Part">&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
            </div>
          </div>
      </div>
	</div>

	<div id="Footer">
      <div class="adress" id="Bottom">
        <div align="center">Copyright Realtors Portal - All Rights Reserved 2010</div>
      </div>
	</div>
</div>
    </body>
</html:html>
