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
        <h1>User Management</h1>
        <h2>
            <a href="/resort">List All Users</a>
        </h2>
    </center>
    <div align="center">
        <form action="/resort?action=update" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        Edit Customer
                    </h2>
                </caption>
                <c:if test="${customerList != null}">
                    <input type="hidden" name="id" value="<c:out value='${customerList.id}' />"/>
                </c:if>
                <tr>
                    <th>Customer Name:</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${customerList.name}' />"
                        />
                    </td>
                </tr><tr>
                    <th>Birth Day:</th>
                    <td>
                        <input type="date" name="birthday" size="45"
                               value="<c:out value='${customerList.birthday}' />"
                        />
                    </td>
                </tr><tr>
                    <th>Gender:</th>
                    <td>
                        <input type="text" name="gender" size="45"
                               value="<c:out value='${customerList.gender}' />"
                        />
                    </td>
                </tr><tr>
                    <th>Id Card:</th>
                    <td>
                        <input type="text" name="idCard" size="45"
                               value="<c:out value='${customerList.idCard}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Phone Number</th>:</th>
                    <td>
                        <input type="text" name="phoneNumber" size="45"
                               value="<c:out value='${customerList.phoneNumber}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="email" size="45"
                               value="<c:out value='${customerList.email}' />"
                        />
                    </td>
                </tr><tr>
                    <th>Customer Type:</th>
                    <td>
                        <input type="text" name="customerTypeId" size="45"
                               value="<c:out value='${customerList.customerTypeID}' />"
                        />
                    </td>
                </tr><tr>
                    <th>Address:</th>
                    <td>
                        <input type="text" name="address" size="45"
                               value="<c:out value='${customerList.address}' />"
                        />
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
