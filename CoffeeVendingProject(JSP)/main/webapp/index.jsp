<%--
  Created by IntelliJ IDEA.
  User: skhurana
  Date: 9/3/2020
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyCoffeeVendingMachine</title>
    <link rel="stylesheet" type="text/css" href="indexstyle.css">
</head>
<body>
<form action="./IndexController" method="get">
    <h1 >Coffee Vending Machine</h1>
    <%@include file="toolbar.jsp"%>
<img src="coffee.png" height="500" width="500"><br>
<div class="blink_me">PLACE YOUR ORDER NOW!!!</div>
</form>
</body>
</html>
