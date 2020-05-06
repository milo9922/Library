<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.entity.Book" %>
<%@ page import="com.milo.Library.repository.BookDao" %>
<%@ page import="com.milo.Library.service.UserService" %>
<%@ page import="java.util.List" %>

<%
    if (!new UserService().checkIfUserIsLogged(session)) {
        response.sendRedirect("http://localhost:8080/user/signin");
    }
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Spis książek</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="py-4">

<div class="container">
    <h2 style="text-align: center">Dostępne do wypożyczenia</h2>
    <br><br>
    <table id="books" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Tytul</th>
            <th scope="col">Autor</th>
            <th scope="col">Strony</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <%
            try {
                int i = 0;
                BookDao bookDao = new BookDao();
                List<Book> allBooks = bookDao.getAllBooks(true);
                while (i < allBooks.size()) {
        %>

        <tbody>
        <tr>
            <th scope="row"><%=allBooks.get(i).getTitle()%>
            </th>
            <th scope="row"><%=allBooks.get(i).getAuthor()%>
            </th>
            <th scope="row"><%=allBooks.get(i).getPagesNum()%>
            </th>
            <th scope="row"><a
                    href="${pageContext.request.contextPath}/books/BorrowBook?id=<%=allBooks.get(i).getBookId()%>">Wypożycz</a>
            </th>
        </tr>
        </tbody>

        <%
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