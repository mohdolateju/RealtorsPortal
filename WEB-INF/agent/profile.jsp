<%--
    Document   : For Managing Agent Profile
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
        <title>Manage Agent Profile</title>
        <link rel="stylesheet" type="text/css" href="/RealtorsPortal/css/css.css" >

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
	left:1123px;
	top:184px;
	width:150px;
	height:48px;
	z-index:8;
}
#apDiv10 {
	position:absolute;
	left:1123px;
	top:187px;
	width:170px;
	height:36px;
	z-index:9;
}
<!--
#apDiv11 {
	position:absolute;
	left:239px;
	top:212px;
	width:346px;
	height:172px;
	z-index:1;
}
#apDiv12 {
	position:absolute;
	left:673px;
	top:237px;
	width:282px;
	height:117px;
	z-index:1;
}

-->
-->
        </style>
</head>
    <body>
<div id="apDiv2"><html:link href="/RealtorsPortal/index.jsp">
        <img src="/RealtorsPortal/images/buttons/realtorshome.jpg" alt="Home" width="192" height="44"></html:link></div>
<div id="apDiv3"><html:link action="/all_ads">
                <img src="/RealtorsPortal/images/buttons/browse.jpg" alt="Browse Properties" width="192" height="44"></html:link></div>
<div id="apDiv4"><html:link href="/RealtorsPortal/aboutus.jsp">
        <img src="images/buttons/about_us.jpg" alt="About Us" width="192" height="44"></html:link></div>
<div id="apDiv5"><html:link href="/RealtorsPortal/faq.jsp">
        <img src="images/buttons/faq.jpg" alt="FAQ" width="192" height="44"></html:link></div>
<div id="apDiv6">
  <html:link action="/LoadRegister">
    <img src="/RealtorsPortal/images/buttons/register.jpg" alt="Register" width="192" height="44"></html:link></div>
<div id="apDiv7"><html:link href="/RealtorsPortal/morgagecalc.jsp">
        <img src="/RealtorsPortal/images/buttons/mortgage.jpg" alt="Mortgage Calculator" width="192" height="44"></html:link></div>
<div id="apDiv8">
    <%--
        if the user is sign in the log out button is displayed if the user is signed in the  log in button is displayed
    --%>
    <c:if scope="session" test="${empty username}" var="var"><html:link href="/RealtorsPortal/login.jsp">
            <img src="/RealtorsPortal/images/buttons/log_in.jpg" alt="Log in" width="192" height="44"></html:link></c:if>
                 <c:if scope="session" test="${not empty username}" var="var"><html:link action="/logout">
            <img src="/RealtorsPortal/images/buttons/log_out.jpg" alt="Log in" width="192" height="44"></html:link></c:if></div>
<div id="apDiv10">
  <html:link action="load_ads">
<img src="/RealtorsPortal/images/buttons/manage_ads.jpg" alt="Manage Ads" width="192" height="44"></html:link></div>
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
	      <div align="center" class="style3">Manage Agent Profile</div>
      </div>
<div id="Middle">
          <div id="Page">
            <div id="Content">
                <div id="apDiv11">
                    <%--
        Displays success on successfull update and shows error on failure
        Each parameter's initial value is the current value in the database
        --%>
            <div align="center" style="color:red"><html:errors property="emptyfield"/><html:errors property="emailexist"/>
            <html:errors property="usernameexist"/>
            <html:form action="/agentupdateprofile">${requestScope['success']}</div>
          <table width="343" align="center" border="1">
            <tr>
              <td align="center" colspan="2"><strong>Edit Personal Details</strong></td>
            </tr>
            <tr>
              <td width="146">Firstname</td>
              <td width="185" align="center"><html:text property="firstname" value="${userdata.firstname}"></html:text></td>
            </tr>
            <tr>
              <td>Middlename</td>
              <td align="center"><html:text property="middlename" value="${userdata.middlename}"></html:text></td>
            </tr>
            <tr>
              <td>Lastname</td>
              <td align="center"><html:text property="lastname" value="${userdata.lastname}"></html:text></td>
            </tr>
            <tr>
              <td>Email</td>
              <td align="center"><html:text property="email" value="${userdata.email}"></html:text></td>
            </tr>
            <tr>
              <td>Username</td>
              <td align="center"><html:text property="userName" value="${userdata.username}"></html:text></td>
            </tr>
            <tr>
                <td><html:reset/></td>
              <td><div align="right">
                     <html:submit value="Update details"/>
              </div></td>
            </tr>
          </table>
              </html:form>
        </div>
              <div id="apDiv12">
        <%--
        Displays success on successfull update and shows error on failure
        Each parameter's initial value is the current value in the database
        --%>
    <div align="center" style="color:red"><html:errors property="emptyfield"/><html:errors property="emailexist"/>
            <html:errors property="passwordnotequal"/><html:errors property="passwordincorrect"/>
            ${requestScope['passwordsuccess']}</div>
    <html:form action="/agentchangepassword">
<table width="279" border="1" align="center">
            <tr>
              <td width="138" colspan="2" align="center"><strong>Change Password</strong></td>
            </tr>
            <tr>
              <td>Password</td>
              <td><html:password property="currentPassword"/></td>
            </tr>
            <tr>
              <td>New Password</td>
              <td><html:password property="password1"/></td>
            </tr>
            <tr>
              <td>Renter Password</td>
              <td><html:password property="password2"/></td>
            </tr>
            <tr>
                <td><html:reset/></td>
              <td><div align="right">
                      <html:submit value="Change Password"/>
              </div></td>
            </tr>
                        </table>
    </html:form>
        </div>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
              <p class="Part">&nbsp;</p>
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
