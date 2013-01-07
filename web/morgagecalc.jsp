<%-- 
    Document   : Mortgage Calculator
    Created on : Dec 15, 2010, 1:16:49 PM
    Author     : Mohammed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html:html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mortgage Calculator</title>
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
	left:1123px;
	top:184px;
	width:150px;
	height:48px;
	z-index:8;
}
-->
        </style>
        <%--
         The Formula for the Mortgage Calculator in Javascript
        --%>
        <script type="text/javascript">

var amortsub = false;

function calcLoan() {

var formvals = getFormVal();

var years = formvals[0];
var months = years * 12;

var loan = formvals[2];
var apr = formvals[1];

var mpr = apr / 1200;
var nfactor = 0 - months;
var mofactor = Math.pow((1 + mpr), nfactor);
var bofactor = 1 - mofactor;
var tofactor = mpr / bofactor;

var payment = loan * tofactor;
var reducto = Math.round(payment*100)/100;

document.wcbubba.payment.value = "$"+reducto;

if (amortsub) showAm();

}

function showAm(){

amortsub = true;

formvals = getFormVal();

var years = formvals[0];
var months = years * 12;

var loan = formvals[2];
var apr = formvals[1];

var mpr = apr / 1200;
var nfactor = 0 - months;
var mofactor = Math.pow((1 + mpr), nfactor);
var bofactor = 1 - mofactor;
var tofactor = mpr / bofactor;

var payment = loan * tofactor;
var reducto = Math.round(payment*100)/100;

document.wcbubba.payment.value = "$"+reducto;

// NOW WE CALCULATE THE AMORTIZATION

var intpaid = 0;
var princpaid = 0;
var factsout = "";
var inyear = 0;
var inmonth = 0;

document.getElementById('amortsub').innerHTML = '<b style="font-size:19px;">MONTHLY AMORTIZATION</b><br><br>';

for(var i=0;i<months;i++){
intpaid = Math.round((mpr * loan) *100)/100;
princpaid = Math.round((reducto - intpaid)*100)/100;
loan = Math.round((loan - princpaid)*100)/100;

inyear = parseInt(i/12);
inmonth = i - (inyear * 12);

factsout += '<b>Year ' + (inyear + 1) + ' Month ' + (inmonth +1) + ':</b><br>   Principal Paid: $' + princpaid + '<br>   Interest Paid: $' + intpaid + '<br>   Principal Remaining: $' + loan + '<br>';

}
document.getElementById('amortsub').innerHTML += factsout;

flush();

}

function getFormVal(){

var years = parseInt(document.wcbubba.term.value);
var loan = parseInt(document.wcbubba.loan.value);
var apr = parseFloat(document.wcbubba.apr.value);

if((years <= 0)||(isNaN(years))) years = 1;
if((apr <= 0)||(isNaN(apr))) apr = 1;
if((loan <= 0)||(isNaN(loan))) loan = 1;

var mike = new Array(years,apr,loan);

return mike;
}

</script>
</head>
    <body>
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
<div id="apDiv9"><c:if scope="session" test="${role=='privateseller'}" var="var"><html:link action="/privatesellersection">
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
	      <div align="center" class="style3">Mortgage Calculator</div>
      </div>
<div id="Middle">
          <div id="Page">
            <div id="Content">
              <div align="center" ><table border="1">
                <p><form id="wcbubba" name="wcbubba" action="javascript:void();">
            <tr>
                <td>Loan Amount:</td>
                <td> <input type=text name="loan" size=8></td>
            </tr>
            <tr>
                <td>Loan Term(years):</td>
                <td> <input type=text name="term" size=8></td>
            </tr>
            <tr>
                <td>APR Interest:</td>
                <td> <input type=text name="apr" size=8></td>
            </tr>
            <tr>
                <td>Payment:</td>
                <td> <input type=text name = "payment" size=9 readonly="yes"></td>
            </tr>
            <tr><td><input type="submit" value="Calculate Payment" onClick="calcLoan();"></td>
                <td><input type="submit" value="Show Amortization" onClick="showAm();"></td>
            </tr></form>
            </table>
        
                
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
                <p>&nbsp;</p>
              </div>
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
