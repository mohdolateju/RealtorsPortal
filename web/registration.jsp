<%-- 
    Document   : Registration Page
    Created on : Dec 15, 2010, 1:16:49 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" type="text/css" href="css/css.css" >
        <%--

        --%>
        <script type="text/javascript">
            window.onload=getcurPackage;
            function getCurPackage(obj){
                var curPackage = obj.options[obj.selectedIndex].value;
                document.RegistrationFormBean.action = "/RealtorsPortal/showPrices.do";
                document.RegistrationFormBean.submit();

            }

        </script>
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
        <div id="apDiv8"><c:if scope="session" test="${empty username}" var="var"><html:link href="/RealtorsPortal/login.jsp">
                    <img src="/RealtorsPortal/images/buttons/log_in.jpg" alt="Log in" width="192" height="44"></html:link></c:if>
            <c:if scope="session" test="${not empty username}" var="var"><html:link action="/logout">
                    <img src="/RealtorsPortal/images/buttons/log_out.jpg" alt="Log in" width="192" height="44"></html:link></c:if></div>
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
                            <div align="center" class="style3">Please Enter Your Details to Register</div>
                        </div>
                        <div id="Middle">
                            <div id="Page">
                                <div id="Content">
                                    <div align="center"><h2>Please Select A Package Before Filling the Form</h2>
        <%--
        This Displays the html errors if validation fails
        --%>
                                        <div style="color: red;"><html:errors property="emptyfield"/>&nbsp;<html:errors property="usernameexist"/>
                                        &nbsp;<html:errors property="passwordincorrect"/>&nbsp;<html:errors property="emailexist"/>&nbsp;
                                        <html:errors property="incorrectcreditcardno"/>&nbsp;<html:errors property="incorrectemail"/>
                                       </div>
                                <html:form action="/register">
                                    <table width="344" border="1" align="center" cellpadding="1">
                                        <tr>
                                            <td width="162">Firstname:</td>
                                            <td width="166"><html:text property="firstName"/></td>
                                        </tr>
                                        <tr>
                                            <td>Middlename:</td>
                                            <td><html:text property="middleName"/></td>
                                        </tr>
                                        <tr>
                                            <td>Lastname:</td>
                                            <td><html:text property="lastName"/></td>
                                        </tr>
                                        <tr>
                                            <td>Username:</td>
                                            <td><html:text property="userName"/></td>
                                        </tr>
                                        <tr>
                                            <td>Password:</td>
                                            <td><html:password property="passWord1"/></td>
                                        </tr>
                                        <tr>
                                            <td>Renter Password:</td>
                                            <td><html:password property="passWord2"/></td>
                                        </tr>
                                        <tr>
                                            <td>Email:</td>
                                            <td><html:text property="email"/></td>
                                        </tr>
                                        <tr>
                                            <td>Role:</td>
                                            <td><div align="center">
                                                    <html:select property="role">
                                                        <option value="agent">Agent</option>
                                                        <option value="privateseller" selected>Private Seller</option>
                                                    </html:select>
                                                </div></td>
                                        </tr>
                                        <tr>
                                            <td>Package:</td>
                                          <td>
                                            <%--
                                            This is used to get the subscription package details whe the user selects a subscription 
                                            package
                                            --%>
                                              <div align="center">
                                                  <html:select  property="pacKage"
                                                            onchange="getCurPackage(this)"  >
                                                        <c:forEach var="pckgBean" items="${packages}" >
                                                            <c:if test="${curPackage == pckgBean.subPackage}">
                                                                <option value="${pckgBean.subPackage}" selected="selected">${pckgBean.subPackage}<option>
                                                            </c:if>
                                                            <c:if test="${not (curPackage == pckgBean.subPackage)}">
                                                                <option value="${pckgBean.subPackage}">${pckgBean.subPackage}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </html:select>
                                                </div></td>
                                        </tr>
                                        <tr>
                                            <td>Price:</td>
                                            <td><div align="center">
                                                    $ ${prices}
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Duration(Days):</td>
                                            <td><div align="center">
                                                    ${duration}
                                                </div></td>
                                        </tr>
                                        <tr>
                                            <td>Credit Card no.(9 digits):</td>
                                            <td><html:text property="creditNo"/></td>
                                        </tr>
                                        <tr>
                                            <td><html:reset/></td>
                                            <td><div align="right">
                                                    <html:submit/>
                                                </div></td>
                                        </tr>
                                    </table>
                                </html:form>
                            </div>
                            <p class="Part">&nbsp;</p>
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
