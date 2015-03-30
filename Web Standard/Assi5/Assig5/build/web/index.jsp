<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
    </head>
    <body>
        <h1>Pitt Login System</h1>
        <form method ="post" action ="Login">
            Pitt ID: <br/><input type="text" name="userID"/><br/>
            Password:<br/><input type="text" name="password"/><br/>
            <input type="submit" value ="submit"><br>
        </form>
        <a href ="register.jsp">Not Registered Yet? Register Here.</a>
    </body>
</html>
