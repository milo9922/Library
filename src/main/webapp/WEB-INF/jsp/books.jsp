<%@ page import="java.sql.*" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>Grid Template · Bootstrap</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/grid/">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        .themed-grid-col {
            background-color: #abdde5;
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="grid.css" rel="stylesheet">
</head>
<body class="py-4">
<div class="container">


    <h2 style="text-align: center">Spis ksiazek</h2>
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

            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = DriverManager.getConnection(url, username, password);
                statement = connection.createStatement();
                String sql = "SELECT * FROM TB_BOOK";

                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
        %>

        <tbody>
        <tr bgcolor="#add8e6">
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


</body>
</html>