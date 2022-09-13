<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/13/2022
  Time: 11:20 PM
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
            <a href="/contract">Contract All Customer</a>
        </h2>
    </center>
    <div align="center">
        <form action="/contract?action=create" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Add New Contract</h2>
                </caption>
                <tr>
                    <th>Id Contract:</th>
                    <td>
                        <input type="text" name="id" id="id" size="45"/>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("id")}</span>
                        </c:if>
                    </td>
                </tr><tr>
                <th>Start Date:</th>
                <td>
                    <input type="date" name="startDate" id="startDate" size="45"/>
                </td>
            </tr>
                <tr>
                    <th>End Day:</th>
                    <td>
                        <input type="date" name="endDate" id="endDate" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>deposit:</th>
                    <td>
                        <input type="text" name="deposit" id="deposit" size="45"/>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("deposit")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Total Money:</th>
                    <td>
                        <input type="text" name="totalMoney" id="totalMoney" size="45"/>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("totalMoney")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Id Customer:</th>
                    <td>
<%--                        <input type="text" name="phoneNumber" id="phoneNumber" size="15"/> <br>--%>
                        <select name="idCustomer">
                            <c:forEach var="customer" items="${customerList}">
                                <option value="${customer.id}">${customer.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" onclick="showAlertSuccess()">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</body>
</html>
<script>
    function showAlertSuccess() {
        var messageSuccess = "Create success.";
        alert(messageSuccess);
    }
</script>
