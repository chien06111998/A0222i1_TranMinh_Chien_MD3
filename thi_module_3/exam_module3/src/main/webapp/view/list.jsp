<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/16/2022
  Time: 2:20 PM
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
        <h1>Mat Bang</h1>
        <a href="/main">Quay Lai Danh Sach</a> <br>
        <a href="/main?action=create">Add New</a> <br>
        <a href="/main?action=search">Search</a>
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
        <c:forEach var="main" items="${mainList}" varStatus="status">
            <tr>
                <td><c:out value="${main.id}"/></td>
                <c:forEach var="second" items="${secondList}">
                    <c:if test="${second.id == main.idNote}">
                        <td>${note.name}</td>
                    </c:if>
                </c:forEach>
                <td><c:out value="${main.area}"/></td>
                <td><c:out value="${main.soTang}"/></td>
                <c:forEach var="second" items="${secondList}">
                    <c:if test="${second.id == main.idNote}">
                        <td>${type.name}</td>
                    </c:if>
                </c:forEach>
                <td><c:out value="${main.note}"/></td>
                <td><c:out value="${main.price}"/></td>
                <td><c:out value="${main.startDate}"/></td>
                <td><c:out value="${main.endDate}"/></td>
                <td>
                    <button type="button"><a href="/main?action=update&id=${main.id}" class="btn btn-primary">Edit</a></button>
                    <button type="button" onclick="deleteInfo('${main.id}')" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
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
            <form action="/main?action=delete" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
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
