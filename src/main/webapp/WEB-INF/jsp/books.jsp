<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
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
            <th scope="col">Id</th>
            <th scope="col">Tytul</th>
            <th scope="col">Autor</th>
            <th scope="col">Strony</th>
            <th scope="col">Wypozyczona przez (id)</th>
        </tr>
        </thead>
        <%
            String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7326292";
            String username = "sql7326292";
            String password = "xMj4Da1xbR";

            Connection connection;
            Statement statement;
            ResultSet resultSet;
            try {
                connection = DriverManager.getConnection(url, username, password);
                statement = connection.createStatement();
                String sql = "SELECT * FROM TB_BOOK";

                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
        %>

        <tbody>
        <tr>
            <th scope="row"><%=resultSet.getInt("BookID")%>
            </th>
            <th scope="row"><%=resultSet.getString("Title")%>
            </th>
            <th scope="row"><%=resultSet.getString("Author")%>
            </th>
            <th scope="row"><%=resultSet.getInt("PagesNum")%>
            </th>
            <th scope="row"><%=resultSet.getInt("UserID")%>
            </th>
        </tr>
        </tbody>

        <%
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