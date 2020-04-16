<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <title>Rejestracja</title>

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
    </style>

</head>
<body class="d-flex flex-column h-100">
<!-- Begin page content -->
<main role="main" class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">Niepowodzenie!</h1>
        <br>
        <p class="lead">Taki użytkownik istnieje już w bazie danych! Wprowadź inne dane lub zaloguj się na swoje
            konto.</p>
        <a href="http://localhost:8080/user/signup">Rejestracja</a>
        <br><br>
        <a href="http://localhost:8080/user/login">Logowanie</a>

    </div>

</main>

</body>
</html>