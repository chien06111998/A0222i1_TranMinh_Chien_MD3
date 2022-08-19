<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/19/2022
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--    <c:redirect url="/calculater"></c:redirect>--%>
      <h1>Simple Calculater</h1>
      <form action="/calculater" method="post">
        <fieldset>
          <legend>Calculater</legend>
          <table>
            <tr>
              <td>First operand: </td>
              <td><input name="num1" type="text"/></td>
            </tr>
            <tr>
              <td>Operator: </td>
              <td>
                <select name="operator">
                  <option value="+">Addition</option>
                  <option value="-">Subtraction</option>
                  <option value="*">Multiplication</option>
                  <option value="/">Division</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Second operand: </td>
              <td><input name="num2" type="text"/></td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" value="Calculate"/></td>
            </tr>
          </table>
        </fieldset>
      </form>
  </body>
</html>
