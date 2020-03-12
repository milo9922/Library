<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <title>Dodaj</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container">
    <div class="py-5 text-center">
        <h2>Zaproponuj nową książkę</h2>
        <p class="lead">Wypełnij krótki formularz aby zaproponować dodanie nowej książki do biblioteki</p>
    </div>
    <br><br><br>

    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Zaproponuj nową książkę</h4>
        <form action="addBook" method="POST">
            <div class="row">
                <div class="text-align: center col-md-6 mb-3">
                    <label>Tytuł</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="Tytuł" maxlength="30"
                           required>
                </div>
                <div class="col-md-6 mb-3">
                    <label>Autor</label>
                    <input type="text" class="form-control" id="author" name="author" placeholder="Autor" maxlength="30"
                           required>
                </div>
                <div class="col-md-6 mb-3">
                    <label>Liczba stron</label>
                    <input type="number" class="form-control" id="pages" name="pages" placeholder="Liczba stron"
                           required>
                    <div class="invalid-feedback">
                        Nieprawidłowe dane!
                    </div>
                </div>
            </div>
            <div class="mb-3">
                <label>Wyjaśnij krótko dlaczego powinniśmy dodać właśnie ten tytuł</label>
                <input type="text" class="form-control" id="explenation" placeholder="Odpowiedź">
            </div>

            <br><br>
            <div class="button">
                <button type="submit" class="btn btn-secondary">Wyślij</button>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Powrót</a>
            </div>

        </form>


    </div>
</div>


<%
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    // String pagesNum = request.getParameter("pages");

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/3Q84ulcsc7", "3Q84ulcsc7", "zumqXjeFMY");
        PreparedStatement ps = conn.prepareStatement("INSERT INTO TB_BOOK(Title, Author) VALUES (?,?)");
        ps.setString(1, title);
        ps.setString(2, author);
        int x = ps.executeUpdate();

        if (x > 0) {
            out.println("Success!");
        } else {
            out.println("Fail!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
%>

<footer class="my-5 pt-5 text-muted text-center text-small">
    <p class="mb-1">&copy; 2017-2019 Biblioteka</p>
    <ul class="list-inline">
        <li class="list-inline-item"><a href="#">Privacy</a></li>
        <li class="list-inline-item"><a href="#">Terms</a></li>
        <li class="list-inline-item"><a href="#">Support</a></li>
    </ul>
</footer>
</body>
</html>