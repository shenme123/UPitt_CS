<%-- 
    Document   : index
    Created on : Feb 18, 2010, 1:27:56 PM
    Author     : spring
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Form1</h1>
    <form NAME ="T1" method ="post" action = "GenericServlet">
      <input type="hidden" name="table" value="ETEST"/>
      <table border="1">
        <tbody>
          <tr><td>Name:</td>
            <td><input type="text" name="dbfrm" value="" size="50" /></td>
          </tr>
          <tr><td>Title:</td>
            <td><input type="text" name="dbtite" value="" size="50" /></td>
          </tr>
          <tr><td>Categories:</td>
            <td><input type="checkbox" name="dbcat" value="old" checked>Old
                <input type="checkbox" name="dbcat" value="green">Green
                <input type="checkbox" name="dbcat" value="round" checked>Round
                <input type="checkbox" name="dbcat" value="yellow">Yellow </td>
          </tr> 
          <tr><td> Message:</td>
            <td><textarea name="dbmesse" rows="8" cols="50"></textarea></td>
          </tr>
          <tr>
            <td></td>
            <td><input type="submit" value="Submit" name="Submit" /></td>
          </tr>
        </tbody>
      </table>
    </form>
  </body>
</html>
