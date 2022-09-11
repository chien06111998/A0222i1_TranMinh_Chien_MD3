<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/8/2022
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
  </head>
  <body>
<%--      <c:redirect url="/resort"></c:redirect>--%>
        <div class="row bg-info">
          <div class="col-6 col-lg-2 col-md-2 col-sm-3">Logo</div>
          <div class="col-lg-8 col-md-8 col-sm-6"></div>
          <div class="col-6 col-lg-2 col-md-2 col-sm-3">Account</div>
        </div>
        <div class="row bg-light">
          <div class="col-lg-1 col-md-1"></div>
          <div class="col-lg-1 col-md-1"><a href="#">Home</a></div>
          <div class="col-lg-1 col-md-1"><a href="#">Employee</a></div>
          <div class="col-lg-1 col-md-1"><a href="/resort">Customer</a></div>
          <div class="col-lg-1 col-md-1"><a href="#">Service</a></div>
          <div class="col-lg-1 col-md-1"><a href="#">Contract</a></div>
          <div class="col-lg-1 col-md-1"></div>
          <div class="col-lg-1 col-md-1"><a href="#">Search</a></div>
        </div>
        <div class="row">
          <div class="col-lg-2 col-md-2 bg-danger">
            <div class="row"><a href="#">Item1</a></div>
            <div class="row"><a href="#">Item2</a></div>
            <div class="row"><a href="#">Item3</a></div>
          </div>
          <div class="col-lg-10 col-md-10 bg-success">
            <div>body</div>
          </div>
        </div>
        <div class="row bg-warning">
          <div class="col-lg-12 col-md-12 col-sm-12 col-12 col-xl-12"><footer>Footer text</footer></div>
        </div>
  </body>
</html>
