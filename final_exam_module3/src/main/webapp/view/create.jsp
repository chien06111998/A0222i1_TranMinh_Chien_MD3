<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/14/2022
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
        <h1>Them Moi</h1>
        <h2>
            <a href="/matbang">Danh sach</a>
        </h2>
        <c:if test="${mess!=null}">
            <span style="color: red; font-size: 30px">${mess}</span>
        </c:if>
    </center>
    <div align="center">
        <form action="/matbang?action=create" method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Id:</th>
                    <td>
                        <input type="text" name="id" id="id" size="45"/>
<%--                        <c:if test="${error!=null}">--%>
<%--                            <span style="color: red">${error.get("id")}</span>--%>
<%--                        </c:if>--%>
                    </td>
                </tr>
                <tr>
                    <th>Trang Thai:</th>
                    <td><input type="text" name="idTrangThai" id="idTrangThai" size="45"/></td>
<%--                    <select name="idTrangThai" id="idTrangThai"> --%>
<%--                        <option value="">Da co nguoi thue</option>--%>
<%--                        <option value="">Chua co nguoi thue</option>--%>
<%--                        <option value="">Da dat coc</option>--%>
<%--                        <option value="">Phong o ghep</option>--%>
<%--                    </select>--%>

<%--                    <c:forEach var="matbang" items="${matBangList}">--%>
<%--                        <c:if test="${matbang.idTrangThai == 1}">--%>
<%--                            <td><c:out value="Da co nguoi thue"/></td>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${matbang.idTrangThai == 1}">--%>
<%--                            <td><c:out value="Chua co nguoi thue"/></td>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${matbang.idTrangThai == 1}">--%>
<%--                            <td><c:out value="Da dat coc"/></td>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${matbang.idTrangThai == 1}">--%>
<%--                            <td><c:out value="Phong o ghe"/></td>--%>
<%--                        </c:if>--%>
<%--                    </c:forEach>--%>
                </tr>
                    <tr>
                        <th>Dien Tich:</th>
                        <td>
                            <input type="text" name="dienTich" id="dienTich" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>So Tang:</th>
                        <td>
                            <input type="text" name="soTang" id="soTang" size="15"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Loai Mat Bang:</th>
                        <td> <input type="text" name="maLoai" id="maLoai" size="45"/></td>
<%--                        <c:forEach var="matbang" items="${matBangList}">--%>
<%--                            <c:if test="${matbang.idTrangThai == 1}">--%>
<%--                                <td><c:out value="Nha cap 4"/></td>--%>
<%--                            </c:if><c:if test="${matbang.idTrangThai == 1}">--%>
<%--                                <td><c:out value="Nha tro"/></td>--%>
<%--                            </c:if><c:if test="${matbang.idTrangThai == 1}">--%>
<%--                                <td><c:out value="Nha nguyen can"/></td>--%>
<%--                            </c:if><c:if test="${matbang.idTrangThai == 1}">--%>
<%--                                <td><c:out value="Nha nghi"/></td>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
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
<%--                        <c:if test="${error!=null}">--%>
<%--                            <span style="color: red">${error.get("email")}</span>--%>
<%--                        </c:if>--%>
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
