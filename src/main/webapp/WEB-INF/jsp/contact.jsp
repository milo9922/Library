<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.entity.User" %>
<%@ page import="com.milo.Library.repository.UserDao" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Spis użytkowników</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="py-4">

<div class="container">
    <h2 style="text-align: center">Kontakt</h2>
    <br><br>
    <table id="books" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Użytkownik (admin)</th>
            <th scope="col">Email</th>
        </tr>
        </thead>

        <%
            try {
                int i = 0;
                List<User> allBooks = new UserDao().getAllUsers();
                while (i < allBooks.size()) {
                    if (new UserDao().isUserAdmin(allBooks.get(i).getUserId())) {
        %>

        <tbody>
        <tr>
            <th scope="row"><%=allBooks.get(i).getLogin()%>
            </th>
            <th scope="row"><%=allBooks.get(i).getEmail()%>
            </th>
        </tr>
        </tbody>

        <%
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </table>
    <br>
    <div class="button">
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Powrót</a>
    </div>
</div>
</body>
</html>