<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/19/2022
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
    <table class="table table-dark">
        <tr>
            <th>Name</th>
            <th>Birth Day</th>
            <th>Address</th>
            <th>Image</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.address}</td>
                    <c:choose>
                        <c:when test="${customer.idImage == 1}">
                            <td><img src="https://luv.vn/wp-content/uploads/2021/09/hinh-anh-nu-sinh-dep-nhat-69.jpg" alt="Hinh anh o day"></td>
                        </c:when>
                        <c:when test="${customer.idImage == 2}">
                            <td><img src="https://luv.vn/wp-content/uploads/2021/09/hinh-anh-nu-sinh-dep-nhat-69.jpg" alt="Hinh anh o day"></td>
                        </c:when>
                        <c:when test="${customer.idImage == 3}">
                            <td><img src="https://luv.vn/wp-content/uploads/2021/09/hinh-anh-nu-sinh-dep-nhat-69.jpg" alt="Hinh anh o day"></td>
                        </c:when>
                        <c:when test="${customer.idImage == 4}">
                            <td><img src="https://luv.vn/wp-content/uploads/2021/09/hinh-anh-nu-sinh-dep-nhat-69.jpg" alt="Hinh anh o day"></td>
                        </c:when>
                        <c:when test="${customer.idImage == 5}">
                            <td><img src="https://luv.vn/wp-content/uploads/2021/09/hinh-anh-nu-sinh-dep-nhat-69.jpg" alt="Hinh anh o day"></td>
                        </c:when>
                        <c:otherwise>
                            <td>Null</td>
                        </c:otherwise>
                    </c:choose>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
