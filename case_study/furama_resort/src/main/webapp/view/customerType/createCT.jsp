<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/12/2022
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>Customer Type Management</h1>
        <h2>
            <a href="/customer_type">List All Customer Type</a>
        </h2>
    </center>
    <c:if test="${mess!=null}">
        <span style="color: red">${mess}</span>
    </c:if>
    <div align="center">
        <form action="/customer_type?action=create" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Add New Customer Type</h2>
                </caption>
                <tr>
                    <th>Id:</th>
                    <td>
                        <input type="text" name="idCustomerType" id="idCustomerType" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Name:</th>
                <td>
                    <input type="text" name="nameCustomerType" id="nameCustomerType" size="45"/>
                </td>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
