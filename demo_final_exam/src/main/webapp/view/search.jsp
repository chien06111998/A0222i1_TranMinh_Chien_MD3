<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/15/2022
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
    <center>
        <h1>Search</h1>
        <h2>
            <a href="/matbang">Danh Sach</a>
        </h2>
    </center>
    <form action="/matbang" method="post" >
        <input hidden type="text" name="action" value="search">
        <input type="text" name="giaTien" value="${giaTien}" placeholder="Gia tien.">
        <input type="text" name="soTang" value="${soTang}" placeholder="So tang">
        <select name="maLoai">
            <option value="">Loai Mat Bang</option>
            <c:forEach var="type" items="${typeList}">
                <option value="${type.id}">${type.name}</option>
            </c:forEach>
        </select>
        <button type="submit">Search</button>
    </form>
</body>
</html>
