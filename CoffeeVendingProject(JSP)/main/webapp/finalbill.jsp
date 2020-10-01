<%--
  Created by IntelliJ IDEA.
  User: skhurana
  Date: 9/6/2020
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BillPage</title>
    <link rel="stylesheet" type="text/css" href="finalbillstyle.css">
</head>
<body>
<%@include file="toolbar.jsp"%>
    <h1>You need to pay us Rs.<%= session.getAttribute("cost")%></h1>
</body>
</html>
