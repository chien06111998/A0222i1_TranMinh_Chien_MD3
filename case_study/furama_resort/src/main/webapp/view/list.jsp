<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/8/2022
  Time: 4:30 PM
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
        <h1>customer</h1>
        <a href="/index.jsp">Return home page.</a> <br>
        <a href="/customer_type">Go to customer type list.</a> <br>
        <a href="/resort?action=create">Add New</a> <br>
        <a href="/resort?action=search">Search</a>
    </center>
    <c:if test="${mess!=null}">
        <span style="color: red">${mess}</span>
    </c:if>
    <table class="table table-dark" align="center">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Birth Day</th>
            <th scope="col">Gender</th>
            <th scope="col">Id Card</th>
            <th scope="col">Phone Number</th>
            <th scope="col">Email</th>
            <th scope="col">Customer Type</th>
            <th scope="col">Address</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customerList}" varStatus="status">
                <tr>
                    <td><c:out value="${customer.id}"/></td>
                    <td><c:out value="${customer.name}"/></td>
                    <td><c:out value="${customer.birthday}"/></td>
                    <td><c:out value="${customer.gender}"/></td>
                    <td><c:out value="${customer.idCard}"/></td>
                    <td><c:out value="${customer.phoneNumber}"/></td>
                    <td><c:out value="${customer.email}"/></td>
                     <c:forEach var="customerType" items="${customerTypeList}">
                        <c:if test="${customer.customerTypeID == customerType.idCustomerType}">
                          <td><c:out value="${customerType.nameCustomerType}"/></td>
                        </c:if>
                     </c:forEach>
<%--                    <td><c:out value="${customer.customerTypeID}"/></td>--%>
                    <td><c:out value="${customer.address}"/></td>

                    <td><button type="button"><a href="/resort?action=update&id=${customer.id}" class="btn btn-primary">Edit</a></button>
                    <button type="button" onclick="deleteInfo('${customer.id}','${customer.name}')" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                        Delete
                    </button></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <form action="/resort?action=delete" method="post">
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
                    <span>Do you want delete </span><span id="deleteName"></span><span>?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" onclick="showAlert()">Yes</button>
                </div>
            </div>
            </form>
        </div>
    </div>
    <script>
        function deleteInfo(id,name) {
            document.getElementById("deleteId").value=id;
            document.getElementById("deleteName").innerText=name;
        }
        function showAlert() {
            var message = "Delete success.";
            alert(message);
        }
    </script>
</body>
</html>
