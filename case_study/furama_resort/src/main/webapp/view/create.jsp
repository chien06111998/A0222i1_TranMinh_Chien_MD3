<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/8/2022
  Time: 5:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <p style="color: red">${mess}</p>
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
                    </td>
                </tr><tr>
                    <th>Name:</th>
                    <td>
                        <input type="text" name="name" id="name" size="45"/>
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
                    </td>
                </tr>
                <tr>
                    <th>Phone number:</th>
                    <td>
                        <input type="text" name="phoneNumber" id="phoneNumber" size="15"/>
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="email" id="email" size="15"/>
                    </td>
                </tr>
                <tr>
                    <th>Customer type Id:</th>
                    <td>
                        <input type="text" name="customerTypeId" id="customerTypeId" size="15"/>
                    </td>
                </tr>
                <tr>
                    <th>Address:</th>
                    <td>
                        <input type="text" name="address" id="address" size="15"/>
                    </td>
                </tr>
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
