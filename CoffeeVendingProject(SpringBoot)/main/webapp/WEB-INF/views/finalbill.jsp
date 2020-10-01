<%--
  Created by IntelliJ IDEA.
  User: skhurana
  Date: 9/13/2020
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BillPage</title>
    <link rel="stylesheet" type="text/css" href="/resources/finalbillstyle.css">
</head>
<body>
<br>
<%@include file="toolbar.jsp"%><br><br>
<h1>True Bill Rs. ${trueBill} </h1>
<h1>Discount Percentage: ${discountPercent}</h1><hr>
<h1>Final Bill Rs. ${finalBill}</h1>
</body>
</html>
