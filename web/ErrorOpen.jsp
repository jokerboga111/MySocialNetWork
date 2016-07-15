<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.12.2015
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка входа</title>
    <style>
        body {
            background: #c7b39b url(artleo.com-233679.jpg); /* Цвет фона и путь к файлу */
            color: #fff; /* Цвет текста */
        }
    </style>
</head>
<body>
<div style="width: 50%; margin: 0 auto; text-align: center;">
<br>
<h3>Вы ввели неправильный логин или пароль</h3>
<h1>Registretion</h1>
<form action="Registration" method="post">
    <table border = "0">
        <tr>
            <td><b>Login:</b></td>
            <td><input type = "text" name = "login"
                       size = "65"/></td>
        </tr>

        <tr>
            <td><b>Password:</b></td>
            <td><input type = "text" name = "password" size = "65"/></td>
        </tr>

        <tr>
            <td colspan = "2"><input type = "submit" value = "Вход"/></td>

        </tr>
    </table>
</form>
<form action="/registration.html" method="post">
    <td colspan = "2"><input type = "submit" value = "Регистрация" onClick=""/></td>
</form>
</div>
</body>
</html>
