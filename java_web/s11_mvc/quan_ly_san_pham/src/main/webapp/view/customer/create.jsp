<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: PC--%>
<%--  Date: 8/22/2022--%>
<%--  Time: 6:24 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
    <a href="/customer">Go back to the main page.</a>
    <c:if test="${mess != null}">
        <h2>${mess}</h2>
    </c:if>
    <form action="/customer?action=create" method="post">
        <pre>ID:            <input type="text" name="id"></pre>
        <pre>Name:          <input type="text" name="name"></pre>
        <pre>Email:         <input type="text" name="email"></pre>
        <pre>Address:       <input type="text" name="address"></pre>
        <pre>           <button>Save</button></pre>
    </form>
</body>
</html>
