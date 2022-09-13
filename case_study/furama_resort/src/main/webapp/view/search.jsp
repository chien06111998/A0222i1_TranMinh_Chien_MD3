<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/12/2022
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/resort">List All Customer</a>
    </h2>
</center>
<form action="/resort" method="post" >
    <h2>Search</h2>
    <input hidden type="text" name="action" value="search">
    <input type="text" name="nameCustomer" value="${nameCustomer}" placeholder="Enter name">
    <input type="text" name="idCustomer" value="${idCustomer}" placeholder="Enter id">
    <select name="idCustomerType">
<%--        <option value="">Customer Type</option>--%>
        <c:forEach var="customerType" items="${customerTypeList}">
            <option value="${customerType.idCustomerType}">${customerType.nameCustomerType}</option>
        </c:forEach>
    </select>
    <button type="submit">Search</button>
</form>
</body>
</html>
