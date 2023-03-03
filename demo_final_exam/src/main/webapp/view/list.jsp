<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/15/2022
  Time: 6:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
    <center>
        <h1>Mat Bang</h1>
        <%--        <a href="/customer_type">Go to customer type list.</a> <br>--%>
        <%--        <a href="/contract">Go to contract list.</a> <br>--%>
        <a href="/matbang">Quay Lai Danh Sach</a> <br>
        <a href="/matbang?action=create">Add New</a> <br>
        <a href="/matbang?action=search">Search</a>
    </center>
    <c:if test="${mess!=null}">
        <span style="color: red; font-size: 30px">${mess}</span>
    </c:if>
    <table class="table table-dark" align="center">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Trang Thai</th>
            <th scope="col">Dien Tich</th>
            <th scope="col">So Tang</th>
            <th scope="col">Loai Van Phong</th>
            <th scope="col">Mo ta Chi Tiet</th>
            <th scope="col">Gia Thue</th>
            <th scope="col">Ngay Thue</th>
            <th scope="col">Ngay Tra</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="matbang" items="${matBangList}" varStatus="status">
            <tr>
                <td><c:out value="${matbang.id}"/></td>
                <c:forEach var="note" items="${noteList}">
                    <c:if test="${note.id == matbang.idNote}">
                        <td>${note.name}</td>
                    </c:if>
                </c:forEach>
                <td><c:out value="${matbang.area}"/></td>
                <td><c:out value="${matbang.soTang}"/></td>
                <c:forEach var="type" items="${typeList}">
                    <c:if test="${type.id == matbang.idNote}">
                        <td>${type.name}</td>
                    </c:if>
                </c:forEach>
                <td><c:out value="${matbang.note}"/></td>
                <td><c:out value="${matbang.price}"/></td>
                <td><c:out value="${matbang.startDate}"/></td>
                <td><c:out value="${matbang.endDate}"/></td>
<%--                <c:set var = "now" value = "20-10-2010" />--%>
<%--                <fmt:parseDate value = "${now}" var = "parsedEmpDate" pattern = "dd-MM-yyyy" />--%>
<%--                <td><c:out value="${matbang.startDate}"/></td>--%>
<%--                <td><fmt:parseDate pattern="dd-MM-yyyy"  value="${matbang.endDate}" var="parsedDate"/></td>--%>
                <td>
                    <button type="button"><a href="/matbang?action=update&id=${matbang.id}" class="btn btn-primary">Edit</a></button>
                    <button type="button" onclick="deleteInfo('${matbang.id}')" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <form action="/matbang?action=delete" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input hidden name="deleteId" id="deleteId">
                        <input hidden name="action" value="delete">
                        <span>Do you want delete?</span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Yes</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script>
        function deleteInfo(id) {
            document.getElementById("deleteId").value=id;
        }
    </script>
</body>
</html>
