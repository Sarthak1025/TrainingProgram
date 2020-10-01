<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>CoffeeMenu</title>
    <link rel="stylesheet" type="text/css" href="/resources/menustyle.css">
</head>
<body>
<spring:form action="./order" method="post" modelAttribute="order">
    <h1 align="right">Menu</h1>
    <%@include file="toolbar.jsp"%><br>
    <label class="coffees">Choose Coffee:</label>
    <spring:select path="coffeeName">
    <spring:options items="${coffeeList}"/>
    </spring:select><br><br><br>

    <label class="sizes">Choose Size:</label>
    <spring:select path="sizeName">
        <spring:options items="${sizeList}"/>
    </spring:select><br><br><br>

    <label class="addons">Choose AddOn:</label>
    <spring:select path="addOnName">
        <spring:options items="${addOnList}"/>
    </spring:select><br><br><br>

    <label>Discount Coupon:</label>
    <spring:input path="couponCode" cssStyle=" color: hotpink; background-color: darkslateblue;
     height: 65px; width: 300px; font-family:Jokerman, serif; font-size: 40px " /><br><br><br>
    <input id= "submit1" type="submit" name="Place Your Order" value="Place Your Order">
</spring:form>
</body>
</html>