<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/13/2022
  Time: 11:19 PM
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
        <h1>Contract Management</h1>
        <h2>
            <a href="/contract">List All Contract</a>
        </h2>
    </center>
    <div align="center">
        <form action="/contract?action=update" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        Edit Contract
                    </h2>
                </caption>
                <c:if test="${contractList != null}">
                    <input type="hidden" name="id" value="<c:out value='${contractList.id}' />"/>
                </c:if>
                <tr>
                    <th>Start Date:</th>
                    <td>
                        <input type="date" name="startDate" size="45"
                               value="<c:out value='${contractList.startDate}' />"
                        />
                    </td>
                </tr><tr>
                <th>End Day:</th>
                <td>
                    <input type="date" name="endDate" size="45"
                           value="<c:out value='${contractList.endDate}' />"
                    />
                </td>
            </tr><tr>
                <th>Deposit:</th>
                <td>
                    <input type="text" name="deposit" size="45"
                           value="<c:out value='${contractList.deposit}' />"
                    />
                </td>
            </tr><tr>
                <th>Total Money:</th>
                <td>
                    <input type="text" name="totalMoney" size="45"
                           value="<c:out value='${contractList.totalMoney}' />"
                    />
                </td>
            </tr>
                <tr>
                    <th>Customer Id</th>:</th>
                    <td>
<%--                        <c:forEach var="contract" items="contractList">--%>
<%--                            <select name="idCustomer">--%>
<%--                                <c:forEach var="customer" items="${customerList}">--%>
<%--                                    <c:if test="${contract.idCustomer == customer.id}">--%>
<%--                                        <option value="${customer.id}">${customer.name}</option>--%>
<%--                                    </c:if>--%>
<%--                                </c:forEach>--%>
<%--                            </select>--%>
<%--                        </c:forEach>--%>

                        <input type="text" name="idCustomer" size="45"
                               value="<c:out value='${contractList.idCustomer}' />"
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
