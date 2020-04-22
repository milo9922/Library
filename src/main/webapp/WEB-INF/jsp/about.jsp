<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <title>O nas</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="d-flex flex-column h-100">
<main role="main" class="flex-shrink-0">
    <div class="container">
        <h1 class="mt-5">O nas</h1>
        <br>
        <p class="lead">Jesteśmy firmą, która stara się łączyć przyjemność czytania w domowym zaciszu i oszczędność
            zarówno czasu jak i pieniędzy.
            Korzystając z naszego serwisu nie musisz wychodzić z domu w celu znalezienia interesującej Cię książki,
            wystarczy założyć konto by cieszyć się bogatym, ciągle uzupełnianym o nowe tytuły, zbiorem.
            Wystarczy jedno kliknięcie, aby wypożyczyć interesującą Cię pozycję, a następnie odebrać ją w czynnej przez
            całą dobę bibliotece. Dodatkowo możliwe jest dodawanie przez użytkowników nowych książek, co z pewnością
            ułatwi naukę, pracę niejednej osobie.
            Zachęcamy do zapoznania się z aktualną listą!</p>
        <br>
        <a class="btn btn-dark" href="http://localhost:8080/books/showAll">Lista książek</a>
    </div>
</main>

<footer class="footer mt-auto py-3">
    <div class="container">
        <span class="text-muted"><a class="btn btn-dark"
                                    href="http://localhost:8080/">Powrót do strony głównej</a></span>
    </div>
</footer>
</body>
</html>