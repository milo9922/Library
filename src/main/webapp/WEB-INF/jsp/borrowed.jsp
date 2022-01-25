<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.entity.Book" %>
<%@ page import="com.milo.Library.repository.BookDao" %>
<%@ page import="com.milo.Library.repository.UserDao" %>
<%@ page import="com.milo.Library.service.UserService" %>
<%@ page import="java.util.List" %>

<%
    if (!new UserService().isUserLogged(session)) {
        response.sendRedirect("http://localhost:8081/user/signin");
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
    <h2 style="text-align: center">Aktualnie wypożyczone</h2>
    <br><br>
    <table id="books" class="table table-striped" style="background: #abdde5">
        <thead>
        <tr>
            <th scope="col">Tytuł</th>
            <th scope="col">Autor</th>
            <th scope="col">Strony</th>
            <th scope="col">Kod odbioru</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <%
            try {
                int i = 0;
                BookDao bookDao = new BookDao();
                List<Book> allBooks = bookDao.getAllBooks(false);
                Book currentBook;
                int currentUserId = new UserDao().getUserIdByName((String) session.getAttribute("user"));
                while (i < allBooks.size()) {
                    currentBook = allBooks.get(i);
                    if (currentBook.getBorrowedBy() == currentUserId) {
        %>

        <tbody>
        <tr>
            <th scope="row"><%=currentBook.getTitle()%>
            </th>
            <th scope="row"><%=currentBook.getAuthor()%>
            </th>
            <th scope="row"><%=currentBook.getPagesNum()%>
            </th>
            <th scope="row">
                <a class="btn btn-sm btn-light"
                   href="${pageContext.request.contextPath}/books/showQrCode?id=<%=currentBook.getBookId()%>">Pokaż</a>
                <!-- TODO Implementacja kodu QR przekazującego BorrowID w postaci UUID -->
            </th>
            <th scope="row"><a
                    class="btn btn-sm btn-light"
                    href="${pageContext.request.contextPath}/books/return?id=<%=currentBook.getBookId()%>">Zwróć</a>
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