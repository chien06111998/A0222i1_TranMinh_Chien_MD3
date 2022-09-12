<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/12/2022
  Time: 12:48 AM
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
        <h1>Customer Type Management</h1>
        <h2>
            <a href="/customer_type">List All Customer Type</a>
        </h2>
    </center>
    <div align="center">
        <form action="/customer_type?action=update" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        Edit Customer Type
                    </h2>
                </caption>
                <c:if test="${customerTypeList != null}">
                    <input type="hidden" name="idCustomerType" value="<c:out value='${customerTypeList.idCustomerType}' />"/>
                </c:if>
                <tr>
                    <th>Customer Type Name:</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${customerTypeList.nameCustomerType}' />"
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
