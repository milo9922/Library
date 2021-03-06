<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.entity.Book" %>
<%@ page import="com.milo.Library.repository.BookDao" %>
<%@ page import="com.milo.Library.repository.UserDao" %>
<%@ page import="java.util.List" %>

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
    <h2 style="text-align: center">Spis książek</h2>
    <br><br>
    <table id="books" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Tytuł</th>
            <th scope="col">Autor</th>
            <th scope="col">Strony</th>
            <%
                try {
                    int i = 0;
                    BookDao bookDao = new BookDao();
                    List<Book> allBooks = bookDao.getAllBooks(false);
                    UserDao userDao = new UserDao();
                    boolean isCurrentUserAdmin = userDao.isUserAdmin(userDao.getUserIdByName((String) session.getAttribute("user")));
                    if (isCurrentUserAdmin) {
            %>
            <th scope="col">Dodana przez</th>
            <th scope="col"></th>
            <%
                }
                while (i < allBooks.size()) {
            %>
        </tr>
        </thead>

        <tbody>
        <tr>
            <th scope="row"><%=allBooks.get(i).getTitle()%>
            </th>
            <th scope="row"><%=allBooks.get(i).getAuthor()%>
            </th>
            <th scope="row"><%=allBooks.get(i).getPagesNum()%>
            </th>
            <%
                if (isCurrentUserAdmin) {
            %>
            <th scope="row"><%=userDao.getUserNameById(allBooks.get(i).getAddedBy())%>
            </th>
            <th scope="row"><a
                    href="${pageContext.request.contextPath}/books/remove?id=<%=allBooks.get(i).getBookId()%>">Usuń</a>
            </th>
            <%
                }
            %>
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