<%@ page import="com.milo.Library.service.UserService" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    if (new UserService().isUserLogged(session)) {
        response.sendRedirect("/");
    }
%>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Zaloguj</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .form-control {
            display: inline-block;
            width: 22%;
            height: calc(1.5em + .75rem + 2px);
            padding: .375rem .75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: #fff;
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: .25rem;
            transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out
        }
    </style>

</head>
<body class="text-center" style="margin-top: 8%">
<form class="form-signin" action="Login" method="POST">
    <br>
    <img src="/png/book.png" alt="" width="96" height="72">
    <br><br>
    <h1 class="h3 mb-3 font-weight-normal">Logowanie</h1>
    <br>
    <%
        if (session.getAttribute("loginError") != null) {
            if ((boolean) session.getAttribute("loginError")) {
    %>
    <p class="justify-content-center" style="color: darkred">Wprowadzono błędne dane!</p>
    <%
            }
        }
    %>

    <label for="username" class="sr-only">Nazwa użytkownika</label>
    <input type="text" id="username" name="username" class="form-control" placeholder="Nazwa użytkownika" required
           autofocus>
    <br><br>
    <label for="password" class="sr-only">Password</label>
    <input type="password" id="password" name="password" class="form-control" placeholder="Hasło" required>
    <div class="checkbox mb-3">
        <br>
        <label>
            <input type="checkbox" value="remember-me"> Zapamiętaj mnie
        </label>
        <br>
        <label>
            <p>Nie masz konta? <a href="${pageContext.request.contextPath}/user/signup">Zarejestruj się</a></p>
        </label>
    </div>
    <button class="btn btn-lg btn-primary" type="submit">Zaloguj</button>
    <p class="mt-5 mb-3 text-muted">Biblioteka &copy; 2019-2020</p>
</form>
</body>
</html>

