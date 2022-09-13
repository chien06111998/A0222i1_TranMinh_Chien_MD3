<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/14/2022
  Time: 1:12 AM
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
            <a href="/contract">List All Contract</a>
        </h2>
    </center>
    <form action="/contract" method="post" >
        <h2>Search</h2>
        <input hidden type="text" name="action" value="search">
        <input type="text" name="idContract" value="${idContract}" placeholder="Enter id Contract">
<%--        <input type="text" name="idCustomer" value="${idCustomer}" placeholder="Enter id customer">--%>
        <select name="idCustomer">
            <option value="">Customer name</option>
            <c:forEach var="customer" items="${customerList}">
                <option value="${customer.id}">${customer.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Search</button>
    </form>
</body>
</html>
