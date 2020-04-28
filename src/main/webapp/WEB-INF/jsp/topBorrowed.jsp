<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.milo.Library.entity.Book" %>
<%@ page import="com.milo.Library.service.BookService" %>
<%@ page import="java.util.List" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Najnowsze książki</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="py-4">

<div class="container">
    <h2 style="text-align: center">Najchętniej wypożyczane książki</h2>
    <br><br>
    <table id="books" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Tytuł</th>
            <th scope="col">Autor</th>
            <th scope="col">Strony</th>
            <th scope="col">Liczba wypożyczeń</th>
        </tr>
        </thead>
        <%
            try {
                int i = 0;
                List<Book> allBooks = new BookService().getMostOftenBorrowedBooks(5);
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
            <th scope="row">
                <%=allBooks.get(i).getNumberOfBorrows()%>
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