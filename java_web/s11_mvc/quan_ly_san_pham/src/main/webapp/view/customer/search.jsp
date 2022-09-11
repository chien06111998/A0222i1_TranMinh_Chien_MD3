<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/22/2022
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Form search</h1>
    <p>
        <a href="/customer">Back to customer list</a>
    </p>
    <form action="/customer?action=search" method="post">
        <pre>Enter Id:      <input type="text" name="id"></pre>
        <pre>               <button type="submit">Search</button></pre>
    </form>
</body>
</html>
