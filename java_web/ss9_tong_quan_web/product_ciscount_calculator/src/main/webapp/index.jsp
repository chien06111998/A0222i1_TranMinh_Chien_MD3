<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/17/2022
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap.min.js">
  </head>
  <body>
  <form action="/caculater" method="post">
    <table>
      <tr>
        <th>Product Description</th>
        <th>List Price</th>
        <th>Discount Percent</th>
      </tr>
      <tr>
        <td>
          <div class="mb-3">
            <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          </div>
        </td>
        <td>
          <div class="mb-3">
            <input type="number" class="form-control" name="price">
          </div>
        </td>
        <td>
          <div class="mb-3">
            <input type="number" class="form-control" name="discount">
          </div>
        </td>
      </tr>
    </table>
    <button type="submit" class="btn btn-primary">Calculate Discount</button>
  </form>
  </body>
</html>
