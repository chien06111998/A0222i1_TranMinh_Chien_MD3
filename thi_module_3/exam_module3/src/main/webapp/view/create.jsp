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
        <h1>Them Moi</h1>
        <h2>
            <a href="/main">Danh sach</a>
        </h2>
        <c:if test="${mess!=null}">
            <span style="color: red; font-size: 30px">${mess}</span>
        </c:if>
    </center>
    <div align="center">
        <form action="/main?action=create" method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Id:</th>
                    <td>
                        <input type="text" name="id" id="id" size="45"/>
                        <c:if test="${error!=null}">--%>
                            <span style="color: red">${error.get("id")}</span>
                        </c:if> <c:if test="${error!=null}">--%>
                        <span style="color: red">${error.get("idExists")}</span>
                    </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Trang Thai:</th>
                    <td>
                        <select name="idNote">
                            <c:forEach var="second" items="${secondList}">
                                <option value="${second.id}">${second.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Dien Tich:</th>
                    <td>
                        <input type="text" name="dienTich" id="dienTich" size="45"/>
                        <c:if test="${error!=null}">--%>
                            <span style="color: red">${error.get("area")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>So Tang:</th>
                    <td>
                        <input type="text" name="soTang" id="soTang" size="15"/>
                        <c:if test="${error!=null}">--%>
                            <span style="color: red">${error.get("soTang")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Loai Mat Bang:</th>
                    <td>
                        <select name="inType">
                            <c:forEach var="second" items="${secondList}">
                                <option value="${second.id}">${second.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Mo Ta:</th>
                    <td>
                        <input type="text" name="moTa" id="moTa" size="45"/> <br>
                    </td>
                </tr>
                <tr>
                    <th>Gia Tien:</th>
                    <td>
                        <input type="text" name="giaTien" id="giaTien" size="15"/> <br>
                        <c:if test="${error!=null}">--%>
                            <span style="color: red">${error.get("price")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <th>Ngay Thue:</th>
                    <td>
                        <input type="date" name="ngayThue" id="ngayThue" size="15"/>
                    </td>
                </tr>
                <tr>
                    <th>Ngay Tra:</th>
                    <td>
                        <input type="date" name="ngayTra" id="ngayTra" size="15"/>
                        <c:if test="${error!=null}">--%>
                            <span style="color: red">${error.get("date")}</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button type="button" class="btn btn-secondary">
                            <a href="/main?action=create">
                                Back
                            </a>
                        </button>
                        <button type="submit" class="btn btn-danger">Save</button>
                        <%--                        <input type="submit" value="Save" class="btn btn-danger"/>--%>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
