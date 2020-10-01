<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: skhurana
  Date: 9/3/2020
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CoffeeMenu</title>
    <link rel="stylesheet" href="menustyle1.css" type="text/css">
</head>
<body>
    <form action="./OrderController" method="post">
        <h1>Menu</h1>
        <%@include file="toolbar.jsp"%><br><br>
        <%
            ArrayList<String> coffeeList;
            coffeeList = (ArrayList<String>) session.getAttribute("coffeeList");
            ArrayList<String> sizeList;
            sizeList = (ArrayList<String>) session.getAttribute("sizeList");
            ArrayList<String> addOnList;
            addOnList = (ArrayList<String>) session.getAttribute("addOnList");
        %>
        <label class="coffees">Choose coffee:</label>
        <select name="coffee" class="coffees">
            <% for(String coffee: coffeeList){%>
            <option value="<%= coffee %>"><%= coffee%></option>
            <%
            }
            %>
        </select><br><br><br>

        <label class="sizes">
            Choose size:</label>
        <select name="size" class="sizes">
        <c:forEach var="i" begin="0" end="${sizeList.size()}">
            <option value="${sizeList[i]}">${sizeList[i]}</option>
        </c:forEach>
        </select><br><br><br>

        <label class="addOns" id="label1">Choose AddOn:</label>
        <select name="addOn" class="addOns">
            <c:forEach var="i" begin="1" end="${addOnList.size()}">
                <option value="${addOnList[i]}">${addOnList[i]}</option>
            </c:forEach>
        </select><br><br><br>

        <label>Discount Coupon:</label>
        <input id="text1" type="text" name="discountCode" width="300" height="65"><br><br><br>
        <input id= "submit1" type="submit" name="Place Your Order" value="Place Your Order">

    </form>

</body>
</html>
