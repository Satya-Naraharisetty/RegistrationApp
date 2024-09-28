<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>form</title>
</head>
<body>
<h1><%= "Fill the form" %>
</h1>
<br/>
<form action="./ServletJDBC" method="post">
    <table>
        <tr><td>User name </td>
            <td> <input type="text" name="UName" ></td>
        </tr>
        <tr><td>User Age</td>
            <td> <input type="number" name="UAge" ></td>
        </tr>
        <tr><td>User City</td>
            <td> <input type="text" name="UCity" ></td>
        </tr>
        <tr><td>User Email</td>
            <td> <input type="email" name="UEmail" ></td>
        </tr>
        <tr><td>User Password</td>
            <td> <input type="text" name="UPswd" ></td>
        </tr>
        <tr>
            <td> <input type="submit" value="Signup" ></td>
        </tr>
    </table>
</form>
</body>
</html>