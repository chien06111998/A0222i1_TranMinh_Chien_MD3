<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/8/2022
  Time: 5:48 PM
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
    <c:if test="${mess!=null}">
        <span style="color: red">${mess}</span>
    </c:if>
    <div align="center">
        <form action="/resort?action=create" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Add New Customer</h2>
                </caption>
                <tr>
                    <th>Id:</th>
                    <td>
                        <input type="text" name="id" id="id" size="45"/>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("id")}</span>
                        </c:if>
                    </td>
                </tr><tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" id="name" size="45"/>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("name")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Birtd day:</th>
                    <td>
                        <input type="date" name="birthday" id="birthday" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td>
                        <input type="text" name="gender" id="gender" size="15"/>
                    </td>
                </tr>
                <tr>
                    <th>Id card:</th>
                    <td>
                        <input type="text" name="idCard" id="idCard" size="15"/>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("idCard")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Phone number:</th>
                    <td>
                        <input type="text" name="phoneNumber" id="phoneNumber" size="15"/> <br>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("phoneNumber")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="email" id="email" size="15"/> <br>
                        <c:if test="${error!=null}">
                            <span style="color: red">${error.get("email")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Customer type:</th>
                    <td>
                        <select name="customerTypeId">
                            <c:forEach var="customerType" items="${customerTypeList}">
                                <option value="${customerType.idCustomerType}">${customerType.nameCustomerType}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td>
                        <input type="text" name="address" id="address" size="15"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" onclick="showAlertSuccess()">
                        <input type="submit" value="Save"/>
                    </td>
<%--                    <td colspan="2" align="center">--%>
<%--                        <input type="submit" value="Save"/>--%>
<%--                    </td>--%>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
<script>
    function showAlertSuccess() {
        var messageSuccess = "Create success.";
        alert(messageSuccess);
    }
</script>