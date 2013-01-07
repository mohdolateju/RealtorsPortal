<%-- 
    Document   : FAQ Page
    Created on : Dec 15, 2010, 1:16:49 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAQ</title>
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
#apDiv9 {
	position:absolute;
	left:1125px;
	top:186px;
	width:178px;
	height:44px;
	z-index:8;
}
-->
        </style>
</head>
    <body>
        <%--
        Dynamic struts html link tags
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
<div id="apDiv8"><%--
        if the user is sign in the log out button is displayed if the user is signed in the  log in button is displayed
        --%>
    <c:if scope="session" test="${empty username}" var="var"><html:link href="/RealtorsPortal/login.jsp">
            <img src="/RealtorsPortal/images/buttons/log_in.jpg" alt="Log in" width="192" height="44"></html:link></c:if>
                 <c:if scope="session" test="${not empty username}" var="var"><html:link action="/logout">
                         <img src="/RealtorsPortal/images/buttons/log_out.jpg" alt="Log in" width="192" height="44"></html:link></c:if></div>
<div id="apDiv9"><%--
        the link to a particular section of the website displayed depending on the users role
        --%>
    <c:if scope="session" test="${role=='privateseller'}" var="var"><html:link action="/privatesellersection">
            <img src="images/buttons/privatesellersection.jpg" alt="Private Seller Section" width="192" height="44"></html:link></c:if>
                  <c:if scope="session" test="${role=='admin'}" var="var"><html:link action="/adminsection">
            <img src="images/buttons/adminsection.jpg" alt="Admin Section" width="192" height="44"></html:link></c:if>
            <c:if scope="session" test="${role=='agent'}" var="var"><html:link action="/agentsection">
            <img src="/RealtorsPortal/images/buttons/agentsection.jpg" alt="Agent Section" width="192" height="44"></html:link></c:if></div>
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
	      <div align="center" class="style3">FAQ</div>
      </div>
<div id="Middle">
          <div id="Page">
            <div id="Content">
              <div class="Part" id="product_2">
                <p><img src="images/faq.png" alt="picture" width="200" height="136" />
                    <strong>Design Team:</strong>  Mohammed.B.Olateju&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;Contact: +2348096856444<br><br>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Kenechukwu.K.Chukwujekwu &nbsp;Contact: +2347061301029</p><br>
                <p><strong>Supervisor:</strong>&nbsp;&nbsp;&nbsp;  Mr. Chima Anago</p>
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
                <p>&nbsp;</p>
              </div>
              <p class="Part">&nbsp;</p>
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
